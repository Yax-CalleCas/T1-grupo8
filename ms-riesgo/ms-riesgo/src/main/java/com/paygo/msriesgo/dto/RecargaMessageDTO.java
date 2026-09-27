package com.paygo.msriesgo.dto;

import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class RecargaMessageDTO {
    private Long idRecarga;
    private Long idTarjeta;
    private BigDecimal saldoDisponible;
    private BigDecimal montoRecarga;
    private LocalDateTime fechaRecarga;
}