package com.treinamento.atividadejson;

import com.treinamento.atividadejson.models.PersonModel;

import configs.DatabaseManager;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet("/json")
public class JsonServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    public void init() throws ServletException {
    	DatabaseManager.initialize();
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Person yourObject = (Person) request.getAttribute("yourObject");
        PersonModel personModel = new PersonModel();
        personModel.setNome(yourObject.getNome());
        personModel.setEmail(yourObject.getEmail());
        personModel.setIdade(yourObject.getIdade());
        personModel.setSexo(yourObject.getSexo());

        Connection connection = DatabaseManager.getConnection();

        try {
            savePerson(connection, personModel);
            String htmlResponse = "<html><body>" + "<h1>Dados recebidos com sucesso!</h1>" + "<p>Nome: "
            + yourObject.getNome() + "</p>" + "<p>Email: " + yourObject.getEmail() + "</p>" + "<p>Idade: "
            + yourObject.getIdade() + "</p>" + "<p>Sexo: " + yourObject.getSexo() + "</p>"
            + "</body></html>";
            response.setContentType("text/html");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(htmlResponse);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void savePerson(Connection connection, PersonModel personModel) throws SQLException {

        String sql = "INSERT INTO Person (nome, email, idade, sexo) VALUES (?, ?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, personModel.getNome());
            statement.setString(2, personModel.getEmail());
            statement.setInt(3, personModel.getIdade());
            statement.setString(4, personModel.getSexo());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
