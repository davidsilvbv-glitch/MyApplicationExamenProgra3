package com.example.myapplicationexamenprogra3.model

/**
 * Clase que representa a un Cliente en la farmacia.
 * Hereda de [Persona].
 */
class Cliente(
    id: Int,
    nombre: String,
    apellido: String,
    ci: String,
    telefono: String,
    val codigoCliente: String,
    var puntosFidelidad: Int = 0,
    val tipoCliente: String = "Regular"
) : Persona(id, nombre, apellido, ci, telefono) {

    /**
     * Incrementa puntos de fidelidad según el monto gastado.
     */
    fun acumularPuntos(monto: Double) {
        val puntosGanados = (monto / 10.0).toInt()
        puntosFidelidad += puntosGanados
    }

    override fun obtenerRol(): String {
        return "Cliente $tipoCliente (Puntos: $puntosFidelidad)"
    }
}
