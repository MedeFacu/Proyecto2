package com.proyecto.demo.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.demo.models.Presupuesto;
import com.proyecto.demo.services.PresupuestoService;


@RestController
public class PresupuestoController {

    private final PresupuestoService presupuestoService;

    public PresupuestoController(PresupuestoService presupuestoService) {
        this.presupuestoService = presupuestoService;
    }

    @PostMapping("/guardarPresupuesto")
    public ResponseEntity<String> guardarPresupuesto(@RequestBody Presupuesto presupuesto) {
        try {
            presupuestoService.guardarPresupuesto(presupuesto);
            return new ResponseEntity<>("Presupuesto guardado exitosamente", HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("Error al guardar el presupuesto: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
