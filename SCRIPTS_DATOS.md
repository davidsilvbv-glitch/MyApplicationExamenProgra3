# Checkpoint 3: Scripts de Carga de Datos - Farmacia

Este documento contiene los scripts de carga de datos iniciales utilizados en la aplicación para poblar el inventario de medicamentos, productos de cuidado personal, empleados (personal) y clientes.

---

## 1. Script en Kotlin (`ScriptDatosFarmacia.kt`)
Ubicación en el código fuente: `app/src/main/java/com/example/myapplicationexamenprogra3/data/ScriptDatosFarmacia.kt`

```kotlin
// Datos de Medicamentos cargados:
// 1. Paracetamol (500mg, Venta Libre) - $15.00
// 2. Amoxicilina (875mg, Con Receta) - $45.50
// 3. Ibuprofeno (600mg, Venta Libre) - $20.00
// 4. Omeprazol (20mg, Venta Libre) - $32.00
// 5. Loratadina (10mg, Venta Libre) - $18.00

// Datos de Cuidado Personal cargados:
// 1. CeraVe Protector Solar FPS 50+ (Dermocosmética, Hipoalergénico) - $120.00
// 2. Vichy Shampoo Anticaspa (Capilar, Hipoalergénico) - $55.00
// 3. Nivea Crema Hidratante (Corporal) - $40.00
// 4. La Roche-Posay Gel Limpiador Facial (Facial, Hipoalergénico) - $95.00

// Datos de Personal:
// 1. David Silva (Farmacéutico Titular - Turno Mañana)
// 2. María Gómez (Cajera - Turno Tarde)

// Datos de Clientes:
// 1. Carlos Pérez (Cliente VIP - Puntos: 120)
// 2. Ana Martínez (Cliente Regular - Puntos: 35)
```

---

## 2. Equivalente en SQL (Script DDL/DML de Referencia)

```sql
-- Tabla Productos
CREATE TABLE productos (
    id INT PRIMARY KEY AUTO_INCREMENT,
    codigo VARCHAR(20) NOT NULL,
    nombre VARCHAR(100) NOT NULL,
    precio_base DECIMAL(10, 2) NOT NULL,
    stock INT NOT NULL,
    tipo VARCHAR(20) NOT NULL -- 'MEDICAMENTO' o 'CUIDADO_PERSONAL'
);

-- Tabla Medicamentos
CREATE TABLE medicamentos (
    id_producto INT PRIMARY KEY,
    principio_activo VARCHAR(100) NOT NULL,
    requiere_receta BOOLEAN NOT NULL,
    dosis_mg INT NOT NULL,
    FOREIGN KEY (id_producto) REFERENCES productos(id)
);

-- Tabla Cuidado Personal
CREATE TABLE cuidado_personal (
    id_producto INT PRIMARY KEY,
    marca VARCHAR(50) NOT NULL,
    categoria VARCHAR(50) NOT NULL,
    es_hipoalergenico BOOLEAN NOT NULL,
    FOREIGN KEY (id_producto) REFERENCES productos(id)
);

-- Insertar Medicamentos
INSERT INTO productos (id, codigo, nombre, precio_base, stock, tipo) VALUES
(1, 'MED-001', 'Paracetamol', 15.00, 50, 'MEDICAMENTO'),
(2, 'MED-002', 'Amoxicilina', 45.50, 25, 'MEDICAMENTO'),
(3, 'MED-003', 'Ibuprofeno', 20.00, 40, 'MEDICAMENTO'),
(4, 'MED-004', 'Omeprazol', 32.00, 30, 'MEDICAMENTO'),
(5, 'MED-005', 'Loratadina', 18.00, 35, 'MEDICAMENTO');

INSERT INTO medicamentos (id_producto, principio_activo, requiere_receta, dosis_mg) VALUES
(1, 'Paracetamol', FALSE, 500),
(2, 'Amoxicilina', TRUE, 875),
(3, 'Ibuprofeno', FALSE, 600),
(4, 'Omeprazol', FALSE, 20),
(5, 'Loratadina', FALSE, 10);

-- Insertar Productos Cuidado Personal
INSERT INTO productos (id, codigo, nombre, precio_base, stock, tipo) VALUES
(6, 'CP-001', 'Protector Solar FPS 50+', 120.00, 15, 'CUIDADO_PERSONAL'),
(7, 'CP-002', 'Shampoo Anticaspa', 55.00, 20, 'CUIDADO_PERSONAL'),
(8, 'CP-003', 'Crema Hidratante Corporal', 40.00, 30, 'CUIDADO_PERSONAL'),
(9, 'CP-004', 'Gel Limpiador Facial', 95.00, 18, 'CUIDADO_PERSONAL');

INSERT INTO cuidado_personal (id_producto, marca, categoria, es_hipoalergenico) VALUES
(6, 'CeraVe', 'Dermocosmética', TRUE),
(7, 'Vichy', 'Capilar', TRUE),
(8, 'Nivea', 'Corporal', FALSE),
(9, 'La Roche-Posay', 'Facial', TRUE);
```
