# Prediccion del clima de un sistema solar

_Mediante un **Job** se simula la orbita de tres planetas durante 10 años. En base ciertos criterios de posicion de los planetas y el sol se determinan el clima e intensidad._
_Se expone una **REST API** para consultar el estado del clima por cada dia y un informe._

## Comenzando 🚀

_Estas instrucciones te permitirán obtener una copia del proyecto en funcionamiento en tu máquina local para propósitos de desarrollo y pruebas._

Mira **Deployment** para conocer como desplegar el proyecto.


### Pre-requisitos 📋

_Que cosas necesitas para instalar el software_

```
Java JDK 1.8.0_171
Apache Maven 3.6.0
```

### Instalación 🔧

_Clonar el repositorio en la maquina local e instalar las dependencias con maven_

```
mvn install
```

_Luego puedes empaquetar el projecto para deployar_

```
mvn package
```

_Por ultimo, puede levantar la intancia tomcat con el siguiente comando parado en la carpeta del proyecto_

```
java -jar target/solar-0.0.1-SNAPSHOT.jar
```

_Puedes utilizar las siguientes URIs desde un browser o desde un REST Client para probarlo_

```
http://localhost:8080/clima?dia=75 // Consulta el clima para un dia especifico
http://localhost:8080/informe      // Consulta el informe del clima en los 10 años
```

## Ejecutando las pruebas ⚙️

_Para ejecutar las pruebas unitarias utilizar el siguiente comando_

```
mvn test
```

## Deployment 📦

_El deploy es realizado en un cuenta de heroku con el siguiente comando_

```
git push heroku master
```
_Para verificar los servicios, se exponen los siguiente recursos_

```
https://solar-meli.herokuapp.com/clima?dia=75
https://solar-meli.herokuapp.com/informe
```

## Construido con 🛠️

_Herramientas utilizadas en el proyecto_

* [Spring Boot](https://spring.io/projects/spring-boot) - El framework web usado
* [Maven](https://maven.apache.org/) - Manejador de dependencias
* [Heroku](https://www.heroku.com/) - Cloud Application Platform

## Autores ✒️


* **Huallpa Nestor** - *Trabajo Inicial* - [nhuallpa](https://www.linkedin.com/in/nestor-huallpa-7239b011)

