package com.crudjava;

import java.util.List;

import com.crudjava.model.User;
import com.crudjava.service.UserService;
import com.crudjava.util.InputHelper;

public class Main {

    public static void main(String[] args) {
        InputHelper inputHelper = new InputHelper();
        UserService userService = new UserService();

        System.out.println("Escolha uma opção:");
        System.out.println("1. Adicionar usuário");
        System.out.println("2. Listar usuários");
        System.out.println("3. Deletar usuário");

        int opcao = inputHelper.getOpcao();

        switch(opcao) {
            case 1 -> {
                String nome = inputHelper.getNome();
                int idade = inputHelper.getIdade();

                User user = new User(nome, idade);

                boolean success = userService.addUser(user);

                if (success) {
                    System.out.println("Usuário inserido com sucesso!");
                } else {
                    System.out.println("Falha ao inserir o usuário.");
                }
            }

            case 2 -> {
                List<User> users = userService.getUsers();

                if (users.isEmpty()) {
                    System.out.println("Nenhum usuário encontrado.");
                } else {
                    System.out.println("Lista de usuários:");
                    for (User u : users) {
                        System.out.println("Nome: " + u.getNome() + ", Idade: " + u.getIdade());
                    }
                }
            }

            case 3 -> {
                int id = inputHelper.getId();
                User user = new User(id, null, 0);

                boolean success = userService.deleteUser(user);

                if (success) {
                    System.out.println("Usuário deletado com sucesso!");
                } else {
                    System.out.println("Falha ao deletar o usuário.");
                }
            }

            default -> System.out.println("Opção inválida.");
        }

        inputHelper.close();
    }
}
