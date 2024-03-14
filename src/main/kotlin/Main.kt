package org.pebiblioteca

fun main() {
    val usuario = Usuario("Pepe")
    val usuario2 = Usuario("JOse")
    val usuario3 = Usuario("Manolo")
    val libro1 = Libro("Libro 1", "autor 1", 1978, "Suspense")
    val libro2 = Libro("Libro 2", "autor 2", 1979, "Terror")
    val libro3 = Libro("Libro 3", "autor 3", 1979, "Terror")
    val registro: IGestorPrestamos = RegistroPrestamos()
    val catalogo: IGestorCatalogo = Catalogo()


    val gestor = GestionBiblioteca(registro, catalogo)
    val catalogo2 = GestorElementos<ElementoBiblioteca>()
    catalogo2.agregarElemento(libro1)

    gestor.agregarElemento("Libro 1", "autor 1", 1978, "Suspense")
    gestor.agregarElemento("Libro 2", "autor 2", 1979, "Terror")
    gestor.agregarElemento("Libro 3", "autor 3", 1979, "Terror")

    gestor.registrarPrestamo(usuario, libro1.id)
    gestor.registrarPrestamo(usuario, libro1.id)
    gestor.registrarPrestamo(usuario, libro2.id)
    gestor.registrarDevolucion(usuario, libro2.id)
    gestor.registrarDevolucion(usuario, libro2.id)
    gestor.registrarDevolucion(usuario, libro1.id)
    gestor.registrarPrestamo(usuario, libro3.id)

    MenuUsuario.mostrarMenu(usuario, gestor)

    gestor.mostrarTodos()

    gestor.registros.historial.forEach { println(it) }
}