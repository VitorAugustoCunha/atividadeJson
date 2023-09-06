package com.treinamento.atividadejson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;

import javax.json.Json;
import javax.json.JsonObject;

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
                    StringBuilder jsonBuffer = new StringBuilder();
                    String line;
                    while ((line = reader.readLine()) != null) {
                        jsonBuffer.append(line);
                    }
                    
                    String jsonData = jsonBuffer.toString();
                    
                    Person yourObject = parseJson(jsonData);

                    httpRequest.setAttribute("yourObject", yourObject);
                } catch (Exception e) {
                }
            }
        }
        
        String jsonResponse = "Post Recebido.";

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        try (PrintWriter out = response.getWriter()) {
            out.print(jsonResponse);
            out.flush();
        }
        chain.doFilter(request, response);
    }

    private Person parseJson(String jsonData) {
        return new Person();
    }
}
