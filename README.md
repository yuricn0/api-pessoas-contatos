# Projeto Pessoas e Contatos  

## Descrição do Projeto  
Este projeto é uma API REST desenvolvida com Spring Boot para gerenciar pessoas e seus contatos. Ele permite cadastrar, atualizar, listar e excluir registros de pessoas e seus respectivos contatos.  

---

## Tecnologias Utilizadas  
- Java 21 
- Spring Boot  
- Spring Data JPA + Hibernate  
- MySQL  
- Swagger (Springdoc OpenAPI)  
- Postman (para testes)  

---

## Estrutura do Projeto  
	controller/: Contém as classes responsáveis por expor os endpoints da API e lidar com as requisições HTTP.
	•	dto/: Contém os Data Transfer Objects (DTOs), que são usados para transferir dados entre as camadas da aplicação.
	•	entity/: Contém as entidades, que representam as tabelas do banco de dados.
	•	repository/: Contém as interfaces que fazem o acesso ao banco de dados, utilizando Spring Data JPA.
	•	service/: Contém as classes responsáveis pela lógica de negócio da aplicação.
	•	config/: Contém as configurações da aplicação, como configurações de segurança, Swagger, etc.
	•	exceptions/: Contém as classes para tratamento de exceções personalizadas.
	•	Application.java: Classe principal onde a aplicação Spring Boot é iniciada
