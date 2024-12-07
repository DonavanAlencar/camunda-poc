package com.example.poc.bpm.delegate;

import com.example.poc.dto.Pedido;
import com.example.poc.service.Impl.ServiceApiLogisticaImpl;
import com.example.poc.service.ServiceApiLogistica;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

public class RecebeResultadoEntregaDelegate implements JavaDelegate {

    private Pedido pedido;

    private ServiceApiLogistica serviceApiLogistica;

    public RecebeResultadoEntregaDelegate(){
        pedido = new Pedido();
        serviceApiLogistica = new ServiceApiLogisticaImpl();
    }

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        pedido = serviceApiLogistica.solicitaResultadoEntrega();
        if(pedido.getDeliveryStatus().equals("delivered")){

        }
    }
}
