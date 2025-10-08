<div align="center">

# 🧠 **COMPUWORK**

### 💼 Sistema de Gestión de Empleados y Departamentos  
_Desarrollado en Java con arquitectura MVC, interfaz Swing y pruebas unitarias con JUnit._

---

### 🧰 Tecnologías utilizadas

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Swing](https://img.shields.io/badge/Swing-5382A1?style=for-the-badge&logo=java&logoColor=white)
![JUnit](https://img.shields.io/badge/JUnit-25A162?style=for-the-badge&logo=junit5&logoColor=white)
![NetBeans](https://img.shields.io/badge/NetBeans-1B6AC6?style=for-the-badge&logo=apache-netbeans-ide&logoColor=white)
![MVC](https://img.shields.io/badge/Arquitectura-MVC-blueviolet?style=for-the-badge)
![GitHub](https://img.shields.io/badge/GitHub-181717?style=for-the-badge&logo=github)
![License](https://img.shields.io/badge/Licencia-Académica-lightgrey?style=for-the-badge)

---

### 🚀 Hecho con ❤️ por  
**María Camila Gómez Echeverry**, **Juan Pedro Montoya Vélez**, **Darwin Monsalve Noreña**, **Jorge Eliécer Cuervo Zapata**

📚 _Proyecto académico — IUDigital 2025_

---

</div>

![Inicio](0db2804c-5f69-4da5-ad3d-61755608e827.png)

CompuWork es una aplicación de escritorio desarrollada en **Java** con **Swing**, diseñada para gestionar empleados, departamentos y reportes de desempeño dentro de una organización.  
Su arquitectura modular permite una administración eficiente, escalable y mantenible, integrando **controladores, servicios, modelos y vistas**, además de **pruebas unitarias con JUnit**.

---

## 🎯 Objetivo del Sistema

El objetivo principal de **CompuWork** es facilitar la **gestión del talento humano y la organización interna**, permitiendo:

- Registrar, listar y eliminar empleados.  
- Registrar, listar y eliminar departamentos.  
- Asignar y remover empleados de departamentos.  
- Generar reportes individuales y por departamento.  
- Administrar roles de usuario con distintos niveles de acceso.  

El sistema cuenta con una interfaz intuitiva y visualmente coherente, desarrollada completamente en **Swing**, con validaciones y flujos lógicos controlados mediante la clase central `Sistema`.

---

## 🏗️ Arquitectura del Proyecto

El proyecto está dividido en **cuatro capas principales**, siguiendo principios de la **Programación Orientada a Objetos (POO)**:

### 1. 🧩 models  
Contiene las clases de dominio (`Empleado`, `Departamento`, `ReporteDesempeno`, `Temporal`, `Permanente`, `Usuario`, `Rol`, `TipoReporte`).  
Definen la estructura de datos, atributos y relaciones entre entidades.

### 2. ⚙️ service  
Incluye la clase **`Sistema`**, núcleo de la aplicación.  
Gestiona listas internas, reglas de negocio, búsquedas, asignaciones y validaciones, además de lanzar excepciones controladas.

### 3. 🧭 controller  
Controladores como `EmpleadoController`, `DepartamentoController` y `ReporteController` que actúan como puente entre la interfaz y la lógica del sistema.  
Validan entradas, construyen objetos y delegan acciones a la capa de servicio.

### 4. 💻 view  
La capa visual hecha con **Swing**, donde el usuario interactúa con botones, tablas y formularios.  
Incluye vistas como:  
`AdminMenuView`, `EmpleadoListView`, `DepartamentoListView`, `EmpleadoView`, `DepartamentoView`, entre otras.

---

## 🧪 Pruebas Unitarias (JUnit)

Las pruebas fueron desarrolladas con **JUnit 4**, verificando el correcto funcionamiento de los controladores (`EmpleadoControllerTest`, `DepartamentoControllerTest`, `SistemaTest`), garantizando la fiabilidad del sistema.

Ejemplo de estructura:
```java
@Test
public void registrarDepartamento() {
    Departamento d = TestDataFactory.departamento("TI");
    ctrl.registrar(d);
    assertTrue(sistema.listarDepartamentos().contains(d));
}
```

## ⚙️ Requerimientos Funcionales

### 🧩 Gestión de empleados
- CRUD completo de empleados.  
- Creación de empleados con validación de campos y generación automática de ID.  
- Actualización de datos, incluyendo salario y tipo.  
- Eliminación lógica (estado “inactivo”).  
- Asignación de empleados a departamentos activos.  
- Listado y filtrado por estado, departamento y fecha de ingreso.  

### 🏢 Organización de departamentos
- CRUD de departamentos.  
- Visualización de empleados por departamento.  
- Restricción para eliminar departamentos con empleados activos.  

### 📈 Reportes de desempeño
- Generación de reportes individuales con métricas.  
- Reportes agrupados por departamento.  
- Exportación y visualización en formatos PDF/CSV.  
- Administración de métricas disponibles (solo rol **Administrador**).  

### 👥 Interfaz y acceso de usuarios
- Inicio y cierre de sesión.  
- Recuperación y restablecimiento de contraseñas.  
- Gestión de roles y permisos:  
  - **Administrador:** CRUD de empleados, departamentos, métricas y usuarios.  
  - **Líder:** Visualiza su equipo y genera reportes individuales/departamentales.  
  - **Empleado:** Accede a su propio perfil y reportes personales.  

---

## 🧱 Requerimientos No Funcionales

- **Usabilidad:** Interfaz sencilla y coherente.  
- **Escalabilidad:** Capacidad de manejar hasta 10 000 empleados y 300 departamentos.  
- **Seguridad:** Encriptación y control de accesos.  
- **Rendimiento:** Respuesta ágil en consultas y reportes.  
- **Mantenibilidad:** Diseño modular y reutilizable.  
- **Compatibilidad:** Multiplataforma, adaptable a distintos dispositivos.  
- **Disponibilidad:** Alta disponibilidad con mínima inactividad.  

---

## 📊 Diagramas del Proyecto

### 🧮 Diagrama de Clases
Muestra la estructura del sistema, herencias, relaciones y métodos principales:  
![Diagrama de Clases](9869ccf1-6ff0-46d4-b9a9-13a22ef6743f.png)

### 🧠 Diagrama de Casos de Uso
Define los roles y las acciones posibles de cada actor en el sistema:  
![Casos de Uso](290e7a89-9aa2-4585-b789-cd8eafc8b0d6.png)

---

## 🖥️ Interfaz del Sistema

### 🏠 Menú principal  
![Inicio](0db2804c-5f69-4da5-ad3d-61755608e827.png)

### 👨‍💼 Panel de administrador  
![Admin Menu](14c59738-a487-45ad-852d-6668c4a10f9d.png)

### 🏢 Registro de departamento  
![Departamento](e26a2def-1e0a-44dc-bebc-52fe3c39b9b2.png)

### 👤 Registro de empleado  
![Empleado](0e9971c8-607f-413e-a350-a40da2e3c316.png)

### 📋 Listado de departamentos  
![Lista departamentos](84a19334-25c1-490f-ad6c-ef900942fbbf.png)

### 📋 Listado de empleados  
![Lista empleados](eab17dad-2f5d-46fd-b1eb-618572311e1e.png)

### 👨‍🏭 Panel de empleado  
![Panel empleado](7541e924-638d-462f-a75d-afe04bab36fe.png)

---

## ⚙️ Configuración del Proyecto

Para ejecutar **CompuWork** en tu equipo, sigue los pasos:

### 🔧 Requisitos previos
- **Java JDK 17** o superior instalado.  
- **NetBeans IDE 12+** (recomendado).  
- **JUnit 4.13.2** incluido en el classpath.  

---

### 🚀 Instalación

1. Clona el repositorio:
   ```bash
   git clone https://github.com/tuusuario/CompuWork.git
   ```
2. Abre el proyecto en NetBeans.

3. Asegúrate de tener configurado el JDK 17:

- Clic derecho en el proyecto → Propiedades → Librerías → selecciona JDK 17.

4. Verifica que las dependencias (JUnit) estén en la carpeta Libraries.   

# 🖥️ Ejecución

### ▶️ Ejecutar la aplicación

Ejecuta la clase principal:

```bash
   src/compuwork/CompuWork.java
```


El sistema abrirá la **interfaz principal** con los menús y formularios del sistema.

---

# 🧪 Ejecución de pruebas

Puedes ejecutar las pruebas unitarias desde **NetBeans** o desde la **terminal** usando:


También puedes hacerlo directamente desde el **panel de pruebas de JUnit** en el IDE.

---

# 📄 Licencia

Este proyecto fue desarrollado con fines **académicos** en el marco del curso  
**Programación Orientada a Objetos II — IUDigital 2025.**

Todos los derechos reservados © 2025.

---

# 💬 Contacto

Si deseas colaborar o sugerir mejoras, puedes abrir un **Pull Request**  
o comunicarte directamente con los autores.

---


