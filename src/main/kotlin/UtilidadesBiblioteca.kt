package org.pebiblioteca

import java.util.UUID

class UtilidadesBiblioteca {

    companion object{
        fun generarIdentificadorUnico() :String {
            return UUID.randomUUID().toString()
        }
    }
}