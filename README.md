# 🧠 Sumativa Semana 3 - Desarrollo Orientado a Objetos II

---

## 👤 Autor del proyecto
- **Nombre completo:**  Claudio Azocar y Catalina Zapata
- **Carrera:** Analista Programador
- **Nombre del Proyecto:** Empresa_Reparto_SpeedFast RamaSemana3
---
## 📘 Descripción general del proyecto
Este proyecto corresponde a la evaluación de la semana 3 de la asignatura *Desarrollo Orientado a Objetos II*. Se trata de un sistema orientado a objetos desarrollado en Java, cuyo objetivo es modelar y gestionar la información de la empresa SpeedFast, aplicando los principios de herencia, polimorfismo, clase abstracta, interfases, sobrescritura y sobrecarga.

El proyecto fue desarrollado a partir de un caso contextualizado, abordando problemáticas reales y proponiendo una solución estructurada, modular y reutilizable.

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
**Fecha de entrega:** 31/08/2026

---

© Duoc UC | Escuela de Informática y Telecomunicaciones | Sumativa Semana 3