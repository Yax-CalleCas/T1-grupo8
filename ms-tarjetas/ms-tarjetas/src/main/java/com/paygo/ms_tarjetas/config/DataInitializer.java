package com.paygo.ms_tarjetas.config;

import com.paygo.ms_tarjetas.entity.Tarjeta;
import com.paygo.ms_tarjetas.repository.TarjetaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.math.BigDecimal;

@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {

    private final TarjetaRepository tarjetaRepository;

    @Override
    public void run(String... args) {
        tarjetaRepository.save(Tarjeta.builder().nomTitular("yaxon calle").saldoAsignado(new BigDecimal("1321.00")).saldoDisponible(new BigDecimal("350.50")).build());
        tarjetaRepository.save(Tarjeta.builder().nomTitular("Cesar Roman ").saldoAsignado(new BigDecimal("1567.00")).saldoDisponible(new BigDecimal("820.00")).build());
        tarjetaRepository.save(Tarjeta.builder().nomTitular("Carlos Ruiz").saldoAsignado(new BigDecimal("3000.00")).saldoDisponible(new BigDecimal("150.00")).build());
        tarjetaRepository.save(Tarjeta.builder().nomTitular("Yuly Huanca").saldoAsignado(new BigDecimal("2100.00")).saldoDisponible(new BigDecimal("640.00")).build());
        tarjetaRepository.save(Tarjeta.builder().nomTitular("Brayan Jara").saldoAsignado(new BigDecimal("1890.00")).saldoDisponible(new BigDecimal("990.75")).build());
        tarjetaRepository.save(Tarjeta.builder().nomTitular("Nicole Nolasco").saldoAsignado(new BigDecimal("2500.00")).saldoDisponible(new BigDecimal("1200.00")).build());
    }
}