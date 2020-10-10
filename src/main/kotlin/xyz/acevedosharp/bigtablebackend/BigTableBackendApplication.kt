package xyz.acevedosharp.bigtablebackend

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class BigTableBackendApplication

fun main(args: Array<String>) {
    runApplication<BigTableBackendApplication>(*args)
}
