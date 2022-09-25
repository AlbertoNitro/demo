# API REST demo

## Enunciado
En la base de datos de comercio electrónico de la compañía disponemos de la tabla PRICES que refleja el precio final (pvp) y la tarifa que aplica a un producto de una cadena entre unas fechas determinadas. A continuación se muestra un ejemplo de la tabla con los campos relevantes:
Base de datos relacional en memoria (H2). Se **inicializa una única tabla** con los siguientes datos.
> Table: **prices**

| **brandId** | **startDate**       | **endDate**         | **priceList** | **productId** | **priority** | **priceValue** | **currency** |
|-------------|---------------------|---------------------|---------------|---------------|--------------|----------------|--------------|
| 1           | 2020-06-14-00.00.00 | 2020-12-31-23.59.59 | 1             | 35455         | 0            | 35.50          | EUR          |
| 1           | 2020-06-14-15.00.00 | 2020-06-14-18.30.00 | 2             | 35455         | 1            | 25.45          | EUR          |
| 1           | 2020-06-15-00.00.00 | 2020-06-15-11.00.00 | 3             | 35455         | 1            | 30.50          | EUR          |
| 1           | 2020-06-15-16.00.00 | 2020-12-31-23.59.59 | 4             | 35455         | 1            | 38.95          | EUR          |

Campos:
* **BRAND_ID**: foreign key de la cadena del grupo (1 = ZARA).
* **START_DATE** y **END_DATE**: rango de fechas en el que aplica el precio tarifa indicado.
* **PRICE_LIST**: Identificador de la tarifa de precios aplicable.
* **PRODUCT_ID**: Identificador código de producto.
* **PRIORITY**: Desambiguador de aplicación de precios. Si dos tarifas coinciden en un rago de fechas se aplica la de mayor prioridad (mayor valor numérico).
* **PRICE**: precio final de venta.
* **CURR**: iso de la moneda.

Se pide construir una aplicación/servicio en SpringBoot que provea una end point rest de consulta  tal que:

1. Acepte como parámetros de entrada: fecha de aplicación, identificador de producto, identificador de cadena.
2. Devuelva como datos de salida: identificador de producto, identificador de cadena, tarifa a aplicar, fechas de aplicación y precio final a aplicar.
3. Se debe utilizar una base de datos en memoria (tipo h2) e inicializar con los datos del ejemplo, (se pueden cambiar el nombre de los campos y añadir otros nuevos si se quiere, elegir el tipo de dato que se considere adecuado para los mismos).
4. Desarrollar unos test al endpoint rest que  validen las siguientes peticiones al servicio con los datos del ejemplo:

-          Test 1: petición a las 10:00 del día 14 del producto 35455   para la brand 1
-          Test 2: petición a las 16:00 del día 14 del producto 35455   para la brand 1
-          Test 3: petición a las 21:00 del día 14 del producto 35455   para la brand 1
-          Test 4: petición a las 10:00 del día 15 del producto 35455   para la brand 1
-          Test 5: petición a las 21:00 del día 16 del producto 35455   para la brand 1

Se valorará:
* Diseño y construcción del servicio.
* Calidad de Código.
* Resultados correctos en los test.

## Estado del código
[![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=AlbertoNitro_demo&metric=alert_status)](https://sonarcloud.io/summary/new_code?id=AlbertoNitro_demo)
[![Coverage](https://sonarcloud.io/api/project_badges/measure?project=AlbertoNitro_demo&metric=coverage)](https://sonarcloud.io/summary/new_code?id=AlbertoNitro_demo)


### Tecnologías
`Java` `Maven` `GitHub` `Spring-boot` `Sonarcloud` `JPA` `H2db` `JUnit` `Mockito` `Lombok` `Jacoco`


### :gear: Instalación del proyecto
1. Clonar el repositorio en tu equipo, **mediante consola**:
```sh
> cd <folder path>
> git clone https://github.com/AlbertoNitro/demo.git
```
2. Importar el proyecto mediante **IntelliJ IDEA**
    1. **Import Project**, y seleccionar la carpeta del proyecto.
    2. Marcar **Create Project from external model**, elegir **Maven**.
    3. **Next** … **Finish**.
3. Instalación del proyecto:
```sh
> mvn clean install 
```
4. Ejecución del proyecto:
```sh
> mvn spring-boot:run 
```
5. La API REST queda expuesta en la URL: **http://localhost:8082/api/v0**
6. Para comprobarlo puede realizar una petición HTTP de tipo GET a **http://localhost:8082/api/v0/ping** o 
7. Un ejemplo de busqueda de precio seria: **http://localhost:8082/api/v0/prices/search?brandId=1&productId=35455&applicationDate=2020-11-16T10:50:04.874Z**


### Base de datos
Base de datos relacional en memoria (H2). Se **inicializa una única tabla** con los siguientes datos.
> Table: **prices**

| **brandId** | **startDate**       | **endDate**         | **priceList** | **productId** | **priority** | **priceValue** | **currency** |
|-------------|---------------------|---------------------|---------------|---------------|--------------|----------------|--------------|
| 1           | 2020-06-14-00.00.00 | 2020-12-31-23.59.59 | 1             | 35455         | 0            | 35.50          | EUR          |
| 1           | 2020-06-14-15.00.00 | 2020-06-14-18.30.00 | 2             | 35455         | 1            | 25.45          | EUR          |
| 1           | 2020-06-15-00.00.00 | 2020-06-15-11.00.00 | 3             | 35455         | 1            | 30.50          | EUR          |
| 1           | 2020-06-15-16.00.00 | 2020-12-31-23.59.59 | 4             | 35455         | 1            | 38.95          | EUR          |


### Arquitectura hexagonal (diagrama de paquetes)
![Arquitectura hexagonal - Diagrama de paquetes](docs/diagrama-de-paquetes.png))


