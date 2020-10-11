package xyz.acevedosharp.bigtablebackend.entities

import java.sql.Timestamp
import javax.persistence.*

@Entity
@Table(name = "colaborador", schema = "cjbijqp1eiscr4cu")
class Colaborador(
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id")
        val id: Int?,

        @Column(name = "cedula", unique = true)
        val cedula: String,

        @Column(name = "nombre_negocio")
        val nombreNegocio: String,

        @Column(name = "nombre")
        val nombre: String,

        @Column(name = "apellido")
        val apellido: String,

        @Column(name = "direccion")
        val direccion: String,

        @Column(name = "telefono")
        val telefono: String,

        @Column(name = "latitud")
        val latitud: Double,

        @Column(name = "longitud")
        val longitud: Double,

        @Column(name = "fecha_registro")
        val fechaRegistro: Timestamp,

        @Column(name = "nivel")
        val nivel: Int,

        @Column(name = "campanas_colaboradas")
        val campanasColaboradas: Int,

        @Column(name = "valor_colaborado")
        val valorColaborado: Int
)