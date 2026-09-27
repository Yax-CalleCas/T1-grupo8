package com.paygo.msrecargas.entity;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "recargas")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Recarga {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRecarga;
    private Long idTarjeta;
    private BigDecimal saldoDisponible;
    private BigDecimal montoRecarga;
    private LocalDateTime fechaRecarga;
}