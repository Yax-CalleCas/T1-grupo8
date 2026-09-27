package com.paygo.ms_tarjetas.repository;

import com.paygo.ms_tarjetas.entity.Tarjeta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TarjetaRepository extends JpaRepository<Tarjeta, Long> {
}