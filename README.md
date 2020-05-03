# IPApp

### Instrucciones para correr la App (ubicarse dentro de la raíz del proyecto y ejecutar las siguientes instrucciones)

1) mvn clean package
2) docker build -t spring-boot:1.0 .
3) docker run -d -p 8080:8080 -t spring-boot:1.0

### Y para poder ver la home entrar a: 
- http://localhost:8080


