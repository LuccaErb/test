 # Gerenciamento de Adocão de Animais
 
 
 ## Descrição da aplicação:

1. Gerenciamento de Animais:
   Criar um novo animal para adoção.
   Listar todos os animais disponíveis.
   Buscar um animal pelo seu ID.
   Atualizar as informações de um animal.
   Remover um animal do sistema.
   Marcar um animal como "Adotado(setStatus(false))" quando uma adoção for realizada.

2. Gerenciamento de Adotantes:
   Cadastrar um novo adotante.
   Listar todos os adotantes cadastrados.
   Buscar um adotante pelo seu ID.
   Atualizar as informações de um adotante.
   Remover um adotante do sistema.

3. Gerenciamento de Adoções:
   Realizar o processo de adoção de um animal por um adotante.
   Listar todas as adoções realizadas.
   Listar os animais adotados por um determinado adotante.
   Cancelar uma adoção, tornando o animal disponível novamente (setStatus(true) para o animal).
   Regras para Adoção:
   Um adotante não pode adotar mais de 3 animais simultaneamente.
   Animais marcados como "Adotados" não podem ser adotados novamente sem cancelamento da adoção anterior.

# Entidades:
   ### Animais:
   - Nome
   - Espécie (Cachorro, Gato, etc.)
   - Raça
   - Idade
   - Status (Disponível(true), Adotado(false))
   ### Adotantes: 
   - Nome 
   - CPF 
   - Data de Nascimento 
   - Endereço
  - Contato (Telefone, E-mail)
   ### Adoções:
   -  Data da Adoção
   -  Data da Devolução (pode ser nula até a devolução)

## Instruções de Instalação:

1. Clonar o repositório:
   ```bash
   git clone https://github.com/LuccaErb/test.git
   ```
   
2. Instalar as dependências:

   build as dependências do projeto 

3. Configure as credenciais do banco de dados no arquivo `application.properties`.
```bash
spring.application.name=test
spring.datasource.url=jdbc:postgresql://localhost:porta/nomedoseubanco
spring.datasource.username=usernamedoseubanco
spring.datasource.password=senhadoseubanco
```

4. Execute a aplicação

5. Acessar o Swagger:`http://localhost:8080/swagger-ui.html`

### Rodar dockerizado: 

## Endpoints:
`http://localhost:8080 + endpoint` 
1. Animais:
   - `POST` /animals - Cria um novo animal para adotação.
   - `GET` /animals - Lista todos os animais disponíveis.
   - `GET` /animals/{id} - Busca um animal pelo seu ID.
   - `PUT` /animals/{id} - Atualiza as informações de um animal.
   - `DELETE` /animals/{id} - Remove um animal do sistema.
2. Adotantes:
   - `POST` /adopter - Cadastra um novo adotante.
   - `GET` /adopter - Lista todos os adotantes cadastrados.
   - `GET` /adopter/{id} - Busca um adotante pelo seu ID.
   - `PUT` /adopter/{id} - Atualiza as informações de um adotante.
   - `DELETE` /adopter/{id} - Remove um adotante do sistema.
3. Adoções:
   - `POST` /adoption?animalId={id}&adopterId={id} - Realiza o processo de adoção de um animal por um adotante.
   - `GET` /adoption - Lista todas as adoções realizadas.
   - `GET` /adoption/adopter/{id} - Lista os animais adotados por um determinado adotante.
   - `GET` /adoption/{id} - Busca uma adoção pelo seu ID.
   - `DELETE` /adoption/{id} - Cancela uma adoção, tornando o animal disponível novamente.
   
