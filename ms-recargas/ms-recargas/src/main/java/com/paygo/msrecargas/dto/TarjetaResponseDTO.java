package com.paygo.msrecargas.dto;

import lombok.Data;
import java.math.BigDecimal;

@Data
public class TarjetaResponseDTO {
    private Long idTarjeta;
    private String nomTitular;
    private BigDecimal saldoAsignado;
    private BigDecimal saldoDisponible;
}