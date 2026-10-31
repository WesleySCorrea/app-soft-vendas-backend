package com.app_soft_vendas_backend.application.port.in.dto.response;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record PedidoResponse(
        Long id,
        String status,
        BigDecimal total,
        LocalDateTime criadoEm
) {
}