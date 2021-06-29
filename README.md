# API ACTIVOS FIJOS

Los activos fijos de una empresa son los bienes materiales, son necesarios para el
funcionamiento de la empresa y no se destinan para la venta, ejemplos de estos son: bienes
inmuebles, maquinaria, material de oficina, etc.

Estos activos fijos tienen características comunes entre todas como son: nombre, descripción,
tipo, serial, numero interno de inventario, peso, alto, ancho, largo, valor compra, fecha de
compra.

Los activos se pueden asignar a un área o persona, si es a un área esta se encuentra en una
ciudad (diferentes áreas se encuentran en diferentes ciudades).

Por lo tanto, se decide diseña un API RESTFul que permita administrar los activos y permita:

1. Buscar los activos fijos por: tipo, fecha de compra y/o serial.
2. Crear nuevos activos.
3. Actualizar activos.

## Tecnologías

### BASE DE DATOS
* MySQL

### BACKEND
* Java 8
* Maven
* Framework Spring Boot
* Postman

### FRONTEND
* Angular 8
* Bootstrap 4

## Instalación

**Paso 1.** Abrir la consola y ejecutar el siguiente comando:
```bash
git clone https://github.com/ingalexandra/ACTIVOS_FIJOS.git
```
**Paso 2.** Para ubicarse en el directorio con los entregables, se debe ejecutar el siguiente comando:
```bash
cd entregables
```

**Paso 3.** En la carpeta se encuentra el script de creación del esquema de la base de datos (MySQL). Este script se puede ejecutar con la aplicacion 
Workbench en una instancia local. 

**Paso 4.** Una vez creada la base de datos, se debe crear una carpeta llamada **config** en la carpeta Disco local (C:) (Si el sistema operativo de su máquina es Windows) o en la raíz del sistema (Si el sistema operativo de su máquina es Linux).

**Paso 5.** Ubicados en la carpeta **entregables**, se debe ejecutar el siguiente comando para correr la aplicación en java:
```bash
java -jar api_rest-0.0.1-SNAPSHOT.jar
```

**Paso 6.** Ahora, vamos a instalar un servidor http con el siguiente comando:
```bash
npm i -g http-server --save
```

Una vez instalado y ubicados en la carpeta **entregables**, ejecutamos la aplicación con el siguiente comando:
```bash
http-server dist/
```

Y por último, abrimos en el navegador la siguiente URL: http://127.0.0.1:8080/web-front/

## Licencia
[MIT](https://choosealicense.com/licenses/mit/)
