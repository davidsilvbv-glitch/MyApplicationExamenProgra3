# Checkpoint 4: Diseño de Interfaz de Usuario (Jetpack Compose)

Este documento especifica el diseño conceptual y los componentes de **Jetpack Compose** utilizados para construir las dos pantallas principales de la aplicación de Farmacia.

---

## 1. Estructura General de la Aplicación

La aplicación utiliza un patrón de diseño moderno basado en Material 3 con navegación mediante pestañas (`TabRow` / `PrimaryTabRow`) que permite alternar fácilmente entre los dos módulos principales de productos.

---

## 2. Pantalla 1: Lista de Medicamentos (`MedicamentosScreen`)

### Propósito
Visualizar y listar los objetos de tipo `Medicamento` cargados en el inventario, mostrando atributos específicos como principio activo, dosis, restricción de receta médica y precio de venta calculado polimórficamente.

### Componentes de Jetpack Compose Utilizados:
1. `Scaffold`: Proporciona la estructura base con `topBar` y contenedor de contenido.
2. `Card` (`OutlinedCard` / `ElevatedCard`): Contenedor individual para cada medicamento en la lista.
3. `LazyColumn`: Contenedor scrollable eficiente para renderizar la colección de medicamentos.
4. `Text`: Renderizado de títulos, precios, dosis y principios activos con jerarquía tipográfica Material 3 (`titleMedium`, `bodyMedium`, `labelSmall`).
5. `AssistChip` / `SuggestionChip`: Indicador visual dinamizado (ej. verde "Venta Libre" o rojo "Requiere Receta Médica").
6. `Badge` / `Surface`: Resaltador para el precio final de venta calculado por el método `calcularPrecioVenta()`.
7. `Icon` e `IconButton`: Iconografía descriptiva (ej. píldoras/medicina).

---

## 3. Pantalla 2: Lista de Cuidado Personal (`CuidadoPersonalScreen`)

### Propósito
Visualizar y listar los objetos de tipo `CuidadoPersonal`, destacando la marca, categoría dermatológica/cosmética, propiedad hipoalergénica y el precio de venta final.

### Componentes de Jetpack Compose Utilizados:
1. `LazyColumn`: Lista optimizada para los productos cosméticos y de cuidado personal.
2. `ElevatedCard`: Tarjetas elevadas con bordes redondeados para destacar cada producto.
3. `Row` y `Column`: Layouts de alineación horizontal y vertical.
4. `FilterChip` / `Chip`: Etiquetas para identificar la marca (ej. CeraVe, Vichy, La Roche-Posay) y categoría (Dermocosmética, Capilar, Facial).
5. `HorizontalDivider`: Separadores visuales entre las distintas secciones de atributos.
6. `Text`: Formateo de precios y detalles específicos del producto.

---

## 4. Componente de Navegación (`FarmaciaApp`)

* `PrimaryTabRow` & `Tab`: Barra de pestañas superior con íconos y texto que alterna el estado del selector (`selectedIndex`) entre `Medicamentos` (Índice 0) y `Cuidado Personal` (Índice 1).
