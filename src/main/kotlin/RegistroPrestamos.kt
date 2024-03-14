package org.pebiblioteca

class RegistroPrestamos {
    val prestamosActuales = mutableMapOf<Usuario, MutableList<Elemento>>()
    val historial = mutableListOf<String>()

    fun registrarPrestramo(usuario: Usuario, libro:Elemento) {
        if (usuario in prestamosActuales) prestamosActuales[usuario]?.add(libro)
        else prestamosActuales[usuario] = mutableListOf(libro)
        historial.add("${usuario.nombre} con id ${usuario.idUsu} ha tomado prestado el libro ${libro.titulo}")
        historial.add("${libro.titulo} con id ${libro.id} ha sido tomado por ${usuario.nombre}")
    }

    fun registrarDevoluciones(usuario: Usuario, libro: Elemento) {
        if (usuario in prestamosActuales) prestamosActuales[usuario]?.remove(libro)
        historial.add("${usuario.nombre} con id ${usuario.idUsu} ha devuelto el libro ${libro.titulo}")
        historial.add("${libro.titulo} con id ${libro.id} ha sido devuelto por ${usuario.nombre}")
    }

    fun consultarRegistros(id:String): List<String> {
        return historial.filter { it.contains(id)}

    }

}