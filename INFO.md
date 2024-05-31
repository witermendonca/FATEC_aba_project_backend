# Projeto ABA

## Home

listagem de todos os clientes cadastrados, busca por cliente e acesso
a detalhes de clientes listados.

- Endpoint: /clients
- Metodo HTTP: GET
- Contrato de requisição: N/A
- Contrato de resposta:

```json
[
  {
    "id": 1,
    "name": "João da Silva",
    "email": "joao@gmail.com"
  },
  {
    "id": 2,
    "name": "Davi Souza",
    "email": "davi@gmail.com"
  },
  {
    "id": 3,
    "name": "Ana Medeiros",
    "email": "ana@gmail.com"
  }
]
```

## Perfil do Cliente

Tela de perfil de clientes – informações gerais do cliente, lista de responsáveis, lista
de protocolos cadastrados, acesso edição de informações do cliente, acesso
edição de responsáveis do cliente, cadastro de novo protocolo e acesso a
protocolos listados.

### Detalhes do Cliente

- Endpoint: /clients/{id: number}
- Metodo HTTP: GET
- Contrato de requisição: N/A
- Contrato de resposta:

```json
{
  "id": 1,
  "name": "João da Silva",
  "birthday": "2000-10-19",
  "cpf": "24231922071",
  "telephone": "19999299928",
  "email": "joao@gmail.com",
  "educationLevel": "Fundamental",
  "medicalInformations": "",
  "medicinesInUse": "",
  "processingInformation": "",
  "createdAt": "2024-05-31T18:20:00.618",
  "updatedAt": null,
  "createdBy": "Witer Mendonça",
  "updatedBy": null,
  "gender": "MASCULINO",
  "address": {
    "cep": "13606336",
    "street": "Av Augusta Viola",
    "addressNumber": 23,
    "complement": "Bloco 3, Ap 300",
    "neighborhood": "Jd Celina",
    "city": "Araras",
    "state": "SP"
  },
  "responsible": [
    {
      "id": 1,
      "name": "Jose Pai",
      "cpf": "20671913069",
      "email": "pai@gmail.com",
      "degreeOfKinship": "Pai",
      "telephone": "199119911919",
      "createdAt": "2024-05-31T18:20:00.619304",
      "updatedAt": null
    }
  ],
  "protocols": [
    {
      "id": 1,
      "name": "Sentar",
      "createdAt": "2024-05-31T18:34:00.00379",
      "createdBy": "Witer Mendonça"
    },
    {
      "id": 2,
      "name": "Levantar",
      "createdAt": "2024-05-31T18:34:26.127162",
      "createdBy": "Witer Mendonça"
    }
  ]
}
```

### Cadastro Novo Protocolo do Cliente

- Endpoint: /protocol
- Metodo HTTP: POST
- Contrato de requisição:

```json
{
  "name": "string",
  "createdBy": "string",
  "idClient": 0
}
```

Contrato de resposta:
HTTP response code 201 e header location.

## Protocolos do Cliente

Tela de protocolo do cliente – informações do protocolo, listagem de aplicações do
protocolo, realizar nova aplicação do protocolo, acessar informações das aplicações do
protocolo.

### Detalhes do Protocolo

- Endpoint: /protocol/{id: number}
- Metodo HTTP: GET
- Contrato de requisição: N/A
- Contrato de resposta:

```json
{
  "id": 1,
  "name": "Sentar",
  "createdAt": "2024-05-31T18:34:00.00379",
  "createdBy": "Witer Mendonça",
  "applications": [
    {
      "id": 1,
      "positivePercentage": 50.0,
      "success": 5,
      "failure": 5,
      "createdBy": "Witer Mendonça",
      "createdAt": "2024-05-31T18:44:51.916627",
      "aborted": false,
      "reasonAbortion": null
    },
    {
      "id": 2,
      "positivePercentage": 50.0,
      "success": 5,
      "failure": 5,
      "createdBy": "Witer Mendonça",
      "createdAt": "2024-05-31T19:48:29.019377",
      "aborted": false,
      "reasonAbortion": null
    }
  ]
}
```

### Nova Aplicação do Protocolo

Cadastro de aplicação do protocolo

- Endpoint: /application
- Metodo HTTP: POST
- Contrato de requisição:

```json
{
  "positivePercentage": 50,
  "success": 5,
  "failure": 5,
  "aborted": false,
  "reasonAbortion": null,
  "attempts": [
    {
      "attemptNumber": 1,
      "help": null,
      "comments": null,
      "result": true
    },
    {
      "attemptNumber": 2,
      "help": null,
      "comments": null,
      "result": true
    },
    {
      "attemptNumber": 3,
      "help": null,
      "comments": null,
      "result": true
    },
    {
      "attemptNumber": 4,
      "help": null,
      "comments": null,
      "result": true
    },
    {
      "attemptNumber": 5,
      "help": null,
      "comments": null,
      "result": true
    },
    {
      "attemptNumber": 6,
      "help": null,
      "comments": null,
      "result": false
    },
    {
      "attemptNumber": 7,
      "help": null,
      "comments": null,
      "result": false
    },
    {
      "attemptNumber": 8,
      "help": null,
      "comments": null,
      "result": false
    },
    {
      "attemptNumber": 9,
      "help": null,
      "comments": null,
      "result": false
    },
    {
      "attemptNumber": 10,
      "help": null,
      "comments": null,
      "result": false
    }
  ],
  "createdBy": "Witer Mendonça",
  "protocolId": 1
}
```

Observação: A aplicação do procolo precisa ter 10 tentativas no máximo e em caso de menos
tentativas precisa ser marcada como abortada.

- Contrato de resposta:
  HTTP response code 201 e header location.

## Aplicação do protocolo

Tela de detalhes da aplicação do protocolo – detalhes da aplicação do protocolo,
informações de porcentagem de sucesso, porcentagem de falha, observações das
tentativas, tipo da ajuda das tentativas, razão de aborto da tentativa se houver.

### Detalhes da aplicação

- Endpoint: /application/{id: number}
- Metodo HTTP: GET
- Contrato de requisição: N/A
- Contrato de resposta:

```json
{
  "id": 1,
  "positivePercentage": 50,
  "success": 5,
  "failure": 5,
  "createdBy": "Witer Mendonça",
  "createdAt": "2024-05-31T18:44:51.916627",
  "aborted": false,
  "reasonAbortion": null,
  "attempts": [
    {
      "id": 1,
      "attemptNumber": 1,
      "help": null,
      "comments": null,
      "result": true
    },
    {
      "id": 2,
      "attemptNumber": 2,
      "help": null,
      "comments": null,
      "result": true
    },
    {
      "id": 3,
      "attemptNumber": 3,
      "help": null,
      "comments": null,
      "result": true
    },
    {
      "id": 4,
      "attemptNumber": 4,
      "help": null,
      "comments": null,
      "result": true
    },
    {
      "id": 5,
      "attemptNumber": 5,
      "help": null,
      "comments": null,
      "result": true
    },
    {
      "id": 6,
      "attemptNumber": 6,
      "help": null,
      "comments": null,
      "result": false
    },
    {
      "id": 7,
      "attemptNumber": 7,
      "help": null,
      "comments": null,
      "result": false
    },
    {
      "id": 8,
      "attemptNumber": 8,
      "help": null,
      "comments": null,
      "result": false
    },
    {
      "id": 9,
      "attemptNumber": 9,
      "help": null,
      "comments": null,
      "result": false
    },
    {
      "id": 10,
      "attemptNumber": 10,
      "help": null,
      "comments": null,
      "result": false
    }
  ]
}
```
