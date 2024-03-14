package org.pebiblioteca

/**
 * Interfaz para los prestamos que registra prestamos, devoluciones y consulta el historial
 */
interface IGestorPrestamos {
    val historial:MutableList<String>
    fun registrarPrestamo(usuario: Usuario, elemento:ElementoBiblioteca)
    fun registrarDevolucion(usuario: Usuario, elemento: ElementoBiblioteca)
    fun consultarHistorial(id:String): List<String>
}