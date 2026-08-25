# 🧠 Formativa Semana 2 - Desarrollo Orientado a Objetos II

---

## 👤 Autor del proyecto
- **Nombre completo:**  Catalina Zapata
- **Carrera:** Analista Programador
- **Nombre del Proyecto:** Empresa_Reparto_SpeedFast_2
---
## 📘 Descripción general del proyecto
Este proyecto corresponde a la evaluación Formativa de la semana 2 de la asignatura *Desarrollo Orientado a Objetos II*. Se trata de un sistema orientado a objetos desarrollado en Java, cuyo objetivo es modelar y gestionar la información de la empresa SpeedFast, aplicando los principios de herencia, polimorfismo, clase abstracta, sobrescritura y sobrecarga.

El proyecto fue desarrollado a partir de un caso contextualizado, abordando problemáticas reales y proponiendo una solución estructurada, modular y reutilizable.

---
## 🧱 Estructura general del proyecto

```plaintext
📁 Empresa_Reparto_SpeedFast/
│
├── 📁 src/
│   │
│   ├── 📁 app/
│   │   └── 📄 Main                      # Punto de entrada del programa.
│   │
│   ├── 📁 data/
│   │   └── 📄 GestorPaqueteria          # Gestiona los pedidos y aplica polimorfismo.
│   │
│   ├── 📁 model/
│   │   ├── 📄 PaqueteBase               # Clase base de los pedidos.
│   │   ├── 📄 PaqueteComida             # Subclase para pedidos de comida.
│   │   ├── 📄 PaqueteEncomienda         # Subclase para pedidos de encomienda.
│   │   ├─[Main.java](src/app/Main.java)─ 📄 PaqueteExpress            # Subclase para pedidos Express.
│   │   └── 📄 GestorPaqueteria          # Gestiona los pedidos y aplica polimorfismo.
│   │
│   └── 📁 resources/
│       └── 📄 Paquete.txt               # Archivo de texto que contiene la información.
│
└── 📄 README.md                         # Descripción e instrucciones del proyecto.
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
**Fecha de entrega:** 24/08/2026

---

© Duoc UC | Escuela de Informática y Telecomunicaciones | Formativa Semana 2