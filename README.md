# Project Description
This is a sample project that allows user to view message. Users will also have ability to update message 
.

### Getting Started
* To compile : mvn clean 
* To run: mvn: spring-boot:run
* To see the message: curl localhost:8080

### Prerequisites
* Java 1.8
* Maven
* cURL
* Docker
  
### Deployment
*mvn install
*docker build -f <Docker filename> -t <Image-name> .
*docker run <Image-name>