package org.pebiblioteca

/**
 * Data clase DVD derivada de su clase padre ElementoBiblioteca y del interfaz Prestable que contiene
 * la informacion de los DVDs de la biblioteca
 * @property titulo:String nombre del DVD
 * @property autor:String nombre del autor del titulo
 * @property anio:Int añoñ de publicación del DVD
 * @property id: String identificador unico para localizar el DVD
 * @property estado:Estado indica el estado del DVD si está disponible o prestado
 */
data class DVD(override val titulo:String,
                 val autor:String,
                 val anio:Int,
                 val tematica:String,
                 override val id: String = UtilidadesBiblioteca.generarIdentificadorUnico(),
                 override var estado: Estado = Estado.DISPONIBLE

) :ElementoBiblioteca(id, titulo, estado) {


    init {
        require(this.anio in (1..2024)) {"ERROR el año no puede ser menor a uno ni mayor a 2024"}
    }

    override fun prestar() {
        if (estado == Estado.DISPONIBLE) estado = Estado.PRESTADO
    }

    override fun devolver() {
        if (estado == Estado.PRESTADO) estado = Estado.DISPONIBLE
    }
}
