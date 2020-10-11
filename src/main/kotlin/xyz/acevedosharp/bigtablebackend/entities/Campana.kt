package xyz.acevedosharp.bigtablebackend.entities

import java.sql.Timestamp
import javax.persistence.*

@Entity
@Table(name = "campana", schema = "meson")
class Campana(
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id")
        val id: Int?,

        @Column(name = "empresa")
        val empresa: String,

        @Column(name = "nombre")
        val nombre: String,

        @Column(name = "fecha_inicio")
        val fechaInicio: Timestamp,

        @Column(name = "activo")
        val activo: Boolean,

        // -------- Not reflected in the erd --------

        @OneToMany(mappedBy = "campana", fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
        var asignacionesClusterCampanaRel: List<AsignacionClusterCampanaRel>?,

        @OneToMany(mappedBy = "campana", fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
        var usuariosCampanaRel: List<UsuarioCampanaRel>?
)