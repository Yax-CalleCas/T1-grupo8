package com.paygo.msrecargas.repository;

import com.paygo.msrecargas.entity.Recarga;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecargaRepository extends JpaRepository<Recarga, Long> {
}