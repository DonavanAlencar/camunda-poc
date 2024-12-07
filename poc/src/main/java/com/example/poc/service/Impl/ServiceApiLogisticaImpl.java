package com.example.poc.service.Impl;

import com.example.poc.dto.Pedido;
import com.example.poc.dto.Produto;
import com.example.poc.service.ServiceApiLogistica;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

public class ServiceApiLogisticaImpl implements ServiceApiLogistica {
    private static final String BASE_URL_CONSULTA_DISP = "";

    private static final String BASE_URL_ATUALIZA_ESTOQUE= "";

    private static final String BASE_URL_SOLICITA_PEDIDO= "";

    private RestTemplate restTemplate = null;

    public ServiceApiLogisticaImpl(){
        restTemplate = new RestTemplate();
    }

    @Override
    public Produto consultaDisponibilidade(String productId) {
        String url = BASE_URL_CONSULTA_DISP;

        try {
            ResponseEntity<Produto> response = restTemplate.getForEntity(url, Produto.class);

            if (response.getStatusCode() == HttpStatus.OK) {
                return response.getBody();
            } else {
                throw new RuntimeException("Unexpected HTTP status: " + response.getStatusCode());
            }
        } catch (RestClientException e) {
            throw new RuntimeException("API call failed: " + e.getMessage(), e);
        }
    }

    @Override
    public void atualizaEstoque(Produto produto) {
        String url = BASE_URL_ATUALIZA_ESTOQUE;
        try {
            ResponseEntity<HttpStatus> response = restTemplate.postForEntity(url, produto, HttpStatus.class);
        } catch (RestClientException e) {
            throw new RuntimeException("API call failed: " + e.getMessage(), e);
        }
    }

    @Override
    public void solicitaEntregaPedido(Pedido pedido) {
        String url = BASE_URL_SOLICITA_PEDIDO;
        try {
            ResponseEntity<HttpStatus> response = restTemplate.postForEntity(url, pedido, HttpStatus.class);
        } catch (RestClientException e) {
            throw new RuntimeException("API call failed: " + e.getMessage(), e);
        }
    }

    @Override
    public Pedido solicitaResultadoEntrega() {
        return null;
    }
}
