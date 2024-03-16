package edu.unimagdalena.microg2.service;

import edu.unimagdalena.microg2.dto.usuario.UsuarioDto;
import edu.unimagdalena.microg2.dto.usuario.UsuarioMapper;
import edu.unimagdalena.microg2.dto.usuario.UsuarioToSaveDto;
import edu.unimagdalena.microg2.entities.Usuario;
import edu.unimagdalena.microg2.exception.UsuarioNotFoundException;
import edu.unimagdalena.microg2.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class UsuarioServiceImpl implements UsuarioService{

    private final UsuarioRepository usuarioRepository;

    public UsuarioServiceImpl(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }


    @Override
    public UsuarioDto guardarUsuario(UsuarioToSaveDto usuarioDto) {
        Usuario usuario = UsuarioMapper.usuarioSaveDtoToUsuarioEntity(usuarioDto);
        Usuario usuarioGuardado = usuarioRepository.save(usuario);
        return UsuarioMapper.usuarioEntityToUsuarioDto(usuarioGuardado);
    }

    @Override
    public UsuarioDto actualizarUsuario(UsuarioToSaveDto usuario) {
        return null;
    }

    @Override
    public UsuarioDto buscarUsuarioById(Long id) throws UsuarioNotFoundException {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(()-> new UsuarioNotFoundException("Usuario no encontrado"));

        return UsuarioMapper.usuarioEntityToUsuarioDto(usuario);
    }

    @Override
    public UsuarioDto buscarUsuarioByEmail(String email) {
        Usuario usuario = usuarioRepository.findByEmail(email);
        if(Objects.isNull(usuario))
            throw new UsuarioNotFoundException("Usuario no encontrado");
        return UsuarioMapper.usuarioEntityToUsuarioDto(usuario);
    }
}
