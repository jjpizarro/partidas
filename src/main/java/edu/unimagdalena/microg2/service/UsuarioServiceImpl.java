package edu.unimagdalena.microg2.service;

import edu.unimagdalena.microg2.dto.usuario.UsuarioDto;
import edu.unimagdalena.microg2.dto.usuario.UsuarioMapper;
import edu.unimagdalena.microg2.dto.usuario.UsuarioToSaveDto;
import edu.unimagdalena.microg2.entities.Usuario;
import edu.unimagdalena.microg2.exception.NotAbleToDeleteException;
import edu.unimagdalena.microg2.exception.UsuarioNotFoundException;
import edu.unimagdalena.microg2.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService{
    private final UsuarioMapper usuarioMapper;
    private final UsuarioRepository usuarioRepository;
    @Autowired
    public UsuarioServiceImpl(UsuarioMapper usuarioMapper, UsuarioRepository usuarioRepository) {
        this.usuarioMapper = usuarioMapper;
        this.usuarioRepository = usuarioRepository;
    }


    @Override
    public UsuarioDto guardarUsuario(UsuarioToSaveDto usuarioDto) {
        Usuario usuario = UsuarioMapper.usuarioSaveDtoToUsuarioEntity(usuarioDto);
        Usuario usuarioGuardado = usuarioRepository.save(usuario);
        return UsuarioMapper.usuarioEntityToUsuarioDto(usuarioGuardado);
    }

    @Override
    public UsuarioDto actualizarUsuario(Long id, UsuarioToSaveDto usuarioDto) {
        /*Usuario usuarioInDb = usuarioRepository.findById(id).orElseThrow(()->new UsuarioNotFoundException("Usuario no encontrado"));
        usuarioInDb.setNombre(usuarioDto.nombre());
        usuarioInDb.setApellido(usuarioDto.apellido());
        usuarioInDb.setEmail(usuarioDto.email());
        usuarioInDb.setPassword(usuarioDto.password());
        usuarioInDb.setUsername(usuarioDto.username());


        Usuario usuarioGuardado = usuarioRepository.save(usuarioInDb);

        return UsuarioMapper.usuarioEntityToUsuarioDto(usuarioGuardado);

         */
        return usuarioRepository.findById(id).map(usuarioInDb ->{
            usuarioInDb.setNombre(usuarioDto.nombre());
            usuarioInDb.setApellido(usuarioDto.apellido());
            usuarioInDb.setEmail(usuarioDto.email());
            usuarioInDb.setPassword(usuarioDto.password());
            usuarioInDb.setUsername(usuarioDto.username());

            Usuario usuarioGuardado = usuarioRepository.save(usuarioInDb);

            return UsuarioMapper.usuarioEntityToUsuarioDto(usuarioGuardado);
        }).orElseThrow(()->new UsuarioNotFoundException("Usuario no encontrado"));
    }

    @Override
    public UsuarioDto buscarUsuarioById(Long id) throws UsuarioNotFoundException {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(()-> new UsuarioNotFoundException("Usuario no encontrado"));

        /*Optional<Usuario> usuarioOptional = usuarioRepository.findById(id);
        if(!usuarioOptional.isPresent()){
            throw new UsuarioNotFoundException("Usuario no encontrado");
        }*/
        /*Usuario usuario = usuarioRepository.findById(id).get();
        if(Objects.isNull(usuario)){
            throw new UsuarioNotFoundException("Usuario no encontrado");
        }*/
        //Usuario usuario = usuarioRepository.findById(id).orElse(new Usuario());
        return usuarioMapper.usuarioEntityToUsuarioDto(usuario);
    }

    @Override
    public UsuarioDto buscarUsuarioByEmail(String email) {
        Usuario usuario = usuarioRepository.findByEmail(email);
        if(Objects.isNull(usuario))
            throw new UsuarioNotFoundException("Usuario no encontrado");
        return usuarioMapper.usuarioEntityToUsuarioDto(usuario);
    }

    @Override
    public void removerUsuario(Long id) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(()-> new NotAbleToDeleteException("Usuario no encontrado") );
        usuarioRepository.delete(usuario);
    }

}
