package com.estacionamiento.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.estacionamiento.entity.Estacionamiento;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/estacionamiento")
@RequiredArgsConstructor
public class EstacionamientoController {
	
	@GetMapping("/consultar-espacio/")
	public Estacionamiento consultar() {
		return null;
	}
}
