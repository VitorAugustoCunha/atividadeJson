package com.treinamento.atividadejson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.stream.Collectors;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;

@WebFilter("/json")
public class JsonProcessingFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        if (request instanceof HttpServletRequest) {
            HttpServletRequest httpRequest = (HttpServletRequest) request;
            if ("POST".equalsIgnoreCase(httpRequest.getMethod()) || "PUT".equalsIgnoreCase(httpRequest.getMethod())) {
                try {
                	BufferedReader reader = httpRequest.getReader();
                	String jsonData = reader.lines().collect(Collectors.joining());

                    String nome = getValueFromJson(jsonData, "nome");
                    String email = getValueFromJson(jsonData, "email");
                    int idade = Integer.parseInt(getValueFromJson(jsonData, "idade"));
                    String sexo = getValueFromJson(jsonData, "sexo");
                    System.out.println(jsonData);
                    Person yourObject = new Person(nome, email, idade, sexo);

                    httpRequest.setAttribute("yourObject", yourObject);

                    response.setContentType("application/json");
                    response.setCharacterEncoding("UTF-8");

                    try (PrintWriter out = response.getWriter()) {
                        out.println("<html><body>");
                        out.println("<h1>Dados recebidos com sucesso!</h1>");
                        out.println("<p>Nome: " + nome + "</p>");
                        out.println("<p>Email: " + email + "</p>");
                        out.println("<p>Idade: " + idade + "</p>");
                        out.println("<p>Sexo: " + sexo + "</p>");
                        out.println("</body></html>");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        chain.doFilter(request, response);
    }

    private String getValueFromJson(String jsonData, String key) {
        int startIndex = jsonData.indexOf("\"" + key + "\"");
        if (startIndex >= 0) {
            startIndex = jsonData.indexOf(":", startIndex) + 1; 
            int endIndex = jsonData.indexOf(",", startIndex); 
            if (endIndex == -1) {
                endIndex = jsonData.length();
            }
            String value = jsonData.substring(startIndex, endIndex).trim();
            if (value.startsWith("\"") && value.endsWith("\"")) {
                value = value.substring(1, value.length() - 1);
            }
            return value;
        }
        return null;
    }

}
