package com.app_soft_vendas_backend.application.port.in.dto.request;

import java.util.List;

public record CriarPedidoCommand(
        String usuarioId,
        List<ItemCommand> itens
) {
}
