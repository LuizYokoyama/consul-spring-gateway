# Spring Boot Microservices with Consul, Spring Cloud Gateway and Docker

Este playground possui 3 microserviços demo Spring Boot Service: deptservice, orgservice e userservice.
Também possui um app, *gatewayservice*, Spring Cloud Gateway que usa o Consul Service Discovery como gateway
destes microsserviços.

Todas as configurações necessárias para o Service Discovery do Consul estão nos respectivos arquivos
application.properties de cada microserviço e do gateway.

### git2consul

Também está incluíndo no docker-compose o um script que roda o git2consul 
para pegar arquivos .yml .properties e .json do github e enviar/atualizar no Consul K/V.

***Configurações para o git2consul:***

As configurações podem ser alteradas em:

*config/git2consul.json*

Neste exemplo, os arquivos que serão enviados para o Consul K/V estão em:

*userservice/src/main/resources/*

Os arquivos/diretórios de configuração localizados neste diretório serão automaticamente
atualizados no Consul Keys/Values.

Após a execução do ***docker-compose***, pode-se verificar no Consul Keys/Values os valores atualizados.

### Usando os K/V do consul

O **userservice** foi atualizado para usar as *Keys/Values* do Consul.

Em seu arquivo pom.xml foram adicionados :

***spring-cloud-starter-bootstrap***

***spring-boot-configuration-processor***

Para usar o bootstrap, o arquivo de configuração application.properties teve que ser alterado para bootstrap.properties
*(também poderia-se usar bootstrap.yml)*. Também é necessário mover os arquivos para um sub-diretório como o ***config*** 
neste caso.

Para se acessar os valores no K/V do Consul, são necessárias as seguintes configurações:
Além do formato do arquivo (**yaml neste caso**), são necessários três nomes, para fazer uma chave de três níveis no Consul 
***(exigido pelo Spring Cloud)*** e, assim, formar a chave completa de acesso. O ***prefixo*** deve ser o nome do repositório 
definido na configuração do git2consul em ***config/git2consul.json***, porque o ***git2consul*** salva os arquivos no 
***K/V do Consul*** com o ***prefixo***
do repositório que, neste caso, é ***user-service***. O ***default-context***, neste caso, é o sub-diretório **config**, e o 
***data-key*** que, neste caso, deve ser o ***nome do arquivo e sua extenção***.

![img_2.png](img_2.png)

No Consul, a ***chave*** ficará assim: ***user-service/config/teste.yml*** E o seu ***value*** será o conteúdo do arquivo:

![img_3.png](img_3.png)

Caso essa chave de três níveis não fosse definida assim, os valores ***default*** da chave que o Spring Cloud acessaria 
seriam: ***config/application/data***. Sendo assim, não acessaria os valores gravados pelo ***git2consul***.

Essa chave de ***três níveis*** é uma exigência para que o *Spring Cloud* possa acessar o seu ***value*** através do código:

![img_4.png](img_4.png)



Ao rodar este sistema, os valores gravados no K/V do Consul poderão ser acessados em:

http://0.0.0.0:8080/user/getConfigFromConsul1

http://0.0.0.0:8080/user/getConfigFromConsul2

Nos links acima são lidos valores de */userservice/src/main/resources/config/teste.yml* que foram enviados para o K/V do Consul.


Ao se atualizar o arquivo acima no github, os valores no Consul são automaticamente atualizados pelo git2consul.



### Instruções gerais de execução:

* Execute o seguinte comando dentro deste diretorio raiz do projeto, para que todos os módulos sejam construídos:

***mvn package -Dmaven.test.skip***

* Depois, execute o seguinte comando:

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

### Referências:

* https://maven.apache.org/guides/introduction/introduction-to-the-pom.html#What_is_a_POM

* https://blog.devops.dev/spring-boot-microservices-with-consul-spring-cloud-gateway-and-docker-789b624d1d32

* https://github.com/indrabasak/spring-consul-example/tree/master/client

* https://cloud.spring.io/spring-cloud-static/spring-cloud-consul/2.2.3.RELEASE/reference/html/appendix.html

#### Script de autoria da Jhipster:

* https://github.com/jhipster/consul-config-loader