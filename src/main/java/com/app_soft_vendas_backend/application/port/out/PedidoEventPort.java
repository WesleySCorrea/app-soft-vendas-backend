package com.app_soft_vendas_backend.application.port.out;

import com.app_soft_vendas_backend.domain.Pedido;

public interface PedidoEventPort {

    void publicarPedidoCriado(Pedido pedido);
}
