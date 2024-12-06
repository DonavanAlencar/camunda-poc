package com.example.poc.bpm.delegate;

import com.example.poc.service.Impl.ServiceApiLogisticaImpl;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import com.example.poc.service.ServiceApiLogistica;
import org.springframework.beans.factory.annotation.Autowired;

public class ConsultaDisponibilidadeDelegate implements JavaDelegate {

    @Autowired
    private ServiceApiLogistica serviceApiLogistica;

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        serviceApiLogistica = new ServiceApiLogisticaImpl();
        execution.setVariable("productId", "xpto");
        serviceApiLogistica.ConsultaDisponibilidade((String) execution.getVariable("productId"));
    }
}
