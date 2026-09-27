package com.paygo.ms_tarjetas.dto;

import lombok.Builder;
import lombok.Data;
import java.math.BigDecimal;

@Data
@Builder
public class TarjetaResponseDTO {
    private Long idTarjeta;
    private String nomTitular;
    private BigDecimal saldoAsignado;
    private BigDecimal saldoDisponible;
}