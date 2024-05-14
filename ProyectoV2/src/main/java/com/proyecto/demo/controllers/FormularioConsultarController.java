package com.proyecto.demo.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.proyecto.demo.services.PresupuestoService;

@Controller
public class FormularioConsultarController {
	
	public PresupuestoService presupuestoService;
	
	@GetMapping("/registros")
    public String mostrarFormulario() {
        return "registros";
    }
}
