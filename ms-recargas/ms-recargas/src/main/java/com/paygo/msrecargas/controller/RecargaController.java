package com.paygo.msrecargas.controller;

import com.paygo.msrecargas.dto.RecargaRequestDTO;
import com.paygo.msrecargas.dto.RecargaResponseDTO;
import com.paygo.msrecargas.service.RecargaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/recargas")
@RequiredArgsConstructor
public class RecargaController {

    private final RecargaService recargaService;

    @PostMapping
    public ResponseEntity<RecargaResponseDTO> registrarRecarga(@RequestBody RecargaRequestDTO request) {
        RecargaResponseDTO response = recargaService.registrarRecarga(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}