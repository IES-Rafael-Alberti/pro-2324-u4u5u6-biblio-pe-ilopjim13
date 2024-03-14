package org.pebiblioteca

/**
 * Interfaz para los catalogos que agrega o elimina elementos
 */
interface IGestorCatalogo {
    val lista:MutableList<ElementoBiblioteca>

    fun agregarElemento(elemento: ElementoBiblioteca):Boolean
    fun eliminarElemento(elemento: ElementoBiblioteca)
}