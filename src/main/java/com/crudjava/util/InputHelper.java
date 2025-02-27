package com.crudjava.util;

import java.util.Scanner;

public class InputHelper {

    private final Scanner scanner;

    public InputHelper() {
        this.scanner = new Scanner(System.in);
    }

    public String getNome() {
        System.out.print("Digite o nome do usuário: ");
        return scanner.nextLine();
    }

    public int getIdade() {
        System.out.print("Digite a idade do usuário: ");
        int idade = scanner.nextInt();
        scanner.nextLine();
        return idade;
    }

    public int getId() {
        System.out.print("Digite o ID do usuário: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        return id;
    }

    public int getOpcao() {
        System.out.print("Digite sua opção: ");
        int opcao = scanner.nextInt();
        scanner.nextLine();
        return opcao;
    }

    public void close() {
        scanner.close();
    }
}
