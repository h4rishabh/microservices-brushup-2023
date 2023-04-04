We can implement User authentication on Users by creating a method   `SecurityFilterChain` in `SecurityConfig.java`
```agsl
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity.build();
    }
```



To disable authenticating particular url - example `/home/public`, we need to add this code in `SecurityConfig.java` 's method  -> `filterChain` method 
```agsl
.requestMatchers("/home/public").permitAll()
```

We can implement Role based authentication on Users by adding below code in `filterChain` method. 

```
.requestMatchers("/home/admin")
.hasRole("ADMIN")
.requestMatchers("/home/normal")
.hasRole("NORMAL")    
```

So  final code will look like 
```
 public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {

        httpSecurity
                .csrf()
                .disable()
                .authorizeHttpRequests()
                .requestMatchers("/home/admin")
                .hasRole("ADMIN")
                .requestMatchers("/home/normal")
                .hasRole("NORMAL")
                .requestMatchers("/home/public")
                .permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .formLogin();

        return httpSecurity.build();
    }
```

Another way to implement ROLE based Authentication is adding `@PreAuthorize` at controller level methods.

```agsl
    @PreAuthorize("hasRole('NORMAL')")
    @GetMapping("/normal")
    public ResponseEntity<String> normalUser(){
        return ResponseEntity.ok("Logged in as Normal user.");
    }
```

And adding `@EnableMethodSecurity` on `SecurityConfig.java` class