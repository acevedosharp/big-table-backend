package xyz.acevedosharp.bigtablebackend

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.ResponseStatus

class UsuarioNotFoundException(cedula: String): RuntimeException("Usuario with cedula: $cedula wasn't found.")
@ControllerAdvice class UsuarioNotFoundAdvice {
    @ResponseBody
    @ExceptionHandler(UsuarioNotFoundException::class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    fun usuarioNotFoundHandler(e: UsuarioNotFoundException) = e.message
}

class ColaboradorNotFoundException(cedula: String): RuntimeException("Colaborador with cedula: $cedula wasn't found.")
@ControllerAdvice class ColaboradorNotFoundAdvice {
    @ResponseBody
    @ExceptionHandler(ColaboradorNotFoundException::class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    fun colaboradorNotFoundHandler(e: ColaboradorNotFoundException) = e.message
}

class GenericFailedSaveException: RuntimeException("Failed to save your entity. Try with different data.")
@ControllerAdvice class GenericFailedSaveAdvice {
    @ResponseBody
    @ExceptionHandler(GenericFailedSaveException::class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    fun genericFailedSaveHandler(e: GenericFailedSaveException) = e.message
}
