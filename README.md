# FATEC_aba_project_backend
Backend Projeto Aba do Grupo 1 da FATEC - Araras para a escola PIPA.
Este repositório contém uma aplicação desenvolvida em Java 21 utilizando Spring Boot 3.2.4. A aplicação está configurada para utilizar Docker Compose para iniciar o banco de dados e inclui documentação da API via Swagger. Também há um arquivo de configuração para o Insomnia.

## Pré-requisitos

Certifique-se de ter as seguintes ferramentas instaladas em seu ambiente de desenvolvimento:

- [Java 21](https://www.oracle.com/java/technologies/javase/jdk21-archive-downloads.html)
- [Maven](https://maven.apache.org/download.cgi)
- [Docker](https://www.docker.com/products/docker-desktop/)
- [Docker Compose](https://docs.docker.com/compose/install/)

## Como Rodar a Aplicação

### 1. Clonar o Repositório

```bash
git clone https://github.com/seu-usuario/nome-do-repositorio.git
cd nome-do-repositorio
```

### 2. Iniciar o Banco de Dados com Docker Compose
Dentro do diretório do projeto, execute o comando:

```bash
docker-compose up -d
```
Esse comando irá iniciar os containers definidos no arquivo compose.yaml, incluindo o banco de dados necessário para a aplicação.


### 3. Rodar a Aplicação
Você pode rodar a aplicação utilizando o Maven. Execute o seguinte comando:

```bash
./mvnw spring-boot:run
```
Alternativamente, você pode empacotar a aplicação e executar o jar gerado:

```bash
./mvnw clean package
java -jar target/nome-do-jar.jar
```


### 4. Acessar a Documentação da API (Swagger)
Após iniciar a aplicação, você pode acessar a documentação interativa da API fornecida pelo Swagger através do seguinte URL:

```bash
http://localhost:8080/swagger-ui/index.html#/
```

### 5. Configuração do Insomnia
O projeto inclui um arquivo de configuração para o Insomnia, uma ferramenta para teste de APIs. Para importar a configuração:
Abra o Insomnia.
Vá para Application > Preferences > Data > Import Data.
Selecione From File.
Escolha o arquivo aba-insomnia.json localizado no diretório raiz do projeto.
Isso irá importar todas as rotas configuradas para facilitar o teste das APIs.