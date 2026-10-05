package com.example.myapplicationexamenprogra3.model

/**
 * Clase que representa un producto de Cuidado Personal o Cosmética.
 * Hereda de [ProductoFarmaceutico].
 */
class CuidadoPersonal(
    id: Int,
    codigo: String,
    nombre: String,
    precioBase: Double,
    stock: Int,
    val marca: String,
    val categoria: String,
    val esHipoalergenico: Boolean
) : ProductoFarmaceutico(id, codigo, nombre, precioBase, stock) {

    override fun calcularPrecioVenta(): Double {
        // Aplica IVA 13% + Recargo de línea cosmética/cuidado personal 10%
        return precioBase * 1.23
    }

    override fun obtenerDescripcion(): String {
        val hipoTexto = if (esHipoalergenico) "Hipoalergénico" else "Uso general"
        return "Cuidado Personal: $nombre - Marca: $marca ($categoria) [$hipoTexto]"
    }
}
