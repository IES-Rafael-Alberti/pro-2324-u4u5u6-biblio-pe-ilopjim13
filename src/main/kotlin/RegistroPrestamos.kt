package org.pebiblioteca

/**
 * Mantiene un registro de los préstamos actuales y un historial de todos los préstamos realizados,
 * permitiendo registrar préstamos y devoluciones, así como consultar el historial de préstamos de libros
 * específicos o usuarios.
 */
class RegistroPrestamos :IGestorPrestamos {
    private val prestamosActuales = mutableMapOf<Usuario, MutableList<ElementoBiblioteca>>()
    override val historial = mutableListOf<String>()


    /**
     * Registra las devoluciones y añade al historial los registros
     * @param  usuario: Usuario usuario que va a devolver el elemento
     * @param elemento: elemento que se va a devolver
     */
    override fun registrarDevolucion(usuario: Usuario, elemento: ElementoBiblioteca) {
        if (usuario in prestamosActuales) prestamosActuales[usuario]?.remove(elemento)
        historial.add("${usuario.nombre} con id ${usuario.idUsu} ha devuelto el libro ${elemento.titulo}")
        historial.add("${elemento.titulo} con id ${elemento.id} ha sido devuelto por ${usuario.nombre}")
    }

    /**
     * Consulta el historial con el id del usuario o del libro
     * @param id: String del usuario o del libro
     */
    override fun consultarHistorial(id:String): List<String> {
        return historial.filter { it.contains(id)}

    }

    /**
     * Registra los prestamos y añade al historial los registros
     * @param  usuario: Usuario usuario que va a devolver el elemento
     * @param elemento: elemento que se va a devolver
     */
    override fun registrarPrestamo(usuario: Usuario, elemento:ElementoBiblioteca) {
        if (usuario in prestamosActuales) prestamosActuales[usuario]?.add(elemento)
        else prestamosActuales[usuario] = mutableListOf(elemento)
        historial.add("${usuario.nombre} con id ${usuario.idUsu} ha tomado prestado el libro ${elemento.titulo}")
        historial.add("${elemento.titulo} con id ${elemento.id} ha sido prestado por ${usuario.nombre}")
    }




}