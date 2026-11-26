package com.f1dpr.client;


import com.f1dpr.dto.ApiDriverResponseDTO;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

@Component
public class ApiClient {

    private final RestClient restClient;

    public ApiClient() {
        this.restClient = RestClient.builder()
                .baseUrl("https://api.jolpi.ca/ergast/f1")
                .defaultHeader("Accept", "application/json")
                .build();
    }

    public ApiDriverResponseDTO buscarPilotosPorTemporada(int ano) {
        return restClient.get()
                .uri("/{ano}/drivers/", ano)
                .retrieve()
                .body(ApiDriverResponseDTO.class);
    }
}