package xyz.acevedosharp.bigtablebackend.entities

import javax.persistence.*

@Entity
@Table(name = "asignacion_cluster_campana_rel", schema = "meson")
class AsignacionClusterCampanaRel(
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id")
        val id: Int?,

        @ManyToOne @JoinColumn(name = "campana")
        val campana: Campana,

        @ManyToOne @JoinColumn(name = "cluster")
        val cluster: Cluster,

        @Column(name = "presupuesto")
        val presupuesto: Int
)