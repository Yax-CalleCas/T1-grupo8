package com.paygo.msrecargas.dto;

import lombok.Builder;
import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
public class RecargaResponseDTO {
    private Long idRecarga;
    private Long idTarjeta;
    private BigDecimal saldoDisponible;
    private BigDecimal montoRecarga;
    private LocalDateTime fechaRecarga;
}