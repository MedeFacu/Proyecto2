package com.proyecto.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class FormularioRegistroController {
	@GetMapping("/formulario")
    public String mostrarFormulario() {
        return "formulario";
    }
}