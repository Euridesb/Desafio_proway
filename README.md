# Desafio Proway
 
## Como rodar
O banco de dados deve ser instalado, foi usado o MySQL. Para configurar o acesso ao banco, favor editar o arquivo
  src/main/resources/application.properties
* endereço no campo: spring.datasource.url
* Login: spring.datasource.username
* Password: spring.datasource.password
Instalar Maven vai na rais do projeto `mvn spring-boot:run`


## Modelo BD
  Sistema tem 03 Tabelas
### Conta
Id - Chave Primária
Intituição_Financeira - Vachar
Saldo - Decimal
Tipo - varchar

### Despesa
Id - Chave Primária
data_pagamento - date
data_pagamento_esperado - date
tipo_despesa - varchar
valor - decimal
Conta_id - Foreign Keys

### Receita
Id - Chave primária
data_recebimento - date
data_recebimento_esperado - date
descricao - varchar
tipo_receita - varchar
valor - decimal
conta_id - Foreign Keys

## MVC
O projeto usa o padrao MVC. 
A camada View nao foi implementada pois é uma API rest.
O controller pode ser observado no modulo controller.
Os serviços foram separados em um módulo próprio, e a persistencia no banco de dados é feita
pelos repositorios. Os modelos também foram separados em um módulo exclusivo.

## Observações
* Os valores monetarios foram implementados com duas casas decimais para facilitar.
* As datas no sistemas devem ser no formato "aaaa-mm-dd", por exemplo "2022-01-03" seria 3 de Janeiro de 2022.



## TODO
* [x] Foreign Keys
* [x] Datas
* [x] Enums
* [x] Funções de conta ( listar saldo total)
* [ ] Função de conta - transferir
* [x] Funções Receita ( filtro - tipo, total )
* [x] Funções Despesa ( filtro - tipo, total )
* [x] Readme
* [ ] Testes Unitarios
* [ ] Despesa filtro(Data inicial - data Final)
* [ ] Receita filtro(Data inicial - data Final)
