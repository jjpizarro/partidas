package edu.unimagdalena.microg2.dto.mensaje;

import edu.unimagdalena.microg2.dto.usuario.UsuarioDto;

import java.time.LocalDateTime;

public record MensajeDto(Long id,
                         String destinatario,
                         String contenido,
                         LocalDateTime createAt) {

}
