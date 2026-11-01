package com.app_soft_vendas_backend.application.port.in.dto.request;

import com.app_soft_vendas_backend.domain.ItemPedido;

import java.util.List;

public record PedidoResultadoCommand(
        Long pedidoId,
        boolean reservado,
        List<ItemResultadoCommand> itens
) {
}