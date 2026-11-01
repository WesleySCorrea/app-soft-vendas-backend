package com.app_soft_vendas_backend.application.service;

import com.app_soft_vendas_backend.application.port.in.PedidoUseCase;
import com.app_soft_vendas_backend.application.port.in.dto.request.CriarPedidoCommand;
import com.app_soft_vendas_backend.application.port.in.dto.request.PedidoResultadoCommand;
import com.app_soft_vendas_backend.application.port.in.dto.response.PedidoResponse;
import com.app_soft_vendas_backend.application.port.out.PedidoEventPort;
import com.app_soft_vendas_backend.application.port.out.PedidoRepositoryPort;
import com.app_soft_vendas_backend.domain.ItemPedido;
import com.app_soft_vendas_backend.domain.Pedido;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoService implements PedidoUseCase {

    private final PedidoRepositoryPort pedidoRepositoryPort;
    private final PedidoEventPort pedidoEventPort;

    public PedidoService(PedidoRepositoryPort pedidoRepositoryPort, PedidoEventPort pedidoEventPort) {
        this.pedidoRepositoryPort = pedidoRepositoryPort;
        this.pedidoEventPort = pedidoEventPort;
    }

    @Override
    public PedidoResponse criarPedido(CriarPedidoCommand command) {

        List<ItemPedido> itens = command.itens().stream()
                .map(i -> new ItemPedido(i.produtoId(), null, null, i.quantidade()))
                .toList();

        Pedido pedido = Pedido.novoPedido(command.usuarioId(), itens);

        Pedido salvo = pedidoRepositoryPort.salvar(pedido);

        pedidoEventPort.publicarPedidoCriado(salvo);

        return new PedidoResponse(salvo.getId(), salvo.getStatus().name(), salvo.getTotal(), salvo.getCriadoEm());
    }

    @Override
    @Transactional
    public void atualizarStatus(PedidoResultadoCommand command) {

        Pedido pedido = pedidoRepositoryPort.buscarPorId(command.pedidoId())
                .orElseThrow(() -> new IllegalArgumentException("Pedido " + command.pedidoId() + " não encontrado"));

        List<ItemPedido> itens = command.itens().stream().map(item ->
                    new ItemPedido(item.produtoId(), item.nomeProduto(), item.precoUnitario(), item.quantidade())
                ).toList();

        if (command.reservado()) {
            pedido.confirmar(itens);
        } else {
            pedido.cancelar();
        }

        pedidoRepositoryPort.salvar(pedido);
    }

    @Override
    public List<PedidoResponse> buscarPedidos() {
        return List.of();
    }
}
