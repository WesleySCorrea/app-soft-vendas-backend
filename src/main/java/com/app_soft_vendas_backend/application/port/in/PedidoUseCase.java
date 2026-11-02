package com.app_soft_vendas_backend.application.port.in;

import com.app_soft_vendas_backend.application.port.in.dto.request.CriarPedidoCommand;
import com.app_soft_vendas_backend.application.port.in.dto.request.PedidoResultadoCommand;
import com.app_soft_vendas_backend.application.port.in.dto.response.PedidoResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PedidoUseCase {

    PedidoResponse criarPedido(CriarPedidoCommand pedido);

    void atualizarStatus(PedidoResultadoCommand command);

    Page<PedidoResponse> buscarPedidos(Pageable page, String usuarioId);
}
