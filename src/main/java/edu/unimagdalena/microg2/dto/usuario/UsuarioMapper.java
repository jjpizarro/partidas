package edu.unimagdalena.microg2.dto.usuario;

import edu.unimagdalena.microg2.dto.mensaje.MensajeMapper;
import edu.unimagdalena.microg2.dto.sugerencia.SugerenciaMapper;
import edu.unimagdalena.microg2.entities.Sugerencia;
import edu.unimagdalena.microg2.entities.Usuario;

import java.util.List;
import java.util.stream.Collectors;

public class UsuarioMapper {
    private SugerenciaMapper sugerenciaMapper;
    public static Usuario usuarioDtoToUsuarioEntity(UsuarioDto usuarioDto){
        Usuario usuario = new Usuario();
        usuario.setNombre(usuarioDto.nombre());
        usuario.setApellido(usuarioDto.apellido());
        usuario.setEmail(usuarioDto.email());
        usuario.setId(usuarioDto.id());
        var sugerencias = usuarioDto.sugerencias()
                .stream()
                .map(SugerenciaMapper::sugerenciaDtoToSugerenciaEntity)
                .collect(Collectors.toList());
        usuario.setSugerencias(sugerencias);
        var mensajes = usuarioDto.mensajes()
                .stream()
                .map(MensajeMapper::mensajeDtoToMensajeEntity)
                .collect(Collectors.toList());
        usuario.setMensajes(mensajes);
        return usuario;
    }
    public static Usuario usuarioSaveDtoToUsuarioEntity(UsuarioToSaveDto usuarioDto){
        return Usuario.builder()
                .nombre(usuarioDto.nombre())
                .apellido(usuarioDto.apellido())
                .username(usuarioDto.username())
                .password(usuarioDto.password())
                .email(usuarioDto.email())
        .build();

    }
    public UsuarioDto usuarioEntityToUsuarioDto(Usuario usuario){
        var sugerencias = usuario.getSugerencias()
                .stream()
                .map(SugerenciaMapper::sugerenciaEntityToSugerenciaDto)
                .collect(Collectors.toList());
        var mensajes = usuario.getMensajes()
                .stream()
                .map(MensajeMapper::mensajeEntityToMensajeDto)
                .collect(Collectors.toList());

        return new UsuarioDto(usuario.getId(),
                usuario.getNombre(), usuario.getApellido(),
                usuario.getUsername(), usuario.getEmail(),
                sugerencias, mensajes);
    }
}
