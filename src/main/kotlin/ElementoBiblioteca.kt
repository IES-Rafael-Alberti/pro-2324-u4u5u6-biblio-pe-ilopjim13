package org.pebiblioteca

/**
 * Clase abstracta de todos los elementos que va a haber en la biblioteca
 * @property id:String identificador único para los elementos de la biblioteca
 * @property titulo:String nombre del elemento de la bibliotecla
 * @property estado: Estado estado en el que se encuentra el elemento
 */
abstract class ElementoBiblioteca(open val id:String, open val titulo:String, open var estado:Estado) :Prestable {
}