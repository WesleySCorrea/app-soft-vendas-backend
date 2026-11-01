package com.app_soft_vendas_backend.adapter.in.kafka;

import com.app_soft_vendas_backend.adapter.in.kafka.event.PedidoResultadoEvent;
import com.app_soft_vendas_backend.application.port.in.PedidoUseCase;
import com.app_soft_vendas_backend.application.port.in.dto.request.ItemResultadoCommand;
import com.app_soft_vendas_backend.application.port.in.dto.request.PedidoResultadoCommand;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PedidoResultadoConsumer {

    private final PedidoUseCase pedidoUseCase;

    public PedidoResultadoConsumer(PedidoUseCase pedidoUseCase) {
        this.pedidoUseCase = pedidoUseCase;
    }

    @KafkaListener(topics = "pedido-resultado")
    public void consumir(PedidoResultadoEvent event) {

        List<ItemResultadoCommand> itens = event.itens().stream()
                .map(i -> new ItemResultadoCommand(i.produtoId(), i.nome(), i.preco(), i.quantidade()))
                .toList();

        pedidoUseCase.atualizarStatus(new PedidoResultadoCommand(event.pedidoId(), event.reservado(), itens));
    }
}
