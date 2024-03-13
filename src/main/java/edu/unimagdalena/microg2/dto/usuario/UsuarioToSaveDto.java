package edu.unimagdalena.microg2.dto.usuario;

public record UsuarioToSaveDto(Long id,
                               String nombre,
                               String apellido,
                               String username,
                               String password,
                               String email) {
}
