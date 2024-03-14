package org.pebiblioteca

/**
 * Clase genérica que puede utilizarse para gestionar distintos tipos de elementos
 */
class GestorElementos<T:ElementoBiblioteca> {
    private val catalogo = Catalogo()

    /**
     * Agrega elementos a un catalogo
     * @param elemento :T elemento a agregar al catalogo
     * @return Boolean retorna true si se ha podido agregar o false si no
     */
    fun agregarElemento(elemento: T):Boolean {
        return if(elemento !in catalogo.lista) {
            catalogo.lista.add(elemento)
            true
        } else false
    }


    /**
     * Elimina elementos a un catalogo
     * @param elemento :T elemento a eliminar al catalogo
     * @return Boolean retorna true si se ha podido eliminar o false si no
     */
    fun eliminarElemento(elemento: T) :Boolean {
        return if(elemento in catalogo.lista) {
            catalogo.lista.remove(elemento)
            true
        } else false
    }

    /**
     * Muestra todos los elementos del catalogo
     */
    fun mostrarGestion() {
        catalogo.lista.forEach{println(it)}
    }

    /**
     * Retorna una lista con los elementos filtrados
     * @param elementos: MutableList<T> lista con los elementos del catalogo que se le ha pasado
     * @param criterio: (elemento: T) -> Boolean criterio que indica true o false si ese criterio está en los elementos
     * @return List<T> lista con los elementos filtrados
     */
    fun filtarPorCriterio(elementos: MutableList<T>, criterio: (elemento: T) -> Boolean): List<T> {
        return elementos.filter { criterio(it) }
    }
}