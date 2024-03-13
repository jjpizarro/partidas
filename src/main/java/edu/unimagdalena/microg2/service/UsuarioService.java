package edu.unimagdalena.microg2.service;

import edu.unimagdalena.microg2.dto.usuario.UsuarioDto;
import edu.unimagdalena.microg2.entities.Usuario;

public interface UsuarioService {
    UsuarioDto saveUsuario(Usuario usuario);
    UsuarioDto upadteUsuario(Usuario usuario);
    UsuarioDto findUsuarioById(Long id);
    UsuarioDto findUsuarioByEmail(String email);
}
