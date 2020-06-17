# MoviliApp

MoviliApp nace de la motivación de mejorar un sistema de transporte tan criticado en la ciudad de Bogotá como lo es transmilenio, MoviliApp es un proyecto en curso que busca una aplicación para mejorar y brindar soluciones a sistemas de transporte masivo que por una u otra razón no disponen de análisis de datos y que debido a esto tienen problemas al administrar de manera eficiente rutas, servicios y usuarios. 🚠🚋

## Estructuras de datos
Este proyecto se realiza como actividad de la asignatura de Estructuras de Datos, dictada en la carrera de Ingeniería de sistemas y computación de la Universidad Nacional De Colombia.💻📚
### Estructuras de datos usadas.

 1. **HashTables**📲: Se usaron principalmente para busquedas, puesto que su eficiencia es de orden constante *O(1)*. Usadas en inicio de sesión, para busqueda de usuarios y su contraseña, Usada en busquedas de Rutas y Estaciones, y busqueda de informacion de rutas y sus buses en servicio. 
 ***
 2. **Doubly LinkedList**🔙🔜:  Se utilizaron para tener información sobre una respectiva ruta, su sucesor y su antecesor, cada Nodo(en este caso Bus) tendrá información de el Bus que lo precede y del Bus que lo sucede. Así como también se podrá ver la información de todos los buses que hacen una ruta en su totalidad.
 ***
 3. **Cola de prioridad**👩🏻‍🦼👩🏻‍🦯🚶🏻‍♂️🚶🏻‍♀️ :  Esta estructura se utilizó para saber que estaciones son criticas o que rutas son las más solicitadas, la estación con mayor número de personas o la ruta con más solicitudes será la de mayor prioridad. Esta cola de prioridad fue implementada con un Heap.

## Pendientes

 - [x] **Inicio de Sesión Usuarios**
 - [x] **Inicio de Sesión Trabajador**
 - [ ] **Consola principal de Administrador**
 - [ ]  **Visualización Total de Usuarios**
 - [ ]  **Sistema de pagos a partir de Codigo QR**
 - [ ]  **Sistema de recargas**
 - [x] **Iniciar,cambiar,terminar Ruta**
 - [ ] **Buscar estacion o ruta y su información** 
 - [ ] **Mapa en tiempo real**


<!--stackedit_data:
eyJoaXN0b3J5IjpbLTExODg3MDk5NDNdfQ==
-->