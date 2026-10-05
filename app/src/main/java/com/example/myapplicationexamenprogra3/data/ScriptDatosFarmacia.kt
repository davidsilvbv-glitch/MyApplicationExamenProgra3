package com.example.myapplicationexamenprogra3.data

import com.example.myapplicationexamenprogra3.model.Cliente
import com.example.myapplicationexamenprogra3.model.CuidadoPersonal
import com.example.myapplicationexamenprogra3.model.InventarioFarmacia
import com.example.myapplicationexamenprogra3.model.Medicamento
import com.example.myapplicationexamenprogra3.model.Personal
import com.example.myapplicationexamenprogra3.model.Venta

/**
 * Script de inicialización y carga de datos de prueba para la Farmacia (Checkpoint 3).
 */
object ScriptDatosFarmacia {

    /**
     * Carga y retorna un objeto [InventarioFarmacia] poblado con datos de prueba.
     */
    fun cargarInventario(): InventarioFarmacia {
        val inventario = InventarioFarmacia()

        // 1. Cargar Medicamentos
        val med1 = Medicamento(
            id = 1,
            codigo = "MED-001",
            nombre = "Paracetamol",
            precioBase = 15.0,
            stock = 50,
            principioActivo = "Paracetamol",
            requiereReceta = false,
            dosisMg = 500
        )

        val med2 = Medicamento(
            id = 2,
            codigo = "MED-002",
            nombre = "Amoxicilina",
            precioBase = 45.5,
            stock = 25,
            principioActivo = "Amoxicilina",
            requiereReceta = true,
            dosisMg = 875
        )

        val med3 = Medicamento(
            id = 3,
            codigo = "MED-003",
            nombre = "Ibuprofeno",
            precioBase = 20.0,
            stock = 40,
            principioActivo = "Ibuprofeno",
            requiereReceta = false,
            dosisMg = 600
        )

        val med4 = Medicamento(
            id = 4,
            codigo = "MED-004",
            nombre = "Omeprazol",
            precioBase = 32.0,
            stock = 30,
            principioActivo = "Omeprazol",
            requiereReceta = false,
            dosisMg = 20
        )

        val med5 = Medicamento(
            id = 5,
            codigo = "MED-005",
            nombre = "Loratadina",
            precioBase = 18.0,
            stock = 35,
            principioActivo = "Loratadina",
            requiereReceta = false,
            dosisMg = 10
        )

        inventario.agregarProducto(med1)
        inventario.agregarProducto(med2)
        inventario.agregarProducto(med3)
        inventario.agregarProducto(med4)
        inventario.agregarProducto(med5)

        // 2. Cargar Productos de Cuidado Personal / Cosmética
        val cp1 = CuidadoPersonal(
            id = 6,
            codigo = "CP-001",
            nombre = "Protector Solar FPS 50+",
            precioBase = 120.0,
            stock = 15,
            marca = "CeraVe",
            categoria = "Dermocosmética",
            esHipoalergenico = true
        )

        val cp2 = CuidadoPersonal(
            id = 7,
            codigo = "CP-002",
            nombre = "Shampoo Anticaspa",
            precioBase = 55.0,
            stock = 20,
            marca = "Vichy",
            categoria = "Capilar",
            esHipoalergenico = true
        )

        val cp3 = CuidadoPersonal(
            id = 8,
            codigo = "CP-003",
            nombre = "Crema Hidratante Corporal",
            precioBase = 40.0,
            stock = 30,
            marca = "Nivea",
            categoria = "Corporal",
            esHipoalergenico = false
        )

        val cp4 = CuidadoPersonal(
            id = 9,
            codigo = "CP-004",
            nombre = "Gel Limpiador Facial",
            precioBase = 95.0,
            stock = 18,
            marca = "La Roche-Posay",
            categoria = "Facial",
            esHipoalergenico = true
        )

        inventario.agregarProducto(cp1)
        inventario.agregarProducto(cp2)
        inventario.agregarProducto(cp3)
        inventario.agregarProducto(cp4)

        // 3. Cargar Personal de la Farmacia
        val p1 = Personal(
            id = 1,
            nombre = "David",
            apellido = "Silva",
            ci = "1234567",
            telefono = "77712345",
            legajo = "EMP-001",
            cargo = "Farmacéutico Titular",
            turno = "Mañana",
            salario = 4500.0
        )

        val p2 = Personal(
            id = 2,
            nombre = "María",
            apellido = "Gómez",
            ci = "7654321",
            telefono = "77754321",
            legajo = "EMP-002",
            cargo = "Cajera",
            turno = "Tarde",
            salario = 3200.0
        )

        inventario.agregarPersonal(p1)
        inventario.agregarPersonal(p2)

        // 4. Cargar Clientes
        val c1 = Cliente(
            id = 1,
            nombre = "Carlos",
            apellido = "Pérez",
            ci = "4567890",
            telefono = "71234567",
            codigoCliente = "CLI-001",
            puntosFidelidad = 120,
            tipoCliente = "VIP"
        )

        val c2 = Cliente(
            id = 2,
            nombre = "Ana",
            apellido = "Martínez",
            ci = "9876543",
            telefono = "72345678",
            codigoCliente = "CLI-002",
            puntosFidelidad = 35,
            tipoCliente = "Regular"
        )

        inventario.agregarCliente(c1)
        inventario.agregarCliente(c2)

        // 5. Cargar Venta de Prueba
        val ventaPrueba = Venta(
            idVenta = 101,
            fecha = "2026-03-01",
            cliente = c1,
            atendidoPor = p1,
            productos = listOf(med1, cp1)
        )
        inventario.registrarVenta(ventaPrueba)

        return inventario
    }
}
