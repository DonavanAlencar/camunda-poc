package com.example.poc.bpm.delegate;

import com.example.poc.dto.Produto;
import com.example.poc.service.Impl.ServiceApiLogisticaImpl;
import com.example.poc.service.ServiceApiLogistica;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

public class AtualizaEstoqueDelegate implements JavaDelegate {

    private Produto produto;

    private ServiceApiLogistica serviceApiLogistica;

    public AtualizaEstoqueDelegate(){
        produto = new Produto();
        serviceApiLogistica = new ServiceApiLogisticaImpl();
    }

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        produto.setProductId((String) execution.getVariable("productId"));
        produto.setAvailableQuantity(100);
        serviceApiLogistica.atualizaEstoque(produto);
    }
}
