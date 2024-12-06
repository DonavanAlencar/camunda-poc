package com.example.poc.service;

import com.example.poc.dto.Produto;

public interface ServiceApiLogistica {
    public Produto ConsultaDisponibilidade(String productId);
}
