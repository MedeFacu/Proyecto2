package com.proyecto.demo.services;

import com.proyecto.demo.models.Presupuesto;
import com.proyecto.demo.repositories.PresupuestoRepository;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PresupuestoService {

	private final PresupuestoRepository presupuestoRepository;

    public PresupuestoService(PresupuestoRepository presupuestoRepository) {
        this.presupuestoRepository = presupuestoRepository;
    }

    // Método para guardar un objeto Presupuesto en la base de datos
    public Presupuesto guardarPresupuesto(Presupuesto presupuesto) {
        return presupuestoRepository.save(presupuesto);
    }

    // Método para obtener todos los objetos Presupuesto de la base de datos
    public List<Presupuesto> obtenerTodosPresupuestos() {
        return presupuestoRepository.findAll();
    }

    // Método para obtener un objeto Presupuesto por su ID
    public Optional<Presupuesto> obtenerPresupuestoPorId(Long id) {
        return presupuestoRepository.findById(id);
    }

    // Método para eliminar un objeto Presupuesto de la base de datos por su ID
    public void eliminarPresupuestoPorId(Long id) {
        presupuestoRepository.deleteById(id);
    }
}
