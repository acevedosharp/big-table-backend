package xyz.acevedosharp.bigtablebackend.entities

import javax.persistence.*

@Entity
@Table(name = "asignacion_cluster_campana_rel", schema = "meson")
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