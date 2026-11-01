package com.app_soft_vendas_backend.adapter.in.kafka.event;

import java.util.List;

public record PedidoResultadoEvent(
        Long pedidoId,
        boolean reservado,
        String motivo,
        List<ItemReservadoEvent> itens
) {
}
