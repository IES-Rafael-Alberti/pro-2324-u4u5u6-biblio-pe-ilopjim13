package org.pebiblioteca

interface IGestorCatalogo {
    val lista:MutableList<ElementoBiblioteca>

    fun agregarElemento(elemento: ElementoBiblioteca):Boolean
    fun eliminarElemento(elemento: ElementoBiblioteca):Boolean
}