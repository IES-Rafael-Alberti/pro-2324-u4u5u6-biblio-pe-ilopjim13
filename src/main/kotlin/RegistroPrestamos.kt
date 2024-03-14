package org.pebiblioteca

class RegistroPrestamos {
    val prestamosActuales = mutableMapOf<Usuario, MutableList<Elemento>>()
    val historial = mutableListOf<String>()

    fun consultarRegistros(id:String): List<String> {
        return historial.filter { it.contains(id)}

    }

}