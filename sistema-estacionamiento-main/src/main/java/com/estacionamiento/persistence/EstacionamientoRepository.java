package com.estacionamiento.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.estacionamiento.entity.Estacionamiento;

@Repository
public interface EstacionamientoRepository extends JpaRepository<Estacionamiento, Integer>{
	List<Estacionamiento> findByActivoTrue();
}
