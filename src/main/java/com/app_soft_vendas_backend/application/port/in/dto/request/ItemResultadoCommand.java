package com.app_soft_vendas_backend.application.port.in.dto.request;

import java.math.BigDecimal;

public record ItemResultadoCommand (
        Long produtoId,
        String nomeProduto,
        BigDecimal precoUnitario,
        int quantidade
) {
}