<div align="center">
  <a><img src="logo.png" width="400" alt="SpringBoot" /></a>
</div>

# SpringCrud
Este projeto é uma simples aplicação CRUD, construído sobre o framework Spring Boot. 
Porém incorpora recursos importantes como tratamento global de erros e implementa 
validação de dados de entrada. A organização do projeto foi feita com base na Clean 
Architecture. Os principais endpoints da aplicação são:

### Students
```markdown
GET /students - Recuperar uma lista de todos os dados.

GET /students/{id} - Recuperar um dado.

POST /students - Registrar um novo dado.

PUT /students/{id} - Alterar os dados.

DELETE /students/{id} - Deletar o dado.
```
### Articles
```markdown
GET /articles - Recuperar uma lista de todos os dados.

GET /articles/{id} - Recuperar um dado.
```

## Dependecias Utilizadas:
- spring-boot-starter-data-jpa
- spring-boot-starter-web
- h2 (com.h2database)
- postgresql
- spring-boot-starter-test
- spring-boot-starter-validation

