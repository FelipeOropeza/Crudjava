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
        scanner.nextLine();  // Consumir o caractere de nova linha pendente
        return idade;
    }

    public int getOpcao() {
        System.out.print("Digite sua opção: ");
        int opcao = scanner.nextInt();
        scanner.nextLine();  // Consumir o caractere de nova linha pendente
        return opcao;
    }

    public void close() {
        scanner.close();
    }
}
