package org.pebiblioteca

import java.util.*

data class Libro(val idLibro: String = UUID.randomUUID().toString(), val titulo:String, val autor:String, val anio:Int, val tematica:String, var estado: Estado) {
    init {
        require(this.anio in (1..2024)) {"ERROR el año no puede ser menor a uno ni mayor a 2024"}
    }
}


enum class Estado(val desc:String){
    DISPONIBLE("Disponible"), PRESTADO("Prestado")
}