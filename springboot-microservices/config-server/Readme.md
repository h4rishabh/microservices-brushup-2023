## Enabling Config-Server property refresh
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