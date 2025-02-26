package com.crudjava.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.crudjava.database.DatabaseConnection;
import com.crudjava.model.User;

public class UserService {

    private final DatabaseConnection databaseConnection;

    public UserService() {
        this.databaseConnection = new DatabaseConnection();
    }

    public boolean addUser(User user) {
        String sql = "INSERT INTO users (nome, idade) VALUES (?, ?)";

        try (Connection connection = databaseConnection.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql)) {

            pstmt.setString(1, user.getNome());
            pstmt.setInt(2, user.getIdade());

            int rowsAffected = pstmt.executeUpdate();
            System.out.println("Inserção bem-sucedida! " + rowsAffected + " linha(s) afetada(s).");
            return true;
        } catch (SQLException e) {
            System.err.println("Erro ao inserir usuário: " + e.getMessage());
            return false;
        }
    }
}
