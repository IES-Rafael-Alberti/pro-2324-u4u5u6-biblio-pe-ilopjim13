package org.pebiblioteca

/**
 * Representa a los usuarios de la biblioteca, conteniendo información como ID,
 * nombre, y una lista de libros prestados.
 * @property nombre:String nombre de los usuarios
 */
class Usuario(val nombre:String) {
    val idUsu: String = UtilidadesBiblioteca.generarIdentificadorUnico()
    private val librosPrestados = mutableListOf<ElementoBiblioteca>()
    companion object {
        var ident = 0
    }

    fun agregarLibros(libro:ElementoBiblioteca) {
        if (libro !in librosPrestados) librosPrestados.add(libro)
    }

    fun eliminarLibro(libro: ElementoBiblioteca) {
        librosPrestados.remove(libro)
    }

    fun mostrarLibrosPrestados() {
        librosPrestados.forEach { println(it) }
    }

}