package com.treinamento.atividadejson;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/json")
public class JsonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    Person yourObject = (Person) request.getAttribute("yourObject");
	    String htmlResponse = "<html><body>"
	    + "<h1>Dados recebidos com sucesso!</h1>"
	    + "<p>Nome: " + yourObject.getNome() + "</p>"
	    + "<p>Email: " + yourObject.getEmail() + "</p>"
	    + "<p>Idade: " + yourObject.getIdade() + "</p>"
	    + "<p>Sexo: " + yourObject.getSexo() + "</p>"
	    + "</body></html>";
	    response.setContentType("text/html");
	    response.setCharacterEncoding("UTF-8");
	    response.getWriter().write(htmlResponse);
	 }
}
