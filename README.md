# Spring Boot Microservices with Consul, Spring Cloud Gateway and Docker

Este playground possui 3 microserviços demo Spring Boot Service: deptservice, orgservice e userservice.
Também possui um app, *gatewayservice*, Spring Cloud Gateway que usa o Consul Service Discovery como gateway
destes microsserviços.

Todas as configurações necessárias para o Service Discovery do Consul estão nos respectivos arquivos
application.properties de cada microserviço e do gateway.


### Instruções de execução:

* Entre em cada subdiretorio, *depservice, gatewayservice, orgservice, userservice*, e execute o seguinte comando dentro
de cada um:

***mvn package -Dmaven.test.skip***

* Depois, volte ao diretorio raiz *consul-spring-gateway* e execute o seguinte comando:

***docker-compose up -d --build***

* Terminado tudo sem erros, acesse com um browser a página do Consul em:

***http://0.0.0.0:8500***

Deve ser possível ver a seguinte página do Consul:

![img.png](img.png)

### Endpoints:

* Acesso do OrganizationService pelo Gateway:
http://0.0.0.0:8080/organization/details

* Acesso direto OrganizationService (sem gateway):
http://0.0.0.0:3003/organization/details


* UserService pelo Gateway:
http://0.0.0.0:8080/user/getUserDetailsById?id=1
* Acesso direto UserService (sem gateway):
http://0.0.0.0:3001/user/getUserDetailsById?id=1


* Acesso do DepartmentService pelo Gateway:
http://0.0.0.0:8080/department/getDepartmentDetailsById?id=1
* Acesso direto DepartmentService (sem gateway):
  http://0.0.0.0:3002/department/getDepartmentDetailsById?id=1

#### Comunicação entre serviços:

* Endpoint do DepartmentService comunicado-se com o UserService pelo Gateway:
http://0.0.0.0:8080/department/getUsersByDeptId?deptId=1

### Artigo de referência:
https://blog.devops.dev/spring-boot-microservices-with-consul-spring-cloud-gateway-and-docker-789b624d1d32
