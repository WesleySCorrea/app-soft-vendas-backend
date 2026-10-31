package com.app_soft_vendas_backend.adapter.out.kafka.event;

public record ItemPedidoEvent(
        Long produtoId,
        int quantidade
) {
}
