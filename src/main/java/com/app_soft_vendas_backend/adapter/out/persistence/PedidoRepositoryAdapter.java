package com.app_soft_vendas_backend.adapter.out.persistence;

import com.app_soft_vendas_backend.adapter.out.persistence.entity.PedidoEntity;
import com.app_soft_vendas_backend.adapter.out.persistence.mapper.PedidoPersistenceMapper;
import com.app_soft_vendas_backend.adapter.out.persistence.repository.PedidoJpaRepository;
import com.app_soft_vendas_backend.application.port.out.PedidoRepositoryPort;
import com.app_soft_vendas_backend.domain.Pedido;
import org.springframework.stereotype.Repository;

@Repository
public class PedidoRepositoryAdapter implements PedidoRepositoryPort {

    private final PedidoJpaRepository jpaRepository;
    private final PedidoPersistenceMapper mapper;

    public PedidoRepositoryAdapter(PedidoJpaRepository jpaRepository, PedidoPersistenceMapper mapper) {
        this.jpaRepository = jpaRepository;
        this.mapper = mapper;
    }

    @Override
    public Pedido salvar(Pedido pedido) {

        PedidoEntity salvo = jpaRepository.save(mapper.toEntity(pedido));

        return mapper.toDomain(salvo);
    }
}
