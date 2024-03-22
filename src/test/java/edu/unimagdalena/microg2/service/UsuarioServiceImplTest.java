package edu.unimagdalena.microg2.service;

import edu.unimagdalena.microg2.dto.usuario.UsuarioDto;
import edu.unimagdalena.microg2.dto.usuario.UsuarioMapper;
import edu.unimagdalena.microg2.dto.usuario.UsuarioToSaveDto;
import edu.unimagdalena.microg2.entities.Usuario;
import edu.unimagdalena.microg2.exception.UsuarioNotFoundException;
import edu.unimagdalena.microg2.repository.UsuarioRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.willDoNothing;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UsuarioServiceImplTest {

    @Mock
    private UsuarioRepository usuarioRepository;

    @InjectMocks
    private UsuarioServiceImpl usuarioService;
    Usuario usuario;
    @BeforeEach
    void setUp() {
        usuario =  Usuario.builder()
                .id(1l)
                .nombre("test")
                .apellido("test appelido")
                .username("test1")
                .password("123")
                .email("test@test.com")
                .build();
    }

    @Test
    void givenUsuario_whenGuardarUsuario_thenReturnUsuarioGuardado() {
        usuario =  Usuario.builder()
                .id(1l)
                .nombre("test")
                .apellido("test appelido")
                .username("test1")
                .password("123")
                .email("test@test.com")
                .build();
        given(usuarioRepository.save(any())).willReturn(usuario);
        //when(usuarioRepository.save(any())).thenReturn(usuario);
        //GIVEN

        UsuarioToSaveDto usuarioAGuardar = new UsuarioToSaveDto(
                "test",
                "test appelido",
                "test1",
                "123",
                "test@test.com");
        //WHEN
        UsuarioDto usuarioDto = usuarioService.guardarUsuario(usuarioAGuardar);
        //THEN
        assertThat(usuarioDto).isNotNull();
        assertThat(usuarioDto.id()).isEqualTo(1l);
    }
    @Test
    void givenUserId_whenGetUsuarioById_thenReturnUsuario(){
        Long usuarioId = 1l;

        given(usuarioRepository.findById(usuarioId))
                .willReturn(Optional.of(usuario));

        UsuarioDto usuarioDto = usuarioService.buscarUsuarioById(usuarioId);

        assertThat(usuarioDto).isNotNull();
    }
    @Test
    void givenUsuarioId_whenGetUsuarioById_thenReturnException(){
        given(usuarioRepository.findById(any())).willReturn(Optional.ofNullable(null));

        assertThrows(UsuarioNotFoundException.class,()->{
            usuarioService.buscarUsuarioById(any());
        },"Usuario no encontrado");
    }
    @Test
    void givenUsuario_whenCallRemoveUsuario_thenNothing(){
        Long usuarioId = 1l;
        willDoNothing().given(usuarioRepository).delete(any());
        usuarioService.removerUsuario(usuarioId);

        verify(usuarioRepository, times(1)).delete(any());
    }
}