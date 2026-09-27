package com.paygo.ms_tarjetas.controller;

import com.paygo.ms_tarjetas.dto.TarjetaResponseDTO;
import com.paygo.ms_tarjetas.service.TarjetaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/tarjetas")
@RequiredArgsConstructor
public class TarjetaController {

    private final TarjetaService tarjetaService;

    @GetMapping
    public ResponseEntity<List<TarjetaResponseDTO>> listarTarjetas() {
        return ResponseEntity.ok(tarjetaService.listarTodas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TarjetaResponseDTO> consultarPorId(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(tarjetaService.buscarPorId(id));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}