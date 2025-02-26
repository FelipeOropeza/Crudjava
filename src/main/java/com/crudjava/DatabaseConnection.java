package com.crudjava;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseConnection {

    public static void main(String[] args) {
        // Definindo os parâmetros de conexão com o banco
        String url = "jdbc:postgresql://localhost:5432/usuarios";
        String user = "postgres";
        String password = "kiraFE22";

        // Estabelecendo a conexão
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            System.out.println("Conexão bem-sucedida!");

            // SQL de inserção
            String sql = "INSERT INTO users (nome, idade) VALUES (?, ?)";

            // Criando o PreparedStatement
            try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
                // Definindo os valores dos parâmetros da query
                pstmt.setString(1, "Felipe");
                pstmt.setInt(2, 22);

                // Executando a inserção
                int rowsAffected = pstmt.executeUpdate();
                System.out.println("Inserção bem-sucedida! " + rowsAffected + " linha(s) afetada(s).");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}