package com.crudjava;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import io.github.cdimascio.dotenv.Dotenv;

public class Main {

    public static void main(String[] args) {
        // Carrega o arquivo .env
        Dotenv dotenv = Dotenv.load();

        // Carregar as variáveis do arquivo .env
        String url = dotenv.get("DB_URL");
        String user = dotenv.get("DB_USER");   // Agora o usuário é lido do .env
        String password = dotenv.get("DB_PASSWORD");

        // Solicita os dados a serem inseridos
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o nome do usuário: ");
        String nome = scanner.nextLine();

        System.out.print("Digite a idade do usuário: ");
        int idade = scanner.nextInt(); // Lê a idade como inteiro

        // Tenta conectar ao banco e fazer a inserção
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            System.out.println("Conexão bem-sucedida!");

            // SQL de inserção
            String sql = "INSERT INTO users (nome, idade) VALUES (?, ?)";

            // Criando o PreparedStatement
            try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
                // Definindo os valores dos parâmetros da query
                pstmt.setString(1, nome); // Define o nome inserido pelo usuário
                pstmt.setInt(2, idade);   // Define a idade inserida pelo usuário

                // Executando a inserção
                int rowsAffected = pstmt.executeUpdate();
                System.out.println("Inserção bem-sucedida! " + rowsAffected + " linha(s) afetada(s).");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }
}
