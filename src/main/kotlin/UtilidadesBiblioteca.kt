package org.pebiblioteca

import java.util.UUID

/**
 * Clase con metodos estáticos que complementan a la gestion de biblioteca haciendo su gestion mejor
 */
class UtilidadesBiblioteca {

    companion object{
        fun generarIdentificadorUnico() :String {
            return UUID.randomUUID().toString()
        }
    }
}