package com.example.myapplicationexamenprogra3.model

/**
 * Clase abstracta base que representa una persona en el sistema.
 * Aplica Abstracción y Encapsulamiento.
 */
abstract class Persona(
    val id: Int,
    val nombre: String,
    val apellido: String,
    val ci: String,
    val telefono: String
) {
    /**
     * Retorna el nombre completo de la persona.
     */
    fun obtenerNombreCompleto(): String {
        return "$nombre $apellido"
    }

    /**
     * Método abstracto que debe ser implementado por las subclases (Polimorfismo).
     */
    abstract fun obtenerRol(): String
}
