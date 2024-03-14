package org.pebiblioteca

import java.util.*


interface Elemento {
    val titulo:String
    val autor :String
    val anio: Int
    val tematica:String
    var estado:Estado
    val id: String
}

data class Libro(override val titulo:String,
                 override val autor:String,
                 override val anio:Int,
                 override val tematica:String,
                 override val id: String = UtilidadesBiblioteca.generarIdentificadorUnico(),
                 override var estado: Estado = Estado.DISPONIBLE

        ) :Elemento {


    init {
        require(this.anio in (1..2024)) {"ERROR el año no puede ser menor a uno ni mayor a 2024"}
    }
}


enum class Estado(val desc:String){
    DISPONIBLE("Disponible"), PRESTADO("Prestado")
}