## Steps to create Organization Service
* create `organization-service` project using Spring boot
* Configure `MySQL` database
* Create Organization `Data JPA entity` and `Spring Data JPA Repository`
* Create `OrganizationDTO` & `OrganizationMapper`
* Build Save Organization REST API
* Build Get Organization REST API
* Make REST API call from `employee-service` to `organization-service`
* Register `organization-service` as Eureka Client
* Refactor `organization-service` to Config Server
* Configure Spring Cloud Bus
* Configure Routes for Organization Service in API gateway
* Implement Distributed tracing in `organization-service`.