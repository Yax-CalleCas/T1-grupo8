package com.paygo.ms_riesgo.consumer;

import com.paygo.ms_riesgo.dto.RecargaMessageDTO;
import com.paygo.ms_riesgo.entity.Analisis;
import com.paygo.ms_riesgo.repository.AnalisisRepository;
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
        BigDecimal limite = mensaje.getSaldoDisponible().multiply(new BigDecimal("0.70"));

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