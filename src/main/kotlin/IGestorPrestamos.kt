package org.pebiblioteca

interface IGestorPrestamos {
    val historial:MutableList<String>
    fun registrarPrestamo(usuario: Usuario, libro:ElementoBiblioteca)
    fun registrarDevolucion(usuario: Usuario, libro: ElementoBiblioteca)
    fun consultarHistorial(id:String): List<String>
}