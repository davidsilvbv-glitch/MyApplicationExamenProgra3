package com.example.myapplicationexamenprogra3.model

/**
 * Clase abstracta que representa la base de un producto en la farmacia.
 * Aplica Abstracción, Encapsulamiento y Polimorfismo.
 */
abstract class ProductoFarmaceutico(
    val id: Int,
    val codigo: String,
    val nombre: String,
    val precioBase: Double,
    var stock: Int
) {
    /**
     * Disminuye el stock si hay suficiente disponible.
     */
    fun reducirStock(cantidad: Int): Boolean {
        if (cantidad <= stock) {
            stock -= cantidad
            return true
        }
        return false
    }

    /**
     * Incrementa el stock disponible.
     */
    fun aumentarStock(cantidad: Int) {
        if (cantidad > 0) {
            stock += cantidad
        }
    }

    /**
     * Calcula el precio final de venta. Método abstracto (Polimorfismo).
     */
    abstract fun calcularPrecioVenta(): Double

    /**
     * Retorna una descripción formateada del producto. Método abstracto.
     */
    abstract fun obtenerDescripcion(): String
}
