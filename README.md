# Sistema de Estoque

Este é um projeto de sistema de estoque desenvolvido utilizando Spring Boot, Thymeleaf, PostgreSQL, e várias estruturas de dados avançadas, como árvore Splay e LinkedList. O sistema é capaz de armazenar produtos, organizar os itens mais acessados na raiz da árvore e utilizar o MergeSort para ordenar produtos pesquisados pelo nome.

## Estrutura do Projeto

- **Spring Boot**: Framework principal para desenvolvimento do backend.
- **Thymeleaf**: Motor de templates para renderização das páginas HTML.
- **PostgreSQL**: Banco de dados relacional utilizado para armazenamento persistente.
- **Árvore Splay**: Utilizada para armazenar produtos e otimizar o acesso aos itens mais frequentemente consultados.
- **LinkedList**: Utilizada para armazenar os itens pesquisados a partir da árvore Splay.
- **MergeSort**: Algoritmo de ordenação utilizado para organizar os produtos pesquisados pelo nome.

## Pré-requisitos

- **Java**: Versão 11 ou superior.
- **Maven**: Para gerenciamento de dependências.
- **PostgreSQL**: Banco de dados relacional.

## Configuração do Banco de Dados

Para que a aplicação funcione corretamente, é necessário criar manualmente um banco de dados chamado `inventory` no PostgreSQL. A aplicação irá criar as tabelas automaticamente, mas o banco de dados deve ser configurado previamente.

### Passos para criar o banco de dados:

1. Acesse o PostgreSQL com seu usuário e senha.
2. Crie o banco de dados com o seguinte comando:

   ```sql
   CREATE DATABASE inventory;
# Instalação e Execução

## Clone o repositório do projeto:

```sh
git clone https://github.com/EvertonFarias/Inventory.git
cd Inventory
```
## Configure as informações de conexão do PostgreSQL no arquivo `application.properties`:
```sh
spring.datasource.url=jdbc:postgresql://localhost:5432/inventory
spring.datasource.username=seu-usuario
spring.datasource.password=sua-senha
spring.jpa.hibernate.ddl-auto=update
```
## Compile e execute a aplicação:
```sh
mvn clean install
mvn spring-boot:run
```
## Acesse a aplicação no navegador:
```sh
http://localhost:8080
```

# Funcionalidades
- **Cadastro de Produtos:** Permite adicionar novos produtos ao sistema.
- **Cadastro de Categorias:** Permite adicionar novas categorias ao sistema.
- **Consulta de Produtos:** Pesquisa produtos armazenados na árvore Splay, podendo filtrar por categoria.
- **Ordenação de Produtos:** Ordena os produtos pesquisados pelo nome utilizando MergeSort.
- **Histórico de Pesquisas:** O itens mais acessados ficam proximos da raiz da árvore Splay.

# Estruturas de Dados Utilizadas:

- **Árvore Splay:** Uma árvore de busca binária autobalanceável que otimiza operações de acesso.
- **LinkedList:** Utilizada para armazenar os itens pesquisados da árvore Splay.
- **MergeSort:** Algoritmo de ordenação eficiente utilizado para ordenar produtos pelo nome.


# Licença
Este projeto está licenciado sob a licença MIT. Veja o arquivo LICENSE para mais detalhes.
