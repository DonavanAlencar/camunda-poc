package com.example.poc.bpm.delegate;

import com.example.poc.dto.Pedido;
import com.example.poc.service.Impl.ServiceApiLogisticaImpl;
import com.example.poc.service.ServiceApiLogistica;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;

public class SolicitaEntregaPedidoDelegate implements JavaDelegate {
    @Autowired
    private ServiceApiLogistica serviceApiLogistica;

    private Pedido pedido;

    public SolicitaEntregaPedidoDelegate(){
        this.serviceApiLogistica = new ServiceApiLogisticaImpl();
        this.pedido = new Pedido();
    }

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        pedido.setOrderId("ABCD1242");
        pedido.setProductId((String) execution.getVariable("productId"));
        pedido.setAvailableQuantity(100);

        serviceApiLogistica.solicitaEntregaPedido(pedido);

        execution.setVariable("orderId", pedido.getOrderId());
    }
}
