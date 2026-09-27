package com.paygo.ms_riesgo.repository;

import com.paygo.msriesgo.entity.Analisis;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnalisisRepository extends JpaRepository<Analisis, Long> {
}