package edu.unimagdalena.microg2.service;

import edu.unimagdalena.microg2.dto.mensaje.MensajeDto;
import edu.unimagdalena.microg2.dto.mensaje.MensajeToSaveDto;

public interface MensajeService {
    MensajeDto guardarMensaje(MensajeToSaveDto mensajeDto);
}
