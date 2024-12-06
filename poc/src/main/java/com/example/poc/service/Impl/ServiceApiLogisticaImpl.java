package com.example.poc.service.Impl;

import com.example.poc.dto.Produto;
import com.example.poc.service.ServiceApiLogistica;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

public class ServiceApiLogisticaImpl implements ServiceApiLogistica {
    private static final String BASE_URL_CONSULTA_DISP = "https://camunda-lab-get-order.azurewebsites.net/api/stock/xpto123?code=HrUq2PXFE9DcoNVi5w8zsieOEFtRT3T7Fsp3CfZvsOu5AzFuKy5yBg%3D%3D";

    private RestTemplate restTemplate = null;

    public ServiceApiLogisticaImpl(){
        restTemplate = new RestTemplate();
    }

    @Override
    public Produto ConsultaDisponibilidade(String productId) {
        String url = BASE_URL_CONSULTA_DISP;

        HttpHeaders headers = new HttpHeaders();
        headers.set("code", "HrUq2PXFE9DcoNVi5w8zsieOEFtRT3T7Fsp3CfZvsOu5AzFuKy5yBg%3D%3D");

        try {
            ResponseEntity<String> response = restTemplate.getForEntity(url, String.class, headers);

            if (response.getStatusCode() == HttpStatus.OK) {
                return new Produto(){ };
            } else {
                throw new RuntimeException("Unexpected HTTP status: " + response.getStatusCode());
            }
        } catch (RestClientException e) {
            throw new RuntimeException("API call failed: " + e.getMessage(), e);
        }
    }
}
