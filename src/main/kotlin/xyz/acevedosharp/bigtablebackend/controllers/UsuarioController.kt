package xyz.acevedosharp.bigtablebackend.controllers

import org.springframework.web.bind.annotation.*
import xyz.acevedosharp.bigtablebackend.GenericFailedSaveException
import xyz.acevedosharp.bigtablebackend.UsuarioNotFoundException
import xyz.acevedosharp.bigtablebackend.entities.Usuario
import xyz.acevedosharp.bigtablebackend.repositories.UsuarioRepo
import java.sql.Timestamp
import java.time.Instant

@RestController
@CrossOrigin
class UsuarioController(
        private val usuarioRepo: UsuarioRepo
) {
    @GetMapping("/usuarios/{cedula}")
    fun userByCedula(@PathVariable cedula: String) = usuarioRepo.findByCedulaEquals(cedula) ?: throw UsuarioNotFoundException(cedula)

    @PostMapping("/usuarios")
    fun newUser(
            @RequestParam("cedula") cedula: String,
            @RequestParam("nombre") nombre: String,
            @RequestParam("apellido") apellido: String,
            @RequestParam("telefono") telefono: String,
            @RequestParam("n_familiares") nFamiliares: Int,
            @RequestParam("latitud") latitud: Double,
            @RequestParam("longitud") longitud: Double,
            @RequestParam("sisben") sisben: Double
    ) {
        try {
            usuarioRepo.save(
                    Usuario(
                            null,
                            cedula,
                            nombre,
                            apellido,
                            telefono,
                            nFamiliares,
                            Timestamp.from(Instant.now()),
                            latitud,
                            longitud,
                            sisben,
                            null,
                            null
                    )
            )
        } catch (e: Exception) {
            throw GenericFailedSaveException()
        }
    }
}