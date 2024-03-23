package edu.unimagdalena.microg2.api;

import edu.unimagdalena.microg2.dto.usuario.UsuarioDto;
import edu.unimagdalena.microg2.exception.UsuarioNotFoundException;
import edu.unimagdalena.microg2.service.UsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/usuarios")
public class UsuarioController {
    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }
    @GetMapping()
    public ResponseEntity<List<UsuarioDto>> getUsuarios(){
        List<UsuarioDto> usuariosDto = usuarioService.getAllUsers();
        return ResponseEntity.ok().body(usuariosDto);
    }
    @GetMapping("/{id}")
    public ResponseEntity<UsuarioDto> getUsuarioById(@PathVariable("id") Long idUsuario){
        try {
            UsuarioDto usuarioDto = usuarioService.buscarUsuarioById(idUsuario);
            return ResponseEntity.ok().body(usuarioDto);
        }catch (UsuarioNotFoundException e){
            return ResponseEntity.notFound().build();
        }
    }

}
