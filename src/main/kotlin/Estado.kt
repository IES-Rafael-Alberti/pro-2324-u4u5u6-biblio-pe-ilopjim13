package org.pebiblioteca

/**
 * Enum class que indica el estado de los elementos
 * @property desc:String descripcion del estado
 */
enum class Estado(val desc:String){
    DISPONIBLE("Disponible"), PRESTADO("Prestado")
}