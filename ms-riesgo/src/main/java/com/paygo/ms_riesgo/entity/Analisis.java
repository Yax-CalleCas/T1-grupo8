package com.paygo.ms_riesgo.entity;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "analisis")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Analisis {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAnalisis;
    private Long idRecarga;
    private Long idTarjeta;
    private BigDecimal saldoDisponible;
    private BigDecimal montoRecarga;
    private LocalDateTime fechaRecarga;
    private String situacion;
}