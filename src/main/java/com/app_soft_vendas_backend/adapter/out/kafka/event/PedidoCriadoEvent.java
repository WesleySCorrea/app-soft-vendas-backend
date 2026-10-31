package com.app_soft_vendas_backend.adapter.out.kafka.event;

import java.util.List;

public record PedidoCriadoEvent(
        Long pedidoId,
        List<ItemPedidoEvent> itens
) {
}
