package com.example.poc.service;

import com.example.poc.dto.Pedido;
import com.example.poc.dto.Produto;

public interface ServiceApiLogistica {
    public Produto consultaDisponibilidade(String productId);

    public void atualizaEstoque(Produto produto);

    public void solicitaEntregaPedido(Pedido pedido);

    public Pedido solicitaResultadoEntrega();
}
