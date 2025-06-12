package com.estacionamiento.entity;
import jakarta.persistence.Column;
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
	@Column(name = "id")
	private int idEstacionamiento;
	@Column(name = "espacios_disponibles")
	private int espaciosDisponibles;
	@Column(name = "espacios_ocupados")
	private int espaciosOcupados;
	@Column(name = "activo")
	private boolean activo;
}
