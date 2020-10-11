package xyz.acevedosharp.bigtablebackend.entities

import javax.persistence.*

@Entity
@Table(name = "cluster_colaborador_rel", schema = "meson")
class ClusterColaboradorRel(
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id")
        val id: Int?,

        @ManyToOne @JoinColumn(name = "cluster")
        val cluster: Cluster,

        @ManyToOne @JoinColumn(name = "colaborador")
        val colaborador: Colaborador
)