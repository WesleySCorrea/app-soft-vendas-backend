package com.app_soft_vendas_backend.application.port.out;

import com.app_soft_vendas_backend.domain.Pedido;

import java.util.Optional;

public interface PedidoRepositoryPort {

    Pedido salvar(Pedido pedido);

    Optional<Pedido> buscarPorId(Long id);
}
