package org.pebiblioteca

/**
 * Se trata de una colección dinámica que alberga todos los elementos disponibles en la biblioteca,
 * desde libros hasta revistas y DVDs. Facilita la organización y el acceso rápido a estos elementos,
 * jugando un papel fundamental en la eficiencia y flexibilidad del sistema.
 */
class Catalogo :IGestorCatalogo {
    override val lista = mutableListOf<ElementoBiblioteca>()

    override fun agregarElemento(elemento: ElementoBiblioteca):Boolean {
        return if(elemento !in lista) {
            lista.add(elemento)
            true
        } else false
    }

    override fun eliminarElemento(elemento: ElementoBiblioteca) :Boolean {
        return if(elemento in lista) {
            lista.remove(elemento)
            true
        } else false
    }

}