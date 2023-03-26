# Circuit Breaker
### The circuit breaker runs our method for us and provides fault tolerance.


Distributed systems can be unreliable. Requests might encounter timeouts or fail completely. A circuit breaker can help mitigate these issues, and Spring Cloud Circuit Breaker gives you the choice of three popular options: Resilience4J, Sentinel, or Hystrix.

## Supported Implementation

### i) Resilience4J
### ii) Spring Retry


## Spring Boot Config

The following starters are available with the Spring Cloud BOM

* Resilience4J - `org.springframework.cloud:spring-cloud-starter-circuitbreaker-resilience4j`

* Reactive Resilience4J - `org.springframework.cloud:spring-cloud-starter-circuitbreaker-reactor-resilience4j`

* Spring Retry - `org.springframework.cloud:spring-cloud-starter-circuitbreaker-spring-retry`


### Steps:
* Add 3 dependency in your project :
```
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-actuator</artifactId>
    </dependency>
    
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-aop</artifactId>
    </dependency>
    
    <dependency>
        <groupId>org.springframework.cloud</groupId>
        <artifactId>spring-cloud-starter-circuitbreaker-resilience4j</artifactId>
    </dependency> 
    
```

* Using `@CircuitBreaker` annotation to a method 

* Fallback method implementation

* Add Circuit Breaker Configuration in `application.properties` 

* Restart `employee-service` and test