package com.app_soft_vendas_backend.application.port.in.dto.request;

public record ItemCommand(
        Long produtoId,
        int quantidade
) {
}
