package edu.unimagdalena.microg2.service;

import edu.unimagdalena.microg2.dto.usuario.UsuarioDto;
import edu.unimagdalena.microg2.dto.usuario.UsuarioToSaveDto;
import edu.unimagdalena.microg2.exception.UsuarioNotFoundException;


public interface UsuarioService {
    UsuarioDto guardarUsuario(UsuarioToSaveDto usuario);
    UsuarioDto actualizarUsuario(Long id, UsuarioToSaveDto usuario);
    UsuarioDto buscarUsuarioById(Long id) throws UsuarioNotFoundException;
    UsuarioDto buscarUsuarioByEmail(String email);
    void removerUsuario(Long id);
}
