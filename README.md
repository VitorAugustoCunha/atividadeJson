# Aplicativo Web Java para Processar Solicitações JSON com Banco de Dados H2

Este é um projeto de exemplo que demonstra como criar um aplicativo web Java para lidar com solicitações JSON usando Servlets e integrar um banco de dados H2. O aplicativo é capaz de receber solicitações HTTP POST contendo dados JSON, analisar esses dados, criar objetos Java a partir deles e armazenar esses objetos no banco de dados H2.

## Como Funciona

1. O filtro `JsonProcessingFilter` verifica as solicitações para a URL "/json" e verifica se são solicitações HTTP POST.

2. Ele lê o JSON da solicitação, analisa-o e cria um objeto `Person` a partir dos dados JSON.

3. O objeto `Person` é definido como um atributo da solicitação para uso posterior.

4. A resposta é configurada para enviar uma mensagem HTML de sucesso.

5. O Servlet `JsonServlet` lida com solicitações HTTP GET e POST para a URL "/json" e pode ser estendido para implementar a lógica apropriada para as solicitações POST.

6. A classe `DatabaseManager` foi adicionada para configurar e gerenciar a conexão com o banco de dados H2. O banco de dados é inicializado durante a inicialização do aplicativo.

## Configuração do Banco de Dados H2

Para configurar o banco de dados H2 e criar a tabela "Person", siga estas etapas:

1. Certifique-se de que o H2 Database esteja instalado em seu sistema.

2. Acesse o console de administração do H2 em [http://localhost:8082](http://localhost:8082) (o endereço padrão).

3. Preencha os campos com as seguintes informações:
   - **Driver Class**: `org.h2.Driver`
   - **JDBC URL**: `jdbc:h2:~/test`
   - **User Name**: `sa`
   - **Password**: `1234` (ou sua senha personalizada, se você a configurou diferente no código).

4. Após entrar no console de administração, conecte-se ao banco de dados usando as informações acima.

5. Execute a seguinte instrução SQL para criar a tabela "Person" no banco de dados:

```sql
CREATE TABLE Person (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    idade INT NOT NULL,
    sexo VARCHAR(255) NOT NULL
);
```

##Instalar H2 no projeto

1. **Baixe o JAR do H2 Database**:
   - Acesse o [site oficial do H2 Database](https://www.h2database.com/html/main.html).
   - Na seção "H2 Database Engine", clique no link "Download".
   - Selecione a versão mais recente e faça o download do arquivo `h2-*.jar` (onde `*` representa a versão).

2. **Crie uma pasta para as bibliotecas (libs)**:
   - Dentro do diretório do seu projeto Java, crie uma pasta chamada "libs" (ou qualquer outro nome que você preferir) para armazenar as bibliotecas JAR externas.

3. **Mova o JAR do H2 para a pasta "libs"**:
   - Mova o arquivo JAR do H2 que você baixou na etapa 1 para a pasta "libs" criada na etapa 2.

4. **Adicione o JAR do H2 ao Classpath do Projeto**:
   - Abra seu ambiente de desenvolvimento (por exemplo, Eclipse, IntelliJ IDEA, NetBeans) e abra o projeto Java em que você deseja adicionar o H2.
   - Configure o projeto para incluir o JAR do H2 em seu classpath. Isso pode variar dependendo do IDE que você está usando:
     - **Eclipse**:
       - Clique com o botão direito do mouse no projeto no "Explorador de Pacotes" (Package Explorer).
       - Escolha "Propriedades" (Properties).
       - No menu à esquerda, selecione "Java Build Path".
       - Na guia "Libraries", clique em "Add JARs..." e selecione o JAR do H2 na pasta "libs".
       - Clique em "Apply and Close" para salvar as alterações.
     - **IntelliJ IDEA**:
       - Clique com o botão direito do mouse no projeto no painel de navegação.
       - Escolha "Open Module Settings".
       - Na guia "Libraries", clique em "+" e escolha "Java".
       - Selecione o JAR do H2 na pasta "libs" e clique em "OK".
     - **NetBeans**:
       - Clique com o botão direito do mouse no projeto na janela "Projetos".
       - Escolha "Propriedades".
       - No menu à esquerda, selecione "Bibliotecas".
       - Clique em "Adicionar JAR/Pasta" e selecione o JAR do H2 na pasta "libs".

5. **Salve as Alterações e Reconstrua o Projeto**:
   - Após adicionar o JAR do H2 ao classpath, salve as alterações em seu IDE e reconstrua o projeto (geralmente, o IDE faz isso automaticamente).

Agora, você deve ter o banco de dados H2 configurado no seu projeto Java e pronto para uso. Certifique-se de que a pasta "libs" e o JAR do H2 estejam incluídos em seu repositório de código-fonte para que outras pessoas que trabalham no projeto também possam acessar as bibliotecas necessárias.


## Como Usar

1. Clone este repositório.

2. Implemente a lógica necessária no método `doPost` do `JsonServlet` para processar solicitações POST.

3. Implante o aplicativo em um servidor da web compatível com Servlets, como o Apache Tomcat.

4. Envie solicitações POST para a URL "/json" contendo dados JSON válidos no formato especificado. Por exemplo:

```json
{
    "nome": "Vitor",
    "email": "Vitor@gmail.com",
    "idade": 19,
    "sexo": "Masculino"
}
```

5. O aplicativo processará as solicitações, analisará os dados JSON e os armazenará na tabela "Person" do banco de dados H2.

Este é um exemplo básico e pode ser estendido e adaptado para atender às suas necessidades específicas de aplicação web com banco de dados H2 e manipulação de solicitações JSON.

## Contribuição

Sinta-se à vontade para contribuir com melhorias ou correções para este projeto. Abra um problema ou envie um pull request.

## Licença

Este projeto é distribuído sob a [licença MIT](LICENSE). Consulte o arquivo [LICENSE](LICENSE) para obter detalhes.
