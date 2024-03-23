package edu.unimagdalena.microg2.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.unimagdalena.microg2.dto.usuario.UsuarioDto;
import edu.unimagdalena.microg2.entities.Usuario;
import edu.unimagdalena.microg2.service.UsuarioService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Collections;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest
@ExtendWith(MockitoExtension.class)
class UsuarioControllerTest {
    @Autowired
    MockMvc mockMvc;
    
    @MockBean
    private UsuarioService usuarioService;
    @Autowired
    private ObjectMapper objectMapper;
    private Usuario usuario;
    private UsuarioDto usuarioDto;
    
    

    @BeforeEach
    void setUp() {
    }

    @Test
    void whenGetAllUsuarios_thenReturnListUsuarios() throws Exception {
        UsuarioDto usuario1 = new UsuarioDto(1l, "test1", "aTest1","test1","test1@email.com", Collections.emptyList(),Collections.emptyList());
        List<UsuarioDto> usuarios = List.of(usuario1, new UsuarioDto(2l, "test2", "aTest2","test2","test2@email.com", Collections.emptyList(),Collections.emptyList()));
        when(usuarioService.getAllUsers()).thenReturn(usuarios);

        mockMvc.perform(get("/api/v1/usuarios")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].id",is(1l)))
        ;
        
    }
}