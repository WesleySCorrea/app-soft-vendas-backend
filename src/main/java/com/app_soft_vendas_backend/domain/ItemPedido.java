package com.app_soft_vendas_backend.domain;

import java.math.BigDecimal;

public record ItemPedido(

        Long produtoId,
        String nomeProduto,
        BigDecimal precoUnitario,
        int quantidade
) {

    public BigDecimal subtotal() {

        return precoUnitario.multiply(BigDecimal.valueOf(quantidade));
    }
}
