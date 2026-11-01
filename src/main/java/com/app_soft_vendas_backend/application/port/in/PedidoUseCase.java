package com.app_soft_vendas_backend.application.port.in;

import com.app_soft_vendas_backend.application.port.in.dto.request.CriarPedidoCommand;
import com.app_soft_vendas_backend.application.port.in.dto.request.PedidoResultadoCommand;
import com.app_soft_vendas_backend.application.port.in.dto.response.PedidoResponse;

import java.util.List;

public interface PedidoUseCase {

    PedidoResponse criarPedido(CriarPedidoCommand pedido);

    void atualizarStatus(PedidoResultadoCommand command);

    List<PedidoResponse> buscarPedidos();
}
