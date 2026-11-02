package com.app_soft_vendas_backend.adapter.out.persistence.repository;

import com.app_soft_vendas_backend.adapter.out.persistence.entity.PedidoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PedidoJpaRepository extends JpaRepository<PedidoEntity, Long> {

    List<PedidoEntity> findByUsuarioId(String usuarioId);
}
