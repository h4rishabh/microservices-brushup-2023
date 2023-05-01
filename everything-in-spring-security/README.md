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

### CSRF - Cross Site Request Forgery
When you login to a site example Banking Website, a session is created. Now, without logging out you went to some malicious site which steal your cookies. 
The Malicious site can execute some bank transfer without your knowledge using Cookie.

#### How to Protect from CSRF?
* #### Synchronizer Token Pattern 
  * A token is created in each request
  * To make any update(POST/PUT..) you need a CSRF token from the previous request.
  * `CSRF` is tied with your session cookies.
  * In case your request is `stateless` you don't need to worry about `CSRF`

* #### Same Site cookies (Set-cookies: SameSite=Strict)
  * This won't allow your cookie to go to other site.
  * To enable this, you need to make config in `application.properties`
  ```agsl
    server.servlet.session.cookie.same-site=strict
  ```

#### How to disable CSRF?
We need to override default conig of SpringBootWebSecurityConfiguration.
So we created new Class -> BasicAuthSecurityConfiguration.java in which we are overriding FilterChain method.
to disable CSRF We write `http.csrf().disable();`

After disabling, you can send `POST` request without adding CSRF token.


## CORS
Cross origin Request Sharing


* Browser does not allow AJAX calls to resources outside current origin.
* CORS is a specification that allows you to configure cross-domain requests.
  * Global Configuration
    * Configure addCorsMappings callback method in WebMvcConfigurer
  * Local Configuration
    * @CrossOrigin - Allow from all origins
    * @CrossOrigin(origin = "https://abc.com") - allow from specific origin

## Storing User Credentials
* Users can be stored in:
  * In memory - For test purpose. Not recommended for Production
  * Database - You can use JDBC/JPA to access the credentials.
  * LDAP - Lightweight Directory Access Protocol
    * Open Protocols for directory services and authentication.


# Getting started with JWT
### Basic Authentication
  * No Expiry time
  * No User details
  * Easily decoded
  
### How about custom token system?
  * Custom Structure
  * Possible Security Flaws
  * Service provided & Service Customer should

### JWT (Json Web Token)
* Open, industry standard for representing claims security between two parties
  * Can contain User Details and Authorizations 

### What does JWT contains?

There are three things im a single JWT token
* Header
* Payload
* Signature


* `Header`
  * Type: JWT
  * Hashing Algorithm: HS512
* `Payload`
  * Standard Attribute
    * iss : The issuer
    * sub: the subject
    * aur: the audience
    * exo: when does token expire
    * iat: when was token issued?
  * Custom Attribute
    * yourattr1: Your custom attribute 1 
* `Signature:`
  * Include a secret


* `Symmetric Key Encryption:`
  * It uses same Key for encryption and decryption.
  * Key Factor 1: Choose the right encryption key
  * Key Factor 2: How do we secure the encryption key?
  * Key Factor 3: How do we share the encryption key?

* `Asymmetric Key Encryption:`
  * Two Keys: public key & private key
  * Share public key with everyone, keep the private key with you.
  * Even if you have public key, you wouldn't be able to know private key.


###  High level JWT flow:
* `1: Create JWT`
  * Needs Encoding
    * User Credentials
    * User Data(payload)
    * RSA key pair
  * We will create a JWT Resource for creating JWT later
* `2: Send JWT as part of request header`
  * Authorization Header
  * Bearer Token
  * Authorization: Bearer ${JWT_TOKEN}
* `3: JWT is Verified`
  * Needs decoding
  * RSA key pair(public key)

#### Getting Started with JWT Security Configuration:
* JWT Authentication using Spring boot's OAuth2 Resource Server
  * `1: Create Key Pair`
    * We can use java.security.KeyPairGenerator
    * We can use openssl as well 
  * `2: Create RSA Key object using key pair`
    * com.nimbusds.jose.jwk.RSAKey
  * `3: Create JWKSource(JSON Web key source)`
    * Create JWKSet (a new JSON web key set) with the RSA key
    * Create JWKSource using the JWKSet
  * `4: Use RSA public key for decoding`
    * NimbusJwtDecoder.withPublicKey(rsaKey().toRSAPublicKey()).build()
  * `5: User JWKSource for Encoding`
    * return new NimbusJwtEncoder(jwkSource())