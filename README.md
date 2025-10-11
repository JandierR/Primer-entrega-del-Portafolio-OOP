# Sistema de Tienda Online - Portafolio POO

## Descripción del Proyecto

Sistema de gestión de tienda online desarrollado en Java que implementa principios fundamentales de Programación Orientada a Objetos (POO). El proyecto permite simular las operaciones básicas de una tienda: visualizar productos, agregar productos al carrito, eliminar productos y generar facturas.

Este proyecto fue desarrollado como portafolio académico para demostrar la aplicación práctica de conceptos clave de POO en una solución de software real.

---

## Características Principales

- **Gestión de Inventario**: La tienda mantiene un inventario de productos con cantidad y precio
- **Carrito de Compras**: Los usuarios pueden agregar y eliminar productos dinámicamente
- **Cálculo de Total**: Sistema automático para calcular el total de la compra
- **Generación de Facturas**: Impresión de facturas detalladas con desglose de productos
- **Interfaz por Consola**: Menú interactivo para facilitar la navegación del usuario

---

## Conceptos POO Aplicados

Este proyecto implementa de forma práctica los siguientes conceptos fundamentales:

### 1. Abstracción
- **Clase Producto**: Modela únicamente las características esenciales de un producto (nombre, cantidad, ID, precio)
- **Clase Tienda**: Abstrae el concepto de inventario y operaciones de venta
- **Clase Carrito**: Representa un carrito de compras con operaciones de alto nivel

### 2. Encapsulamiento
- Todos los atributos de las clases son privados
- Acceso controlado mediante getters y setters públicos
- Protección de la integridad de los datos mediante validaciones

### 3. Modularidad
- Cada clase tiene una responsabilidad única y bien definida
- Cada método realiza una tarea específica
- Código organizado y fácil de mantener

### 4. Relaciones entre Objetos

#### Composición (Tienda ◆─── Producto)
La Tienda crea y posee los Productos del inventario. Si la tienda desaparece, sus productos también.

#### Agregación (Carrito ◇─── Producto)
El Carrito contiene referencias a Productos que existen independientemente. Si el carrito se elimina, los productos siguen existiendo en la tienda.

#### Dependencia (Carrito ┄┄→ Tienda)
El Carrito depende de métodos de la Tienda. Recibe la Tienda como parámetro en sus operaciones.

#### Asociación (Main ─── Tienda / Main ─── Carrito)
Main conoce y coordina ambas clases, actuando como orquestador del sistema.

---

## Estructura del Proyecto

```
src/cr/ac/cenfotec/rojas/jandier/bl/
├── Main.java           # Punto de entrada de la aplicación
├── Tienda.java         # Gestión del inventario y operaciones de venta
├── Carrito.java        # Gestión del carrito de compras
└── Producto.java       # Definición de la entidad Producto
```

---

## Clases del Proyecto

### Clase Producto
Representa un producto disponible en la tienda.

**Atributos:**
- `nombre`: Nombre del producto (String)
- `cantidad`: Stock disponible (int)
- `id`: Identificador único (int)
- `precio`: Precio unitario (double)

**Métodos:**
- Getters y setters para todos los atributos

---

### Clase Tienda
Gestiona el inventario y las operaciones de venta.

**Atributos:**
- `productosStock`: Lista de productos disponibles

**Métodos Principales:**
- `agregarStock()`: Inicializa el inventario con productos
- `mostrarStock()`: Muestra todos los productos disponibles
- `buscarProductoId(int id)`: Busca un producto por ID
- `eliminarStock(int id)`: Reduce el stock de un producto
- `devolverStock(int id)`: Aumenta el stock de un producto
- `escanearProductos(Carrito carrito)`: Calcula el total del carrito
- `imprimirFactura(Carrito carrito)`: Genera e imprime la factura

---

### Clase Carrito
Gestiona los productos seleccionados por el cliente.

**Atributos:**
- `miCarrito`: Lista de productos en el carrito

**Métodos Principales:**
- `agregarProducto(Tienda tienda)`: Agrega un producto al carrito
- `eliminarProducto(Tienda tienda)`: Elimina un producto del carrito
- `imprimirCarrito()`: Muestra el contenido del carrito
- `getMiCarrito()`: Devuelve la lista de productos

---

### Clase Main
Punto de entrada y orquestador de la aplicación.

**Métodos:**
- `main(String[] args)`: Inicia la aplicación
- `menuAcciones()`: Gestiona el menú principal e interacciones del usuario

---


## Autor

**Jandier Rojas**  
Estudiante de Programación  
Centro de Formación Técnica (Universidad CENFOTEC)