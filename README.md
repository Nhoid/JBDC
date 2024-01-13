
# Projeto JBDC (Java Database Connectivity)

## Descrição do Projeto

Este projeto é uma aplicação Java simples que realiza manipulações básicas em um banco de dados utilizando JDBC (Java Database Connectivity). O objetivo principal é fornecer funcionalidades comuns de CRUD (Create, Read, Update, Delete) em um contexto de manipulação de dados em um banco de dados relacional.

## Funcionalidades Principais

### Inserir Dados

Para inserir dados no banco de dados, utilize a classe `Usuarios`. Crie instâncias dessa classe com os dados necessários e utilize os métodos de inserção fornecidos.

Exemplo:

```java
Usuarios usuario = new Usuarios("Nome"); //Email do usuario é gerado automaticamente com o Nome@gmail.com
Services.inserir(usuario);
```

### Deletar Dados

A exclusão de dados pode ser feita utilizando nome, um único ID ou um intervalo de IDs. Utilize o método apagar para excluir um usuário com base no ID.

Exemplos:
Deletar um usuário pelo nome:
```java
Services.apagar("Nome"); //Cuidado, pode ter mais de um usuário com o mesmo nome
```
Deletar um usuário específico por ID:
```java
Services.apagar(ID);
```
Deletar usuários em um intervalo de ID's:
```java
Services.apagar(ID_inicial, ID_Fim);
```

### Pesquisar dados
A pesquisa de dados oferece várias opções:

Pesquisar todos os usuários:
```java
Services.procurator();
```

Pesquisar usuários por nome:
```java
Services.procurator("Nome");
```

Pesquisar usuário por ID:
```java
Services.procurator(ID);
```

Pesquisar usuários em um intervalo de IDs:
```java
Services.procurator(ID_inicio, ID_fim);
```

## Pré-requisitos

Antes de executar o projeto, certifique-se de ter as seguintes condições atendidas:

1. **Ambiente Java Configurado:** Tenha um ambiente Java configurado em seu sistema. Você pode baixar e instalar o [JDK (Java Development Kit)](https://www.oracle.com/java/technologies/javase-downloads.html).

2. **Banco de Dados JDBC:** Certifique-se de ter um banco de dados JDBC compatível disponível. Para isso, você precisará configurar as informações do banco de dados no arquivo `ConnectionJ` na pasta `Connection`. Altere as configurações como URL do banco de dados, usuário e senha para refletir as configurações do seu ambiente.

   Exemplo (em `Connection/ConnectionJ.java`):

   ```java
    public class ConnectionJ
    {
        public static Connection getConnection() throws SQLException {
            String url = "jdbc:mysql://localhost:3306";
            String username = "root";
            String password = "senha";
            return DriverManager.getConnection(url, username, password);
        }
    }
   }
## Contribuições
Contribuições são bem-vindas! Sinta-se à vontade para reportar problemas, fazer sugestões ou enviar pull requests.
