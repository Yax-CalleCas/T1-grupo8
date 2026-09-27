package com.paygo.msrecargas.dto;

import lombok.Data;
import java.math.BigDecimal;

@Data
public class RecargaRequestDTO {
    private Long idTarjeta;
    private BigDecimal montoRecarga;
}