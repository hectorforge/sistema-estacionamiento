package com.estacionamiento.entity;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Vehiculo {
	private int idVehiculo;
	private String placa;
	private String tipo;
}
