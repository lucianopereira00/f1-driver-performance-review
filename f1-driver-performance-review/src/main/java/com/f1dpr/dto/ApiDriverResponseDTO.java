package com.f1dpr.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;


@JsonIgnoreProperties(ignoreUnknown = true)
public record ApiDriverResponseDTO(
        @JsonProperty("MRData") MRData mrData
) {
    @JsonIgnoreProperties(ignoreUnknown = true)
    public record MRData(
            @JsonProperty("DriverTable") DriverTable driverTable
    ) {}

    @JsonIgnoreProperties(ignoreUnknown = true)
    public record DriverTable(
            String season,
            @JsonProperty("Drivers") List<DriverDTO> drivers
    ) {}

    @JsonIgnoreProperties(ignoreUnknown = true)
    public record DriverDTO(
            String driverId,
            String permanentNumber,
            String code,
            String givenName,
            String familyName,
            String dateOfBirth,
            String nationality
    ) {}
}