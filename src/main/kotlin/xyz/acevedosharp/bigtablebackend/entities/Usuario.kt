package xyz.acevedosharp.bigtablebackend.entities

import java.sql.Timestamp
import javax.persistence.*

@Entity
@Table(name = "usuario", schema = "meson")
class Usuario(
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id")
        val id: Int?,

        @Column(name = "cedula")
        val cedula: String,

        @Column(name = "nombre")
        val nombre: String,

        @Column(name = "apellido")
        val apellido: String,

        @Column(name = "telefono")
        val telefono: String,

        @Column(name = "n_familiares")
        val nFamiliares: Int,

        @Column(name = "fecha_registro")
        val fechaRegistro: Timestamp,

        @Column(name = "latitud")
        val latitud: Double,

        @Column(name = "longitud")
        val longitud: Double,

        @Column(name = "sisben")
        val sisben: Double,

        @ManyToOne @JoinColumn(name = "cluster")
        val cluster: Cluster?,

        // -------- Not reflected in the erd --------

        @OneToMany(mappedBy = "usuario", fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
        var usuariosCampanaRel: List<UsuarioCampanaRel>
)