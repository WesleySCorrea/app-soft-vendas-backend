package com.app_soft_vendas_backend.adapter.in.web.dto;

import com.app_soft_vendas_backend.adapter.in.web.dto.request.PedidoItemRequest;

import java.util.List;

public record PedidoRequest(
        List<PedidoItemRequest> itens
) {}
