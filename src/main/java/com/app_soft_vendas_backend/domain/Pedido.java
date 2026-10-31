package com.app_soft_vendas_backend.domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class Pedido {

    private Long id;
    private String usuarioId;
    private StatusPedido status;
    private List<ItemPedido> itens;
    private BigDecimal total;
    private final LocalDateTime criadoEm = LocalDateTime.now();

    public static Pedido novoPedido(String usuarioId, List<ItemPedido> itens) {

        if (itens == null || itens.isEmpty()) throw new IllegalArgumentException("Pedido sem itens");

        Pedido p = new Pedido();
        p.usuarioId = usuarioId;
        p.itens = itens;
        p.status = StatusPedido.PENDENTE;
        p.total = itens.stream().map(ItemPedido::subtotal).reduce(BigDecimal.ZERO, BigDecimal::add);

        return p;
    }
}