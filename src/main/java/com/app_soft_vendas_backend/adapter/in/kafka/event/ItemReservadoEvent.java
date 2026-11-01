package com.app_soft_vendas_backend.adapter.in.kafka.event;

import java.math.BigDecimal;

public record ItemReservadoEvent(
        Long produtoId,
        String nome,
        BigDecimal preco,
        int quantidade
) {
}