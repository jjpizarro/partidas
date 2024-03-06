package edu.unimagdalena.microg2.repository;

import edu.unimagdalena.microg2.entities.Mensaje;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MensajeRepository extends JpaRepository<Mensaje, Long> {

}
