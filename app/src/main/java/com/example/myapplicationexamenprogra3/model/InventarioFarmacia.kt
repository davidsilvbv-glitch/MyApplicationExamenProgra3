package com.example.myapplicationexamenprogra3.model

/**
 * Gestor en memoria de Productos, Personal, Clientes y Ventas de la Farmacia.
 */
class InventarioFarmacia {
    val listaProductos = mutableListOf<ProductoFarmaceutico>()
    val listaPersonal = mutableListOf<Personal>()
    val listaClientes = mutableListOf<Cliente>()
    val listaVentas = mutableListOf<Venta>()

    fun agregarProducto(producto: ProductoFarmaceutico) {
        listaProductos.add(producto)
    }

    fun agregarPersonal(empleado: Personal) {
        listaPersonal.add(empleado)
    }

    fun agregarCliente(cliente: Cliente) {
        listaClientes.add(cliente)
    }

    fun registrarVenta(venta: Venta) {
        if (venta.registrarVenta()) {
            listaVentas.add(venta)
        }
    }

    /**
     * Retorna sólo los objetos de tipo [Medicamento].
     */
    fun obtenerMedicamentos(): List<Medicamento> {
        return listaProductos.filterIsInstance<Medicamento>()
    }

    /**
     * Retorna sólo los objetos de tipo [CuidadoPersonal].
     */
    fun obtenerProductosCuidadoPersonal(): List<CuidadoPersonal> {
        return listaProductos.filterIsInstance<CuidadoPersonal>()
    }
}
