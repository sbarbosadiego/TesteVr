# Teste VR

Projeto de um sistema de cadastro de clientes, produtos e pedidos. Neste projeto é utilizado o padrão [MVC](https://pt.wikipedia.org/wiki/MVC) (Model, View, Controller), é realizado operações de [CRUD](https://pt.wikipedia.org/wiki/CRUD) (Create, Read, Update, Delete), utilizando tecnologias como JPA/Hibernate para mapeamento objeto-relacional, [Lombok](https://projectlombok.org/) para reduzir a verbosidade do código, Maven para gerenciamento de dependências, utilizando o banco de dados [Postgres](https://www.postgresql.org/), e contando com uma interface em Java/Swing com [FlatLaf](https://www.formdev.com/flatlaf/), que possui um visual mais limpo e moderno.

##
### Configurações de Ambiente
- SO: Xubuntu 22.04 / Pop!_OS 22.04 / Windows 10
- JDK: 17.0.11
- Postgres: 16

### Instalação/Configuração
- Java: [Windows](https://www.youtube.com/watch?v=QekeJBShCy4) / [Linux](https://www.youtube.com/watch?v=Kn87QF1mEcY")
- Postgres: [Windows](https://www.youtube.com/watch?v=UbX-2Xud1JA) / [Linux](https://youtu.be/1jSb4LJH1dw)
- NetBeans: [Windows](https://www.youtube.com/watch?v=dmnerOpFj1E) / [Linux](https://www.youtube.com/watch?v=SiPJcbrW9K8")

### Acesso ao Banco de dados
Para realizar o acesso ao banco de dados, deve ser acessado o diretório resources\META-INF, e no arquivo persistence.xml, dentro deste informar o usuário de acesso ao banco de dados e senha.
```
<property name="jakarta.persistence.jdbc.user" value="USUARIO"/>
<property name="jakarta.persistence.jdbc.password" value="SENHA"/>
```
Na primeira execução deve estar habilitado criar as entidadades mapeadas pelo JPA.
```
<property name="jakarta.persistence.schema-generation.database.action" value="create"/>
```
Em seguida criar uma base de dados com o seguinte nome teste_vr
<pre>
CREATE DATABASE teste_vr;
</pre>
A após isso pode ser executado o projeto, com o mapeamento feito através do JPA/Hibernate, as tabelas e seus relacionamentos serão configurados automaticamente.
