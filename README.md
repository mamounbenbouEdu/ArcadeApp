# 🕹️ Máquina Arcade de Juegos Lógicos en Java

Aplicación de escritorio desarrollada en Java que simula una máquina arcade con tres juegos clásicos de lógica:

- ♛ N Reinas
- ♞ Recorrido del Caballo
- 🗼 Torres de Hanói

Permite resolver cada problema con interfaz gráfica, aplicar patrones de diseño y guardar los resultados en una base de datos local utilizando Hibernate y H2.

---

## 🎯 Objetivos del Proyecto

- Aplicar **patrones de diseño** (Factory, Singleton, Facade…)
- Implementar una arquitectura modular con **Swing** y **MVC**
- Usar **Hibernate ORM** para persistencia de datos
- Trabajar con base de datos **H2 embebida**
- Reforzar conocimientos en **algoritmos de backtracking y recursividad**

---

## 🔧 Herramientas Utilizadas

| Tecnología     | Propósito                                   |
|----------------|---------------------------------------------|
| **Java SE 8+** | Lenguaje principal                          |
| **Swing**      | Interfaz gráfica de escritorio              |
| **Hibernate**  | Mapeo objeto-relacional (ORM)               |
| **H2**         | Base de datos embebida (archivo local `.mv.db`) |
| **IntelliJ IDEA** | Entorno de desarrollo                    |
| **Git/GitHub** | Control de versiones                        |

---

## 💾 Persistencia de Resultados

Cada juego guarda automáticamente un registro con:
- Nombre del juego
- Descripción (parámetro usado)
- Si se resolvió correctamente
- Número de pasos o movimientos

Todo queda almacenado en un archivo local:  
`arcadedb.mv.db` (base de datos embebida H2)

---
