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

    /**
     * Agrega los libros a la lista de libros prestados
     */
    fun agregarLibros(libro:ElementoBiblioteca) {
        if (libro !in librosPrestados) librosPrestados.add(libro)
    }

    /**
     * Elimina los libros a la lista de libros prestados
     */
    fun eliminarLibro(libro: ElementoBiblioteca) {
        librosPrestados.remove(libro)
    }

    /**
     * Muestra los libros de la lista de libros prestados
     */
    fun mostrarLibrosPrestados() {
        librosPrestados.forEach { println(it) }
    }

}