package com.paygo.msriesgo.consumer;

import com.paygo.msriesgo.dto.RecargaMessageDTO;
import com.paygo.msriesgo.entity.Analisis;
import com.paygo.msriesgo.repository.AnalisisRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
@RequiredArgsConstructor
public class RiesgoConsumer {

    private final AnalisisRepository analisisRepository;

    @RabbitListener(queues = "calle_queue")
    public void consumirRecarga(RecargaMessageDTO mensaje) {
        // Validación del 70% del saldo disponible
        BigDecimal limite = mensaje.getSaldoDisponible().multiply(new BigDecimal("0.70"));

        // Si el monto de la recarga es menor o igual al 70%, es "Aprobada", de lo contrario "Observada"
        String situacion = mensaje.getMontoRecarga().compareTo(limite) <= 0 ? "Aprobada" : "Observada";

        Analisis analisis = Analisis.builder()
                .idRecarga(mensaje.getIdRecarga())
                .idTarjeta(mensaje.getIdTarjeta())
                .saldoDisponible(mensaje.getSaldoDisponible())
                .montoRecarga(mensaje.getMontoRecarga())
                .fechaRecarga(mensaje.getFechaRecarga())
                .situacion(situacion)
                .build();

        analisisRepository.save(analisis);
    }
}