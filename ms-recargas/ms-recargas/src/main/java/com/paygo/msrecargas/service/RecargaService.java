package com.paygo.msrecargas.service;

import com.paygo.msrecargas.client.TarjetaFeignClient;
import com.paygo.msrecargas.config.RabbitMQConfig;
import com.paygo.msrecargas.dto.RecargaRequestDTO;
import com.paygo.msrecargas.dto.RecargaResponseDTO;
import com.paygo.msrecargas.dto.TarjetaResponseDTO;
import com.paygo.msrecargas.entity.Recarga;
import com.paygo.msrecargas.repository.RecargaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class RecargaService {

    private final RecargaRepository recargaRepository;
    private final TarjetaFeignClient tarjetaFeignClient;
    private final RabbitTemplate rabbitTemplate;

    public RecargaResponseDTO registrarRecarga(RecargaRequestDTO request) {
        TarjetaResponseDTO tarjeta = tarjetaFeignClient.obtenerTarjetaPorId(request.getIdTarjeta());

        Recarga recarga = Recarga.builder()
                .idTarjeta(tarjeta.getIdTarjeta())
                .saldoDisponible(tarjeta.getSaldoDisponible())
                .montoRecarga(request.getMontoRecarga())
                .fechaRecarga(LocalDateTime.now())
                .build();

        Recarga savedRecarga = recargaRepository.save(recarga);

        RecargaResponseDTO response = RecargaResponseDTO.builder()
                .idRecarga(savedRecarga.getIdRecarga())
                .idTarjeta(savedRecarga.getIdTarjeta())
                .saldoDisponible(savedRecarga.getSaldoDisponible())
                .montoRecarga(savedRecarga.getMontoRecarga())
                .fechaRecarga(savedRecarga.getFechaRecarga())
                .build();

        rabbitTemplate.convertAndSend(RabbitMQConfig.QUEUE_NAME, response);

        return response;
    }
}