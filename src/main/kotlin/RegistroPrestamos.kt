package org.pebiblioteca

/**
 * Mantiene un registro de los préstamos actuales y un historial de todos los préstamos realizados,
 * permitiendo registrar préstamos y devoluciones, así como consultar el historial de préstamos de libros
 * específicos o usuarios.
 */
class RegistroPrestamos :IGestorPrestamos {
    private val prestamosActuales = mutableMapOf<Usuario, MutableList<ElementoBiblioteca>>()
    override val historial = mutableListOf<String>()


    override fun registrarDevolucion(usuario: Usuario, libro: ElementoBiblioteca) {
        if (usuario in prestamosActuales) prestamosActuales[usuario]?.remove(libro)
        historial.add("${usuario.nombre} con id ${usuario.idUsu} ha devuelto el libro ${libro.titulo}")
        historial.add("${libro.titulo} con id ${libro.id} ha sido devuelto por ${usuario.nombre}")
    }

    override fun consultarHistorial(id:String): List<String> {
        return historial.filter { it.contains(id)}

    }

    override fun registrarPrestamo(usuario: Usuario, libro:ElementoBiblioteca) {
        if (usuario in prestamosActuales) prestamosActuales[usuario]?.add(libro)
        else prestamosActuales[usuario] = mutableListOf(libro)
        historial.add("${usuario.nombre} con id ${usuario.idUsu} ha tomado prestado el libro ${libro.titulo}")
        historial.add("${libro.titulo} con id ${libro.id} ha sido prestado por ${usuario.nombre}")
    }




}