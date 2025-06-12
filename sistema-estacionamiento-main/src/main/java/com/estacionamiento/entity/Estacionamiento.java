package com.estacionamiento.entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Estacionamiento {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idEstacionamiento;
	private int espaciosDisponibles;
	private int espaciosOcupados;
	private boolean activo;
}
