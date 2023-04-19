## Spring Security
* To add Spring Security in the project we need to add below dependency in the project's `pom.xml`
```agsl
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-security</artifactId>
</dependency>
```
* Start your application now, Spring security won't allow you to access your endpoint without a valid credentials.
* Since we have not configured any user yet, Spring will create a user automatically `user` and password will be printed in the console.
```agsl
Using generated security password: 3953376f-0ec8-42a6-b965-632a0b301bc7
```
* You can use the password from console to access your API endpoints. This way, you will get a new password whenever you start the application.
* Another way to configure any user is through application.properties
    * Add user & password field in `application.properties`
    ```
         spring.security.user.name=hrishabh
         spring.security.user.password=test
  ```
*
