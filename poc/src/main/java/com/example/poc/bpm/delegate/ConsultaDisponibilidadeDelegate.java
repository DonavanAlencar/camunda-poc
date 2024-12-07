package com.example.poc.bpm.delegate;

import com.example.poc.dto.Produto;
import com.example.poc.service.Impl.ServiceApiLogisticaImpl;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import com.example.poc.service.ServiceApiLogistica;
import org.springframework.beans.factory.annotation.Autowired;

public class ConsultaDisponibilidadeDelegate implements JavaDelegate {

    @Autowired
    private ServiceApiLogistica serviceApiLogistica;

    private Produto produto;

    public ConsultaDisponibilidadeDelegate(){
        this.serviceApiLogistica = new ServiceApiLogisticaImpl();
        this.produto = new Produto();
    }

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        execution.setVariable("productId", "xpto");
        produto = serviceApiLogistica.consultaDisponibilidade((String) execution.getVariable("productId"));

        execution.setVariable("productId", produto.getProductId());
        execution.setVariable("availableQuantity", produto.getAvailableQuantity());
    }
}
