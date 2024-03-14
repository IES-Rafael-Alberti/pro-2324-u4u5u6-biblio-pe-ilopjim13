package org.pebiblioteca

fun main() {
    val usuario = Usuario("Pepe")
    val usuario2 = Usuario("JOse")
    val usuario3 = Usuario("Manolo")
    val libro1 = Libro("Libro 1", "autor 1", 1978, "Suspense")
    val libro2 = Libro("Libro 2", "autor 2", 1979, "Terror")
    val libro3 = Libro("Libro 3", "autor 3", 1979, "Terror")
    val gestor = GestionBiblioteca()

    gestor.agregarElemento(libro1)
    gestor.agregarElemento(libro2)
    gestor.agregarElemento(libro3)


    gestor.registrarPrestamo(usuario, libro1.id)
    gestor.registrarPrestamo(usuario, libro1.id)
    gestor.registrarPrestamo(usuario, libro2.id)
    gestor.registrarDevolucion(usuario, libro2.id)
    gestor.registrarDevolucion(usuario, libro2.id)
    gestor.registrarDevolucion(usuario, libro1.id)
    gestor.registrarPrestamo(usuario, libro3.id)


    gestor.catalogo.lista.forEach {
        println(it)
    }

    gestor.registros.historial.forEach { println(it) }
}