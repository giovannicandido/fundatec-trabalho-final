# Iniciando com o projeto

Necessário ter o JDK 11 ou mais novo instalado. 

Acesse [https://www.oracle.com/java/technologies/downloads/#java11](https://www.oracle.com/java/technologies/downloads/#java11) ou 
 [https://www.azul.com/downloads/?package=jdk#download-openjdk](https://www.azul.com/downloads/?package=jdk#download-openjdk)

Instale o mariadb ou o mysql.

Esse projeto está configurado para rodar com o mariadb para alterar para mysql modifique o arquivo pom.xml

Remova:

```xml
<dependency>
    <groupId>org.mariadb.jdbc</groupId>
    <artifactId>mariadb-java-client</artifactId>
    <scope>runtime</scope>
</dependency>
```

Adicione:

```xml
<dependency>
    <groupId>com.mysql</groupId>
    <artifactId>mysql-connector-j</artifactId>
    <version>8.0.31</version>
    <scope>runtime</scope>
</dependency>

```

**Dica:** Para localizar biliotecas e suas versões mais atuais use o https://mvnrepository.com

Altere o arquivo **src/main/resources/application.properties**

Altere a primeira linha para algo do tipo:

```properties
spring.datasource.url=jdbc:mysql://localhost/tfinal
```

## Rodando um banco Maria DB com docker

Com o docker instalado rode o comando abaixo para ter um servidor MariaDB instalado:

```
docker run -d --restart always --name mariadb -p 3306:3306 --env MARIADB_ROOT_PASSWORD=fundatec mariadb:10.9
```

Você também pode usar algum instalador se não quiser usar docker: https://mariadb.org/download

### Criando o banco de dados para o projeto

Acesse https://blog.gsilva.pro/roteiro-para-aula-de-introducao-ao-banco-de-dados-fundatec#heading-acessando-o-mysql e 
veja como fazer no DBEaver o nome do banco deve ser **tfinal** se não quiser modificar o **application.properties**

Rode a aplicação

