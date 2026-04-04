## Descripción del proyecto

Este es el repositorio correspondiente a la entrega de mi/nuestro Taller 01 para la asignatura de ITI - ICCI (I Semestre - 2026).
El proyecto consiste en un programa de consola hecho en Java que sirve para llevar un registro del tiempo que perdemos (o "procrastinamos") en actividades de ocio. Según la historia del taller, a un grupo de amigos (Martín, Catalina y Estefanía) se les arruinó la app que usaban para esto, así que tuvimos que programarles un software nuevo que lea los registros antiguos que se salvaron y permita gestionar datos nuevos.

El sistema lo dividimos en dos partes principales:
Un Menú de Usuarios, donde cada persona debe iniciar sesión con su contraseña para poder registrar, modificar o borrar sus propias actividades.
Un Menú de Análisis de acceso libre, que calcula estadísticas generales para ver qué actividad es la más repetida o para exponer al usuario con mayor nivel de procrastinación.

## Integrantes

| Nombre Completo | RUT | Usuario GitHub |
| :--- | :--- | :--- |
| Lukas Paolo Toshisuke Cortes Alfaro | 22.108.123-4 | [@ToshiLuk](https://github.com/ToshiLuk) |

## Estructura del proyecto

```text
📂 LukasCortes_Taller1POO/
├── 📂 datos/
│   ├── Usuarios.txt          # Archivo con credenciales de acceso (Formato: ID;Contraseña)
│   └── Registros.txt         # Archivo con historial de actividades (Formato: ID;Fecha;Horas;Actividad)
│
├── 📂 src/
│   └── 📂 logica/
│       └── Main.java         # Archivo principal con lectura de archivos y navegación de menús
│
└── README.md                 # Documentación y manual de ejecución del proyecto
```
`
