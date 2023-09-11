# Aplicativo Web Java para Processar Solicitações JSON

Este é um projeto de exemplo que demonstra como criar um aplicativo da web Java para lidar com solicitações JSON usando Servlets. O aplicativo é capaz de receber solicitações HTTP POST contendo dados JSON, analisar esses dados e criar objetos Java a partir deles.

## Como Funciona

1. O filtro `JsonProcessingFilter` verifica as solicitações para a URL "/json" e verifica se são solicitações HTTP POST.

2. Ele lê o JSON da solicitação, analisa-o e cria um objeto `Person` a partir dos dados JSON.

3. O objeto `Person` é definido como um atributo da solicitação para uso posterior.

4. A resposta é configurada para enviar uma mensagem HTML de sucesso.

5. O Servlet `JsonServlet` lida com solicitações HTTP GET e POST para a URL "/json" e pode ser estendido para implementar a lógica apropriada para as solicitações POST.

## Como Usar

1. Clone este repositório.

2. Implemente a lógica necessária no método `doPost` do `JsonServlet` para processar solicitações POST.

3. Implante o aplicativo em um servidor da web compatível com Servlets, como o Apache Tomcat.

4. Envie solicitações POST ou PUT para a URL "/json" contendo dados JSON válidos no formato especificado.

5. O aplicativo processará as solicitações, analisará os dados JSON e responderá com uma mensagem de sucesso.

Isso é apenas uma demonstração simples e pode ser estendido e adaptado para atender às suas necessidades específicas.
