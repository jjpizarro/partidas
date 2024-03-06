package edu.unimagdalena.microg2.repository;

import edu.unimagdalena.microg2.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    List<Usuario> findByNombreAndApellido(String nombre, String apellido);
    @Query("SELECT u FROM Usuario u WHERE u.nombre = ?1 AND u.apellido = ?2")
    List<Usuario> buscarPorNombreYApellido(String nombre, String apellido);
    List<Usuario> findByUsernameOrEmail(String username, String email);

    List<Usuario> findByNombreLike(String nombre);
    @Query("Select u from Usuario u where u.nombre like %?1")
    List<Usuario> buscarPorNombre(String criterio);


}
