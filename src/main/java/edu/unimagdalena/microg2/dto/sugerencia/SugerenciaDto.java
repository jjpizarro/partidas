package edu.unimagdalena.microg2.dto.sugerencia;

import edu.unimagdalena.microg2.dto.usuario.UsuarioDto;

import java.time.LocalDateTime;

public record SugerenciaDto(Long id, String descripcion, LocalDateTime createdAt, UsuarioDto usuario) {
}
