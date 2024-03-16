package edu.unimagdalena.microg2.dto.mensaje;

import edu.unimagdalena.microg2.dto.usuario.UsuarioDto;

import java.time.LocalDateTime;

public record MensajeToSaveDto(Long id, String destinatario, String contenido, LocalDateTime createAt,
                               UsuarioDto usuario) {
}
