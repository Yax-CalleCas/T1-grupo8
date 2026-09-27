package com.paygo.msriesgo.controller;

import com.paygo.msriesgo.entity.Analisis;
import com.paygo.msriesgo.repository.AnalisisRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/analisis")
@RequiredArgsConstructor
public class AnalisisController {

    private final AnalisisRepository analisisRepository;

    @GetMapping
    public ResponseEntity<List<Analisis>> listarAnalisis() {
        return ResponseEntity.ok(analisisRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Analisis> obtenerPorId(@PathVariable Long id) {
        return analisisRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}