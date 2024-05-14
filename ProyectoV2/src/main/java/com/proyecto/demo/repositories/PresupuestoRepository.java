package com.proyecto.demo.repositories;

import com.proyecto.demo.models.Presupuesto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PresupuestoRepository extends JpaRepository<Presupuesto, Long> {
}