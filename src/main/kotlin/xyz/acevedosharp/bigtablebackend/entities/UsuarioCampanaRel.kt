package xyz.acevedosharp.bigtablebackend.entities

import javax.persistence.*

@Entity
@Table(name = "usuario_campana_rel", schema = "cjbijqp1eiscr4cu")
class UsuarioCampanaRel(
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id")
        val id: Int?,

        @Column(name = "ha_reclamado")
        val haReclamado: Boolean,

        @ManyToOne @JoinColumn(name = "usuario")
        val usuario: Usuario,

        @ManyToOne @JoinColumn(name = "campana")
        val campana: Campana
)