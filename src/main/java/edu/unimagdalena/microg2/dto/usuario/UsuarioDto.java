package edu.unimagdalena.microg2.dto.usuario;

import edu.unimagdalena.microg2.dto.mensaje.MensajeDto;
import edu.unimagdalena.microg2.dto.sugerencia.SugerenciaDto;

import java.util.Collections;
import java.util.List;

public record UsuarioDto(
        Long id,
        String nombre,
        String apellido,
        String username,
        String email,
        List<SugerenciaDto> sugerencias,
        List<MensajeDto> mensajes
) {
    public List<SugerenciaDto> sugerencias(){
        return Collections.unmodifiableList(sugerencias);
    }
    public List<MensajeDto> mensajes(){
        return Collections.unmodifiableList(mensajes);
    }
}
