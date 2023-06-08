### Vídeo Pitch Matéria de digital

https://www.youtube.com/watch?v=KqlbojUZsVU

### Vídeo Demonstração APP 
https://youtu.be/t9hTF14bxxM

### Execução da API
 > Para executar a API, execute a classe **beRecycleApplication**. Deixamos um txt com as tabelas do banco para serem criadas no SQL Developer

<br>

### Endpoints

<details>
  <summary>USER Entity</summary>

  <br>
  
POST: **http://localhost:8080/user**

```javascript
{
  "cep": "03194-653",
  "cnh": "31326861616",
  "email": "david@gmail.com",
  "housenumber": "389",
  "name": "David Augusto",
  "pass": "teste1234",
  "phone": "(11) 95037-6156",
  "type": "Transportador",
  "vehicle": "BR01838",
}
```
  >  Registro do transportador
  <br>

```javascript
{
  "cep": "09831-386",
  "email": "mantovanivitor@gmail.com",
  "housenumber": "891",
  "name": "Vitor Mantovani",
  "pass": "teste1234",
  "phone": "(11) 93678-4513",
  "type": "Beneficiário",
}
```
  >  Registro do beneficiário
  <br>

```javascript
{
  "cep": "04115-060",
  "cnpj": "13.590.976/8315-46",
  "email": "lucas.amadeu.soares@gmail.com",
  "housenumber": "375",
  "name": "Lucas Amadeu",
  "pass": "teste12345",
  "phone": "(11) 95078-2114",
  "type": "Doador",
}
```
 >  Registro do doador

  <br>
  <br>

  
POST: **http://localhost:8080/user/login**

 ```javascript
{
    "email": "lucas.amadeu.soares@gmail.com",
    "pass": "teste12345"
}
```  
  > Login do usuário
  
  <br>
  <br>

GET: **http://localhost:8080/user**
  > Rota para listagem dos usuários
  
  <br>
  <br>
  
PUT: **http://localhost:8080/user**
  
```javascript
{
    "id": 1,
    "name": "Lucas Soares",
    "cep": "06473-073",
    "phone": "(13)99720-9036",
    "email": "luquinhas123@gmail.com",
    "pass": "lucas123",
}
```
  > Json com o Id do usuário e os dados que podem ser atualizados
  
  <br>
  <br>
  

DELETE: **http://localhost:8080/user/{id}**
  > A rota recebe o Id do usario e realiza o soft delete
</details>


<details>
  <summary>POST Entity</summary>
  
  <br>
  
  POST: **http://localhost:8080/post**

```javascript  
{
    "name": "Lucas Amadeu",
    "userId": 1,
    "phone": "(13)99720-9036",
    "email": "lucas.amadeu.soares@gmail.com",
    "local": "São Paulo, SP",
    "description": "2 kg de arroz",
    "type": "Doador"
}
```
  >  Registro do post
  
  <br>
  <br>

GET: **http://localhost:8080/post**
 > Lista todas as publicações que estão ativas
  
  <br>
  <br>

GET: **http://localhost:8080/post/user/{id}**
 > Rota retorna todas as publicações de um usuário
  
  <br>
  <br>

GET: **http://localhost:8080/post/{id}**
 > Rota retorna post com o Id passado
  
  <br>
  <br>

PUT: **http://localhost:8080/post**

```javascript
{
    "id": 1,
    "active": 0 ou 1
}
```
 > Atualiza se o post esta ativo(1) ou não (0)
  
  <br>
  <br>

DELETE: **http://localhost:8080/post/{id}**
 > Desativa o post com o Id passado
</details>
