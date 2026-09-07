# 🧠 Formativa Semana 3 - Desarrollo Orientado a Objetos II

---

## 👤 Autor del proyecto
- **Nombre completo:**  Catalina Zapata
- **Carrera:** Analista Programador
- **Nombre del Proyecto:** Empresa_Reparto_SpeedFast RamaSemana4
---
## 📘 Descripción general del proyecto
Este proyecto corresponde a la evaluación de la semana 4 de la asignatura Desarrollo Orientado a Objetos II. Se trata de un sistema de gestión de paquetería desarrollado en Java, cuyo objetivo es modelar y administrar los procesos asociados al registro, despacho, cancelación, rastreo y entrega de paquetes de la empresa SpeedFast.

El sistema permite gestionar distintos tipos de paquetes, como Comida, Encomienda y Express, utilizando una estructura basada en clases abstractas, herencia, polimorfismo e interfaces.

Además, el proyecto incorpora conceptos de programación concurrente, permitiendo simular el trabajo de distintos repartidores mediante hilos y ExecutorService. Cada repartidor puede tener múltiples paquetes asignados y realizar sus entregas de manera concurrente, utilizando tiempos de espera aleatorios para representar la duración de cada entrega.

El proyecto fue desarrollado a partir de un caso contextualizado, abordando problemáticas propias de una empresa de reparto y proponiendo una solución estructurada, modular y reutilizable.

---
## 🧱 Estructura general del proyecto

```plaintext
📁 Empresa_Reparto_SpeedFast/
│
├── 📁 src/
│   │
│   ├── 📁 app/
│   │   └── 📄 Main.java                    # Punto de entrada del programa.
│   │
│   ├── 📁 contrato/
│   │   ├── 📄 Cancelable.java               # Interfaz que define la clase cancelar().
│   │   ├── 📄 Despachable.java              # Interfaz que define la clase despachar().
│   │   └── 📄 Rastreable.java               # Interfaz que define la clase verHistorial().
│   │
│   ├── 📁 data/
│   │   └── 📄 GestorPaqueteria.java         # Gestiona los paquetes y las operaciones del sistema.
│   │
│   ├── 📁 model/
│   │   ├── 📄 PaqueteBase.java              # Clase base de los paquetes.
│   │   ├── 📄 PaqueteComida.java            # Subclase para paquetes de comida.
│   │   ├── 📄 PaqueteEncomienda.java        # Subclase para paquetes de encomienda.
│   │   └── 📄 PaqueteExpress.java           # Subclase para paquetes Express.
│   │   └── 📄 Repartidor.java               # Subclase para designar repartidores.
│   │
│   └── 📁 resources/
│       └── 📄 Paquete.txt                   # Archivo de texto que contiene la información.
│
└── 📄 README.md                             # Descripción e instrucciones del proyecto.
```

---
## ⚙️ Instrucciones para compilar y ejecutar `Main`
1. Abrir el proyecto en IntelliJ IDEA.
2. Esperar a que IntelliJ cargue las dependencias del proyecto.
3. Navegar hasta la clase `Main` ubicada en el paquete `app`.
4. Ejecutar el método `main()` presionando el botón **Run** (▶).
5. Verificar los resultados en la consola de ejecución.

---

**Repositorio GitHub:** https: https://github.com/CatalinaZapata/Empresa_Reparto_SpeedFast.git |
**Fecha de entrega:** 07/09/2026

---

© Duoc UC | Escuela de Informática y Telecomunicaciones | Formativa Semana 4