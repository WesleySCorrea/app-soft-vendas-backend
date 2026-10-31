package com.app_soft_vendas_backend.adapter.out.persistence.mapper;

import com.app_soft_vendas_backend.adapter.out.persistence.entity.ItemPedidoEntity;
import com.app_soft_vendas_backend.adapter.out.persistence.entity.PedidoEntity;
import com.app_soft_vendas_backend.domain.ItemPedido;
import com.app_soft_vendas_backend.domain.Pedido;
import com.app_soft_vendas_backend.domain.StatusPedido;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PedidoPersistenceMapper {

    public PedidoEntity toEntity(Pedido pedido) {
        PedidoEntity entity = new PedidoEntity();
        entity.setId(pedido.getId());
        entity.setUsuarioId(pedido.getUsuarioId());
        entity.setStatus(pedido.getStatus().name());
        entity.setTotal(pedido.getTotal());
        entity.setCriadoEm(pedido.getCriadoEm());

        for (ItemPedido item : pedido.getItens()) {
            ItemPedidoEntity itemEntity = new ItemPedidoEntity();
            itemEntity.setPedido(entity);
            itemEntity.setProdutoId(item.produtoId());
            itemEntity.setNomeProduto(item.nomeProduto());
            itemEntity.setPrecoUnitario(item.precoUnitario());
            itemEntity.setQuantidade(item.quantidade());
            entity.getItens().add(itemEntity);
        }
        return entity;
    }

    public Pedido toDomain(PedidoEntity entity) {
        List<ItemPedido> itens = entity.getItens().stream()
                .map(i -> new ItemPedido(i.getProdutoId(), null, null, i.getQuantidade()))
                .toList();

        return Pedido.reconstruir(entity.getId(), entity.getUsuarioId(),
                StatusPedido.valueOf(entity.getStatus()), entity.getTotal(), entity.getCriadoEm(), itens);
    }
}