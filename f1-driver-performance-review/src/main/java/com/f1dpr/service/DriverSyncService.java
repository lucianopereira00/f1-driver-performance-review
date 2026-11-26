package com.f1dpr.service;

import com.f1dpr.client.ApiClient;
import com.f1dpr.dto.ApiDriverResponseDTO;
import com.f1dpr.dto.ApiDriverResponseDTO.DriverDTO;
import com.f1dpr.model.Driver;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DriverSyncService {

    private ApiClient apiClient = new ApiClient();

    public DriverSyncService() {
        this.apiClient = apiClient;
    }

    public List<Driver> importarPilotos(int ano) {
        ApiDriverResponseDTO resposta = apiClient.buscarPilotosPorTemporada(ano);
        List<DriverDTO> driversExternos = resposta.mrData().driverTable().drivers();

        return driversExternos.stream().map(dto -> {
            Driver driver = new Driver();
            driver.setName(dto.givenName() + " " + dto.familyName());
            return driver;
        }).toList();
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }
}