# 📦 Proyecto: Aplicación de Inventario de Productos (Java)

## 🎯 Objetivo
Desarrollar una aplicación en **Java** que permita gestionar el inventario de productos de una tienda.  
El sistema registra productos, calcula el valor total del inventario y genera un reporte final en consola.

---

## 📝 Características
- Registro de **nombre, cantidad y precio** de al menos 5 productos.
- Cálculo del valor total por producto (`cantidad * precio`).
- Cálculo del valor total del inventario (suma de todos los productos).
- Opción para **agregar nuevos productos**.
- Opción para **actualizar cantidades** si llega más inventario.
- Uso de **variables, arrays, matrices y estructuras de control** en Java.

---

## 🔧 Tecnologías utilizadas
- **Lenguaje:** Java 
- **IDE:** VSCode
- **Control de versiones:** Git + GitHub
- **Gestión de tareas:** Trello

---

## 👥 División de tareas
- **[Miltondw](https://github.com/miltondw)** Gestion de proyecto y generación del reporte final.
- **[Ing-Emily](https://github.com/Ing-Emily)** Definir los arrays para nombres, cantidades y precios,Definir la matriz para categorías de productos.
- **Miembro 3:** Incluir opción para actualizar cantidades e Implementa la lógica de cálculo para obtener el valor total del inventario.
---

## 📂 Estructura del proyecto
│── src/
│   ├── Main.java                 # Clase principal con el menú
│   ├── Producto.java              # Clase modelo (nombre, cantidad, precio)
│   ├── Inventario.java            # Lógica de gestión del inventario
│   └── Reporte.java               # Generación del reporte final
│── README.md
