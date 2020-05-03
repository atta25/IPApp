# IPApp

## Instrucciones para correr la App

#### Clonarse el proyecto y ejecutar las siguientes instrucciones:

1) cd IPApp
2) mvn clean package
3) docker build -t spring-boot:1.0 .
4) docker run -d -p 8080:8080 -t spring-boot:1.0

## Y para poder ver la home entrar a: 
- http://localhost:8080


