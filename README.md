# `AIT BUDDY TEST`
## `By Febri Hasan`

## `Specification:`

Standard | Recommended 
---|--- 
Java | Recommended using java 8
Spring Boot | 2.x.x (Stable Version)

### `Standard Dependency:`
Standard | Recommended | Mandatory | Reference
---|--- | --- | ---
HTTP Client | Open Feign | &check;| [Link1](https://cloud.spring.io/spring-cloud-openfeign) [Link2](https://www.baeldung.com/spring-cloud-openfeign)
Database Repository | Jpa Repository | &check;| [Link](https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.repositories)
Log Interceptor|Zalando | &check;|[Link](https://github.com/zalando/logbook)
Validator|Spring validation| &check;|[Link](https://www.baeldung.com/spring-boot-bean-validation)
Utility |Lombok , Mapstruct | &check;| [Lombok](https://projectlombok.org/) [MapStruct](https://stackabuse.com/guide-to-mapstruct-in-java-advanced-mapping-library/)
Documentation|Swagger / Postman Documentation | &cross;|[Swagger](https://www.baeldung.com/swagger-2-documentation-for-spring-rest-api) [Postman Docs](https://learning.postman.com/docs/publishing-your-api/documenting-your-api/)
Auditing Database|Envers | &cross;| [Link](https://hibernate.org/orm/envers/)


## `Running Instructions:`
Via maven (spring boot)

$ cd project/buddytest
$ mvn spring-boot:run


## `Mock Server from Postman`
https://www.postman.com/bold-comet-212910/workspace/api-tester/documentation/1078111-3e3afcec-ef2a-418a-82ba-13d122c7d776