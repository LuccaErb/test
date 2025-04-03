# Gerenciamento de Adoção de Animais

## Descrição da Aplicação

O sistema permite gerenciar o processo de adoção de animais, incluindo a administração de animais disponíveis, adotantes e adoções realizadas. 

### Funcionalidades:

#### 1. Gerenciamento de Animais
- Criar um novo animal para adoção.
- Listar todos os animais disponíveis.
- Buscar um animal pelo seu ID.
- Atualizar as informações de um animal.
- Remover um animal do sistema.
- Marcar um animal como "Adotado" (`setStatus(false)`) quando uma adoção for realizada.

#### 2. Gerenciamento de Adotantes
- Cadastrar um novo adotante.
- Listar todos os adotantes cadastrados.
- Buscar um adotante pelo seu ID.
- Atualizar as informações de um adotante.
- Remover um adotante do sistema.

#### 3. Gerenciamento de Adoções
- Realizar o processo de adoção de um animal por um adotante.
- Listar todas as adoções realizadas.
- Listar os animais adotados por um determinado adotante.
- Cancelar uma adoção, tornando o animal disponível novamente (`setStatus(true)`).

### Regras de Adoção:
- Um adotante não pode adotar mais de **três** animais simultaneamente.
- Animais marcados como "Adotados" não podem ser adotados novamente sem que a adoção anterior seja cancelada.

---

## Modelagem das Entidades

### 1. Animais
- **Nome**
- **Espécie** (Cachorro, Gato, etc.)
- **Raça**
- **Idade**
- **Status** (Disponível `true`, Adotado `false`)

### 2. Adotantes
- **Nome**
- **CPF**
- **Data de Nascimento**
- **Endereço**
- **Contato** (Telefone, E-mail)

### 3. Adoções
- **Data da Adoção**
- **Data da Devolução** (Pode ser nula até a devolução)

---

## Instruções de Instalação

1. **Clonar o repositório**
```bash
   git clone https://github.com/LuccaErb/test.git
```
   
2. **Instalar as dependências**
```bash
   mvn clean install  # Para projetos Maven
   
```

3. **Configurar as credenciais do banco de dados** no arquivo `application.properties`:
```properties
spring.application.name=test
spring.datasource.url=jdbc:postgresql://localhost:5432/nomedoseubanco
spring.datasource.username=usernamedoseubanco
spring.datasource.password=senhadoseubanco
```

4. **Executar a aplicação**
```bash
   mvn spring-boot:run  # Se estiver usando Maven
   # Ou
   java -jar target/nome-do-jar.jar  # Caso tenha gerado um .jar
```

5. **Acessar a documentação da API (Swagger):**
   - [Swagger UI](http://localhost:8080/swagger-ui.html)

---

## Execução com Docker

Para rodar o projeto em um ambiente dockerizado, utilize o seguinte comando:
```bash
   docker-compose up -d --build
```

---

## Endpoints da API

### 1. Gerenciamento de Animais
| Método  | Endpoint         | Descrição                                    |
|----------|-----------------|--------------------------------------------|
| `POST`   | /animals        | Cria um novo animal para adoção.            |
| `GET`    | /animals        | Lista todos os animais disponíveis.        |
| `GET`    | /animals/{id}   | Busca um animal pelo seu ID.               |
| `PUT`    | /animals/{id}   | Atualiza as informações de um animal.      |
| `DELETE` | /animals/{id}   | Remove um animal do sistema.               |

### 2. Gerenciamento de Adotantes
| Método  | Endpoint          | Descrição                                |
|----------|------------------|----------------------------------------|
| `POST`   | /adopter         | Cadastra um novo adotante.            |
| `GET`    | /adopter         | Lista todos os adotantes cadastrados. |
| `GET`    | /adopter/{id}    | Busca um adotante pelo seu ID.        |
| `PUT`    | /adopter/{id}    | Atualiza as informações de um adotante.|
| `DELETE` | /adopter/{id}    | Remove um adotante do sistema.        |

### 3. Gerenciamento de Adoções
| Método  | Endpoint                           | Descrição                                      |
|----------|----------------------------------|----------------------------------------------|
| `POST`   | /adoption?animalId={id}&adopterId={id} | Realiza a adoção de um animal.        |
| `GET`    | /adoption                        | Lista todas as adoções realizadas.         |
| `GET`    | /adoption/adopter/{id}           | Lista os animais adotados por um adotante.  |
| `GET`    | /adoption/{id}                    | Busca uma adoção pelo seu ID.              |
| `DELETE` | /adoption/{id}                    | Cancela uma adoção e torna o animal disponível. |

---

## Considerações Finais

Este sistema foi desenvolvido para facilitar o processo de adoção de animais, garantindo um gerenciamento eficiente e regrando o processo de adoção de forma clara. Qualquer contribuição ou sugestão é bem-vinda!

---

### Autor
Desenvolvido por **Lucca Erb**
