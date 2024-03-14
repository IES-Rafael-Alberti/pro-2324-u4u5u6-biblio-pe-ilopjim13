package org.pebiblioteca

/**
 * Se trata de una colección dinámica que alberga todos los elementos disponibles en la biblioteca,
 * desde libros hasta revistas y DVDs. Facilita la organización y el acceso rápido a estos elementos,
 * jugando un papel fundamental en la eficiencia y flexibilidad del sistema.
 */
class Catalogo :IGestorCatalogo {
    override val lista = mutableListOf<ElementoBiblioteca>()

    /**
     * Agrega elementos al catalogo y comprueba si no está repetido para no meter el mismo
     * @param elemento: ElementoBiblioteca elemento de la biblioteca que se va a agregar
     * @return Boolean indica con true o false si se el elemento no está en la lista y lo a añadido o si está repetido devulve false
     */
    override fun agregarElemento(elemento: ElementoBiblioteca):Boolean {
        return if(elemento !in lista) {
            lista.add(elemento)
            true
        } else false
    }

    /**
     * Elimina elementos del catalogo
     * @param elemento: ElementoBiblioteca elemento de la biblioteca que se va a eliminar
     */
    override fun eliminarElemento(elemento: ElementoBiblioteca)  {
        lista.remove(elemento)
    }

    /**
     * Muestra el catalogo completo de la biblioteca
     */
    fun mostrarCatalogo() {
        lista.forEach { println(it) }
    }

}