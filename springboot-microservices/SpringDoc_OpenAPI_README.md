## SpringDoc
`springdoc-openapi` java library helps to automate the generation of API documentation using spring boot projects


`spingdoc-openapi` java library provied integration between `spring-boot` and `swagger-ui`

Automatically generates documentation in JSON/YML and HTML format API

This library Supports:
* OpenAPI 3
* Spring-boot v3 (Java 17 & Jakarta EE9)
* JSR-303, specially for @NotNull, @Min, @Max and @Size
* Swagger-ui
* OAuth 2

This is community based project, not maintained by Spring Framework Contribution.

### Development Step:
* Adding `springdoc-openapi` maven dependency

```agsl
    <dependency>
        <groupId>org.springdoc</groupId>
        <artifactId>springdoc-openapi-starter-webmvc-ui</artifactId>
        <version>2.1.0</version>
    </dependency>
```

* Defining general API information(Using annotation). Add below code in main class to add API information
```agsl
@OpenAPIDefinition(
    info = @Info(
        title = "Spring boot Rest API Documentation for XYZ",
        description = "Spring boot Rest API Documentation for XYZ",
        version = "v1.0",
        contact = @Contact(
            name = "John Doe",
            email = "johndoe@gmail.com",
            url = "https://www.github.com/h4rishabh"
        ),
        license = @License(
            name = "Apache 2.0",
            url = "https://www.github.com/h4rishabh/licences"
        )
    ),
    externalDocs = @ExternalDocumentation(
        description = "Spring boot Rest API Documentation for XYZ",
        url = "https://github.com/h4rishabh/microservices-brushup-2023/tree/master/springboot-microservices"
    )
)
```
* Customizing Swagger API Documentation with Annotation
    * On Controller Class - Using `@Tag` annotation
    ```
    @Tag(
        name = "Rest APIs for XYZ Service",
        description = "Description of XYZ Service"
    )
  ```
  * On HTTP methods - Using `@Operation` annotation
  ```agsl
    @Operation(
        summary = "Create Department Rest API",
        description = "Used to create new Department in Database"
    )
    @ApiResponse(
        responseCode = "201",
        description = "HTTP Status 202 Created"
    )
    ```

* Customizing Swagger Models documentation with Annotation
    * On class - Using `@Schema` annotation
    ```agsl
    @Schema(
        description = "DepartmentDTO Models Information"
    )
    public class DepartmentDTO {
        // class definition
    }
    ```
    * On fields - Using `@Schema` annotation
  ```agsl
    @Schema(
        description = "Department Name"
    )
    private String departmentName;
    ```