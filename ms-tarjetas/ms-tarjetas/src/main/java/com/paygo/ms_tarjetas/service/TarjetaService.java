package com.paygo.ms_tarjetas.service;

import com.paygo.ms_tarjetas.dto.TarjetaResponseDTO;
import com.paygo.ms_tarjetas.entity.Tarjeta;
import com.paygo.ms_tarjetas.repository.TarjetaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TarjetaService {

    private final TarjetaRepository tarjetaRepository;

    public List<TarjetaResponseDTO> listarTodas() {
        return tarjetaRepository.findAll().stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    public TarjetaResponseDTO buscarPorId(Long id) {
        Tarjeta tarjeta = tarjetaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tarjeta no encontrada con ID: " + id));
        return mapToDTO(tarjeta);
    }

    private TarjetaResponseDTO mapToDTO(Tarjeta tarjeta) {
        return TarjetaResponseDTO.builder()
                .idTarjeta(tarjeta.getIdTarjeta())
                .nomTitular(tarjeta.getNomTitular())
                .saldoAsignado(tarjeta.getSaldoAsignado())
                .saldoDisponible(tarjeta.getSaldoDisponible())
                .build();
    }
}