package com.app_soft_vendas_backend.application.port.in;

import com.app_soft_vendas_backend.application.port.in.dto.request.CriarPedidoCommand;
import com.app_soft_vendas_backend.application.port.in.dto.response.PedidoResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoService implements PedidoUseCase {

    @Override
    public PedidoResponse criarPedido(CriarPedidoCommand pedido) {

        return null;
    }

    @Override
    public List<PedidoResponse> buscarPedidos() {
        return List.of();
    }
}
