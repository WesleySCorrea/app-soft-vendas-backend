package com.app_soft_vendas_backend.adapter.out.kafka;

import com.app_soft_vendas_backend.adapter.out.kafka.event.ItemPedidoEvent;
import com.app_soft_vendas_backend.adapter.out.kafka.event.PedidoCriadoEvent;
import com.app_soft_vendas_backend.application.port.out.PedidoEventPort;
import com.app_soft_vendas_backend.domain.Pedido;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PedidoEventAdapter implements PedidoEventPort {

    private final KafkaTemplate<String, Object> kafkaTemplate;

    public PedidoEventAdapter(KafkaTemplate<String, Object> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public void publicarPedidoCriado(Pedido pedido) {

        List<ItemPedidoEvent> itens = pedido.getItens().stream()
                .map(i -> new ItemPedidoEvent(i.produtoId(), i.quantidade()))
                .toList();

        PedidoCriadoEvent event = new PedidoCriadoEvent(pedido.getId(), itens);

        kafkaTemplate.send("pedido-criado", pedido.getId().toString(), event);
    }
}
