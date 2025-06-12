package com.estacionamiento.persistence;

import com.estacionamiento.entity.Registro;
import com.estacionamiento.entity.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RegistroRepository extends JpaRepository<Registro, Integer> {
    Optional<Registro> findByVehiculoAndHoraSalidaIsNull(Vehiculo vehiculo);
}
