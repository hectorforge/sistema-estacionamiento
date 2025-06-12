package com.estacionamiento.entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Estacionamiento {
	private int idEstacionamiento;
	private int espaciosDisponibles;
	private int espaciosOcupados;
	private boolean activo;
}
