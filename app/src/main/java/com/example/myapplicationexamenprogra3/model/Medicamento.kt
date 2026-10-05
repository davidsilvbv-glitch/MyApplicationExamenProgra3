package com.example.myapplicationexamenprogra3.model

/**
 * Clase que representa un Medicamento fármaco.
 * Hereda de [ProductoFarmaceutico].
 */
class Medicamento(
    id: Int,
    codigo: String,
    nombre: String,
    precioBase: Double,
    stock: Int,
    val principioActivo: String,
    val requiereReceta: Boolean,
    val dosisMg: Int
) : ProductoFarmaceutico(id, codigo, nombre, precioBase, stock) {

    override fun calcularPrecioVenta(): Double {
        // Si requiere receta médica, está exento de impuesto (0%), si no, paga 13% IVA.
        return if (requiereReceta) {
            precioBase
        } else {
            precioBase * 1.13
        }
    }

    override fun obtenerDescripcion(): String {
        val recetaTexto = if (requiereReceta) "Venta con Receta" else "Venta Libre"
        return "Medicamento: $nombre ($dosisMg mg) - $principioActivo [$recetaTexto]"
    }
}
