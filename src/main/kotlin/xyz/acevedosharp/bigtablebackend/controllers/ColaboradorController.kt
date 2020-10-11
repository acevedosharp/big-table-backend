package xyz.acevedosharp.bigtablebackend.controllers

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam
import xyz.acevedosharp.bigtablebackend.ColaboradorNotFoundException
import xyz.acevedosharp.bigtablebackend.GenericFailedSaveException
import xyz.acevedosharp.bigtablebackend.entities.Colaborador
import xyz.acevedosharp.bigtablebackend.repositories.ColaboradorRepo
import java.sql.Timestamp
import java.time.Instant

@Controller
class ColaboradorController(
        private val colaboradorRepo: ColaboradorRepo
) {
    @GetMapping("/colaboradores/{cedula}")
    fun colaboradorByCedula(@PathVariable cedula: String) = colaboradorRepo.findByCedulaEquals(cedula) ?: throw ColaboradorNotFoundException(cedula)

    @GetMapping("/colaboradores")
    fun allColaboradores() = colaboradorRepo.findAll()

    @PostMapping("/colaboradores")
    fun newColaborador(
            @RequestParam("cedula") cedula: String,
            @RequestParam("nombre_negocio") nombreNegocio: String,
            @RequestParam("nombre") nombre: String,
            @RequestParam("apellido") apellido: String,
            @RequestParam("direccion") direccion: String,
            @RequestParam("telefono") telefono: String,
            @RequestParam("latitud") latitud: Double,
            @RequestParam("longitud") longitud: Double,
            @RequestParam("nivel") nivel: Int
    ) {
        try {
            colaboradorRepo.save(
                    Colaborador(
                            null,
                            cedula,
                            nombreNegocio,
                            nombre,
                            apellido,
                            direccion,
                            telefono,
                            latitud,
                            longitud,
                            Timestamp.from(Instant.now()),
                            nivel,
                            0,
                            0
                    )
            )
        } catch (e: Exception) {
            throw GenericFailedSaveException()
        }
    }

    @GetMapping("/colaboradores/wipe")
    fun wipeColaboradores() = colaboradorRepo.deleteAll()
}