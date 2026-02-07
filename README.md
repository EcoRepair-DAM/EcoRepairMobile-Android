# EcoRepair Mobile

EcoRepair Mobile es una aplicación Android orientada a la gestión de dispositivos electrónicos y sus reparaciones. La aplicación actúa como cliente de una API REST desacoplada, permitiendo consultar, crear, modificar y eliminar dispositivos y reparaciones desde un entorno móvil.

El objetivo principal del proyecto es fomentar la reparación y reutilización de dispositivos electrónicos, promoviendo un consumo responsable y alineándose con los Objetivos de Desarrollo Sostenible (ODS) de la Agenda 2030.

El proyecto forma parte de las Prácticas Presenciales de 2º DAM (Curso 2025–2026).

---

## Tecnologías utilizadas

![Android](https://img.shields.io/badge/android-3DDC84.svg?style=for-the-badge&logo=android&logoColor=white)
![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![Retrofit](https://img.shields.io/badge/retrofit-48B983?style=for-the-badge&logo=square&logoColor=white)

- Android SDK
- Java
- Retrofit 2
- Gson
- RecyclerView
- Material Components
- Arquitectura MVP (Model–View–Presenter)

---

## Objetivos del proyecto

- Gestionar un inventario de dispositivos electrónicos desde una aplicación móvil.
- Registrar y consultar reparaciones asociadas a dispositivos.
- Consumir una API REST de forma desacoplada.
- Fomentar la reutilización y la economía circular.
- Aplicar buenas prácticas de arquitectura en Android.
- Ofrecer una interfaz clara, accesible y usable.

---

## Arquitectura

La aplicación sigue una arquitectura **cliente-servidor desacoplada**:

- **Backend**: API REST desarrollada con Spring Boot.
- **Cliente Android**: Aplicación nativa Android desarrollada en Java.
- **Comunicación**: JSON sobre HTTP mediante Retrofit.
- **Servidor**: `http://localhost:8080` (emulador Android usa `http://10.0.2.2:8080`).

En el cliente Android se aplica el patrón **MVP (Model–View–Presenter)** para separar responsabilidades:

- **Model**: Gestión de datos y llamadas a la API.
- **View**: Actividades y layouts.
- **Presenter**: Lógica de presentación y comunicación entre Model y View.

---

## Modelo de datos

La aplicación trabaja con las mismas entidades que la API REST:

### Device
Representa un dispositivo electrónico.

Atributos principales:
- id
- name
- type
- brand
- reusable
- purchaseDate

### Repair
Representa una reparación asociada a un dispositivo.

Atributos principales:
- id
- description
- cost
- repairDate
- repair
- deviceId

Existe una relación lógica **Many-to-One** entre Repair y Device, gestionada a través de la API.

---

## Funcionalidades principales

La aplicación Android permite:

- Visualizar el listado de dispositivos.
- Consultar el detalle de un dispositivo.
- Crear, editar y eliminar dispositivos.
- Visualizar el listado de reparaciones.
- Consultar el detalle de una reparación.
- Crear, editar y eliminar reparaciones.
- Navegación mediante menú superior.
- Confirmación de acciones críticas (borrado).
- Feedback visual mediante mensajes Toast.

---

## Sostenibilidad y ODS

La aplicación se alinea principalmente con el:

- **ODS 12 – Producción y consumo responsables**, al fomentar la reparación y reutilización de dispositivos electrónicos.

De forma indirecta, también contribuye a:
- **ODS 13 – Acción por el clima**, reduciendo la necesidad de fabricar nuevos dispositivos.
- **ODS 8 – Trabajo decente y crecimiento económico**, al apoyar modelos económicos basados en la reparación y el mantenimiento técnico.

---

## Ejecución del proyecto

1. Clonar y ejecutar el backend de la API REST.
2. Asegurarse de que la API esté disponible en `http://localhost:8080`.
3. Abrir el proyecto Android en Android Studio.
4. Ejecutar la aplicación en un emulador o dispositivo físico.
5. La aplicación consumirá la API usando `http://10.0.2.2:8080`.

---

## Backend API REST

Repositorio del backend utilizado por la aplicación móvil:

https://github.com/EcoRepair-DAM/EcoRepiar-API.git

---

## Autor

Proyecto escolar desarrollado como parte de las Prácticas Presenciales  
**2º Desarrollo de Aplicaciones Multiplataforma – Curso 2025–2026**
