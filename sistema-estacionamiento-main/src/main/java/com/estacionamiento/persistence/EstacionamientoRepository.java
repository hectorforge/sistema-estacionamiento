package com.estacionamiento.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.estacionamiento.entity.Estacionamiento;

@Repository
public interface EstacionamientoRepository extends JpaRepository<Estacionamiento, Integer>{

}
