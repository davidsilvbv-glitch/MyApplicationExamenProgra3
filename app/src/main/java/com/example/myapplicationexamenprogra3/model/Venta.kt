package com.example.myapplicationexamenprogra3.model

/**
 * Representa una Transacción de Venta en la farmacia.
 * Relaciona [Cliente], [Personal] y una lista de [ProductoFarmaceutico].
 */
class Venta(
    val idVenta: Int,
    val fecha: String,
    val cliente: Cliente,
    val atendidoPor: Personal,
    val productos: List<ProductoFarmaceutico>
) {
    /**
     * Calcula el monto total sumando el precio de venta final de cada producto.
     */
    fun calcularTotal(): Double {
        return productos.sumOf { it.calcularPrecioVenta() }
    }

    /**
     * Procesa la venta reduciendo el stock y acumulando puntos al cliente.
     */
    fun registrarVenta(): Boolean {
        val total = calcularTotal()
        for (prod in productos) {
            prod.reducirStock(1)
        }
        cliente.acumularPuntos(total)
        return true
    }
}
