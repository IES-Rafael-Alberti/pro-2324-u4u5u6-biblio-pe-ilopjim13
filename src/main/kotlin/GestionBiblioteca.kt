package org.pebiblioteca



/**
 * Clase principal de nuestro sistema, se encarga de la lógica para gestionar libro y otros elementos,
 * @property registros: IGestorPrestamos interfaz
 * @property catalogo: IGestorCatalogo
 */
class GestionBiblioteca(val registros:IGestorPrestamos, val catalogo: IGestorCatalogo) {


    /**
     * Agrega elementos al catalogo de la biblioteca recibiendo los datos del elemento
     * @param titulo: String El nombre del elemento
     * @param autor: String nombre del autor del elemento
     * @param anio: Int año de publicacion del elemento
     * @param tematica: String tematica del elemento
     * @return Boolean retorna true si se ha podido agregar y false si no se ha podido agregar
     */
    fun agregarElemento(titulo:String, autor:String, anio:Int, tematica:String):Boolean {
        val libro = Libro(titulo, autor, anio, tematica)
        return catalogo.agregarElemento(libro)
    }

    /**
     * Elimina elementos del catalogo recibiendo el id del elemento
     * @param id:String id unico del elemento
     * @return Boolean retorna true si se ha podido eliminar y false si no se ha podido eliminar
     */
    fun eliminarElemento(id: String):Boolean {
        val libro = catalogo.lista.find { it.id == id }
        return if(libro != null) {
            catalogo.eliminarElemento(libro)
            true
        } else false
    }

    /**
     * Registra un prestamo de un elemento a un usuario
     * @param usuario: Usuario quien va a tomar prestado el elemento
     * @param id: Int identificador unico del elemento que va a darse
     * @return Boolean indidica si se ha podido prestar el elemento o si no lo ha podido hacer
     */
    fun registrarPrestamo(usuario: Usuario, id: String):Boolean {
        val libro = catalogo.lista.find { it.id == id }
        return if (libro != null && libro.estado == Estado.DISPONIBLE) {
            usuario.agregarLibros(libro)
            registros.registrarPrestamo(usuario, libro)
            libro.prestar()
            true
        } else false
    }

    /**
     * Registra una devolucion de un elemento de un usuario
     * @param usuario: Usuario quien va a devolver el elemento
     * @param id: Int identificador unico del elemento que va a devolverse
     * @return Boolean indidica si se ha podido devolver el elemento o si no lo ha podido hacer
     */
    fun registrarDevolucion(usuario: Usuario, id: String):Boolean {
        val libro = catalogo.lista.find { it.id == id }
        return if (libro != null && libro.estado == Estado.PRESTADO) {
            usuario.eliminarLibro(libro)
            registros.registrarDevolucion(usuario, libro)
            libro.devolver()
            true
        } else false
    }

    /**
     * Consulta la disponibilidad de un elemento a través de su id y devuelve true o false si está disponible o no
     * @param id:String identificador unico del elemento que se va a consultar
     * @return retorna true si está disponible o false si está prestado
     */
    fun consultarDisponibilidad(id: String): Boolean {
        val libro = catalogo.lista.find { it.id == id }
        return if (libro != null) libro.estado == Estado.DISPONIBLE
        else false
    }

    /**
     * Retorna todos los elementos del catalogo
     * @return List<[ElementoBiblioteca]]> lista con todos los elementos del catalogo
     */
    fun mostrarTodos():List<ElementoBiblioteca> {
        return catalogo.lista
    }

    /**
     * Retorna los elementos disponibles del catalogo
     * @return List<[ElementoBiblioteca]]> lista con todos los elementos disponibles del catalogo
     */
    fun mostrarDisponibles() :List<ElementoBiblioteca> {
        return catalogo.lista.filter { it.estado == Estado.DISPONIBLE }
    }

    /**
     * Retorna los elementos prestados del catalogo
     * @return List<[ElementoBiblioteca]]> lista con todos los elementos prestados del catalogo
     */
    fun mostrarPresatados() :List<ElementoBiblioteca> {
        return catalogo.lista.filter { it.estado == Estado.PRESTADO }
    }
}