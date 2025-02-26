package com.crudjava;

import com.crudjava.model.User;
import com.crudjava.service.UserService;
import com.crudjava.util.InputHelper;

public class Main {

    public static void main(String[] args) {
        InputHelper inputHelper = new InputHelper();
        UserService userService = new UserService();

        String nome = inputHelper.getNome();
        int idade = inputHelper.getIdade();

        User user = new User(nome, idade);

        boolean success = userService.addUser(user);

        inputHelper.close();

        if (success) {
            System.out.println("Usuário inserido com sucesso!");
        } else {
            System.out.println("Falha ao inserir o usuário.");
        }
    }
}
