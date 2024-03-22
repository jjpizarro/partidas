package edu.unimagdalena.microg2.dto.usuario;

public record UsuarioToSaveDto(
                               String nombre,
                               String apellido,
                               String username,
                               String password,
                               String email) {
}
