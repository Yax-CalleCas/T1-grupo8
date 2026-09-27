package com.paygo.msrecargas.client;

import com.paygo.msrecargas.dto.TarjetaResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "tarjeta-client", url = "http://localhost:8080")
public interface TarjetaFeignClient {

    @GetMapping("/api/tarjetas/{id}")
    TarjetaResponseDTO obtenerTarjetaPorId(@PathVariable("id") Long id);
}