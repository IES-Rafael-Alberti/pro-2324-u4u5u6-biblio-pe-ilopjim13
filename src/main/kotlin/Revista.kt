package org.pebiblioteca

/**
 * Data clase revista derivada de su clase padre ElementoBiblioteca y del interfaz Prestable que contiene
 * la informacion de las revistas de la biblioteca
 * @property titulo:String nombre de la revista
 * @property autor:String nombre del autor del titulo
 * @property anio:Int añoñ de publicación de la revista
 * @property id: String identificador unico para localizar la revista
 * @property estado:Estado indica el estado de la revista si está disponible o prestado
 */
data class Revista(override val titulo:String,
                 val autor:String,
                 val anio:Int,
                 val tematica:String,
                 override val id: String = UtilidadesBiblioteca.generarIdentificadorUnico(),
                 override var estado: Estado = Estado.DISPONIBLE

) :ElementoBiblioteca(id, titulo, estado) {


    init {
        require(this.anio in (1..2024)) {"ERROR el año no puede ser menor a uno ni mayor a 2024"}
    }

    /**
     * Presta la revista y pone el estado como prestado
     */
    override fun prestar() {
        if (estado == Estado.DISPONIBLE) estado = Estado.PRESTADO
    }

    /**
     * Devuelve la revista y pone el estado como disponible
     */
    override fun devolver() {
        if (estado == Estado.PRESTADO) estado = Estado.DISPONIBLE
    }
}
