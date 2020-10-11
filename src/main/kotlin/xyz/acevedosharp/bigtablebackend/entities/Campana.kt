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
        val activo: Boolean
)