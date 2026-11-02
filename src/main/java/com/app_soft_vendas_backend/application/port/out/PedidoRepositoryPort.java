package com.app_soft_vendas_backend.application.port.out;

import com.app_soft_vendas_backend.domain.Pedido;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface PedidoRepositoryPort {

    Pedido salvar(Pedido pedido);

    Optional<Pedido> buscarPorId(Long id);

    Page<Pedido> buscarPorUsuario(Pageable page, String usurarioId);
}
