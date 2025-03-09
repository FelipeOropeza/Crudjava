package com.crudjava;

import java.util.List;

import com.crudjava.model.User;
import com.crudjava.service.UserService;
import com.crudjava.util.InputHelper;

public class Main {

    public static void main(String[] args) {
        InputHelper inputHelper = new InputHelper();
        UserService userService = new UserService();

        boolean loop = true;

        while (loop) {
            System.out.println("\nEscolha uma opcao:");
            System.out.println("1. Adicionar usuario");
            System.out.println("2. Listar usuarios");
            System.out.println("3. Deletar usuario");
            System.out.println("4. Atualizar usuario");
            System.out.println("5. Sair");

            int opcao = inputHelper.getOpcao();

            switch (opcao) {
                case 1 -> {
                    String nome = inputHelper.getNome();
                    int idade = inputHelper.getIdade();

                    User user = new User(nome, idade);

                    boolean success = userService.addUser(user);

                    if (success) {
                        System.out.println("Usuario inserido com sucesso!");
                    } else {
                        System.out.println("Falha ao inserir o usuario.");
                    }
                }

                case 2 -> {
                    List<User> users = userService.getUsers();

                    if (users.isEmpty()) {
                        System.out.println("Nenhum usuario encontrado.");
                    } else {
                        System.out.println("Lista de usuarios:");
                        for (User u : users) {
                            System.out.println("Id: " + u.getId() + ", Nome: " + u.getNome() + ", Idade: " + u.getIdade());
                        }
                    }
                }

                case 3 -> {
                    int id = inputHelper.getId();
                    User user = new User(id, null, 0);

                    boolean success = userService.deleteUser(user);

                    if (success) {
                        System.out.println("Usuario deletado com sucesso!");
                    } else {
                        System.out.println("Falha ao deletar o usuário.");
                    }
                }

                case 4 -> {
                    int id = inputHelper.getId();
                    String nome = inputHelper.getNome();
                    int idade = inputHelper.getIdade();

                    User user = new User(id, nome, idade);

                    boolean success = userService.updateUser(user);

                    if (success) {
                        System.out.println("Usuario atualizado com sucesso!");
                    } else {
                        System.out.println("Falha ao atualizar o usuario.");
                    }
                }

                case 5 -> {
                    loop = false;
                    System.out.println("Saindo...");
                }

                default -> System.out.println("Opção invalida.");
            }
        }

        inputHelper.close();
    }
}
