package com.app_soft_vendas_backend.adapter.in.web.dto.request;

public record PedidoItemRequest(
        Long produtoId,
        Integer quantidade
) {}
