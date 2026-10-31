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
    private LocalDateTime criadoEm = LocalDateTime.now();

    public static Pedido novoPedido(String usuarioId, List<ItemPedido> itens) {
        if (itens == null || itens.isEmpty()) throw new IllegalArgumentException("Pedido sem itens");

        Pedido p = new Pedido();
        p.usuarioId = usuarioId;
        p.itens = itens;
        p.status = StatusPedido.PENDENTE;
        return p;
    }

    public static Pedido reconstruir(Long id, String usuarioId, StatusPedido status, BigDecimal total, LocalDateTime criadoEm, List<ItemPedido> itens) {
        Pedido p = new Pedido();
        p.id = id;
        p.usuarioId = usuarioId;
        p.status = status;
        p.total = total;
        p.criadoEm = criadoEm;
        p.itens = itens;
        return p;
    }

    public void confirmar(List<ItemPedido> itensComPreco) {
        this.itens = itensComPreco;
        this.total = itensComPreco.stream().map(ItemPedido::subtotal).reduce(BigDecimal.ZERO, BigDecimal::add);
        this.status = StatusPedido.CONFIRMADO;
    }

    public void cancelar() {
        this.status = StatusPedido.CANCELADO;
    }

    public Long getId() {
        return id;
    }

    public String getUsuarioId() {
        return usuarioId;
    }

    public StatusPedido getStatus() {
        return status;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public LocalDateTime getCriadoEm() {
        return criadoEm;
    }

    public List<ItemPedido> getItens() {
        return itens;
    }
}