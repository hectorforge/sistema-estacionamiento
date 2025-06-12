package com.estacionamiento.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.estacionamiento.entity.Vehiculo;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/vehiculo")
@RequiredArgsConstructor
public class VehiculoController {
	
	
	@PostMapping("/registrar")
	public Vehiculo registrar() {
		return null;
	}
	
}
