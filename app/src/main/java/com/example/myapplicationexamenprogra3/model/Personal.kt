package com.example.myapplicationexamenprogra3.model

/**
 * Clase que representa a un miembro del personal/empleado de la farmacia.
 * Hereda de [Persona].
 */
class Personal(
    id: Int,
    nombre: String,
    apellido: String,
    ci: String,
    telefono: String,
    val legajo: String,
    val cargo: String,
    val turno: String,
    val salario: Double
) : Persona(id, nombre, apellido, ci, telefono) {

    override fun obtenerRol(): String {
        return "Personal - $cargo (Turno: $turno)"
    }
}
