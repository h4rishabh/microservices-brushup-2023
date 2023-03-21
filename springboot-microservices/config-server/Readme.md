# Config Server
### Config Server is used to externalize the config server. You can put all config details of all `servers` at common place `GitHub` 

By Using Config Server, we don't have to restart servers after any change in configration.  

## Enabling Config-Server property refresh

## i) Using actutors `/refresh` endpoint
We can enable auto refresh of any property stored in GitHub without restrarting the Microservice/Server. (Config server needs to be re-started).
* We need to add dependency in Actuator dependency
```
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-actuator</artifactId>
    </dependency>
```
* Add 
`management.endpoints.web.exposure.include=*` to enable actuator's endpoint 


* Add `@RefreshScope` annotation in controller class and add `@Value("${propertyName}")` in the field.
```
@RefreshScope
@RestController
public class MessageController {

    @Value("${spring.boot.message}")
    private String message;

    @GetMapping("message")
    public String getMessage(){
        return message;
    }
}
```
* Now even when the config-server's config is updated, only `config-server` needs to be started.

* In Postman, hit the URL `http://localhost:8080/actuator/refresh` as `POST` request  to refresh config

## ii) Using Sring Cloud Bus Module
In order to reload config server, triggering `/refresh` is not a feasible solution. This is not viable & possible if you have large number of Application.

Spring Cloud Bus Module provides a solution for that. It can be used to link Multiple application with message broker and we can broadcast configuration changes.

### Steps:
* Add `spring-cloud-started-bus-amqp` dependency
```
    <dependency>
        <groupId>org.springframework.cloud</groupId>
        <artifactId>spring-cloud-starter-bus-amqp</artifactId>
    </dependency>
```

* Install RabbitMQ using docker


* RabbitMQ configuration in application.properties of `department-service` and `employee-service`


* Create Simple REST Api in `employee-service`


* Change `department-service` and `employee-service` properties file and call `/busrefresh`