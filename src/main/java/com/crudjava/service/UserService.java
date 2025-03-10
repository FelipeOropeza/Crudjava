package com.crudjava.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

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
            System.out.println("Insercao bem-sucedida! " + rowsAffected + " linha(s) afetada(s).");
            return true;
        } catch (SQLException e) {
            System.err.println("Erro ao inserir usuario: " + e.getMessage());
            return false;
        }
    }

    public List<User> getUsers() {
        String sql = "SELECT * FROM users";
        List<User> users = new ArrayList<>();

        try (Connection connection = databaseConnection.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                User user = new User(rs.getInt("id"), rs.getString("nome"), rs.getInt("idade"));
                users.add(user);
            }
        } catch (SQLException e) {
            System.err.println("Erro ao buscar usuarios: " + e.getMessage());
        }

        return users;
    }

    public boolean updateUser(User user) {
        String sql = "UPDATE users SET nome = ?, idade = ? WHERE id = ?";

        try (Connection connection = databaseConnection.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql)) {

            pstmt.setString(1, user.getNome());
            pstmt.setInt(2, user.getIdade());
            pstmt.setObject(3, user.getId(), Types.INTEGER);

            int rowsAffected = pstmt.executeUpdate();
            System.out.println("Atualização bem-sucedida! " + rowsAffected + " linha(s) afetada(s).");
            return true;
        } catch (SQLException e) {
            System.err.println("Erro ao atualizar usuario: " + e.getMessage());
            return false;
        }
    }

    public boolean deleteUser(User user) {
        String sql = "DELETE FROM users WHERE id = ?";

        try (Connection connection = databaseConnection.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql)) {

            pstmt.setObject(1, user.getId(), Types.INTEGER);

            int rowsAffected = pstmt.executeUpdate();

            if(rowsAffected == 0) {
                System.out.println("Nenhum usuario encontrado com o ID informado.");
                return false;
            }

            System.out.println("Exclusão bem-sucedida! " + rowsAffected + " linha(s) afetada(s).");
            return true;
        } catch (SQLException e) {
            System.err.println("Erro ao excluir usuário: " + e.getMessage());
            return false;
        }
    }
}
