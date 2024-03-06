package edu.unimagdalena.microg2.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "usuarios")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nombre;
    private String apellido;
    @Column(unique = true, nullable = false)
    private String username;
    private String password;
    @Column(unique = true)
    private String email;

    @OneToMany(mappedBy = "usuarios")
    private List<Sugerencia> sugerencias;

    @ManyToMany
    @JoinTable(name="usuarios_partidas",
            joinColumns= @JoinColumn( name="idUsuario",
                    referencedColumnName="id"),
            inverseJoinColumns=@JoinColumn( name="idPartida",
                    referencedColumnName="id"))

    private List<Partida> partidas;
    @OneToMany(mappedBy = "usuario")
    private List<Mensaje> mensajes;

}
