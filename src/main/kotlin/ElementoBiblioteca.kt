package org.pebiblioteca

abstract class ElementoBiblioteca(open val id:String, open val titulo:String, open var estado:Estado) :Prestable {
}