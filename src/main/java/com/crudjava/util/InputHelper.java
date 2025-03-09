package com.crudjava.util;

import java.util.Scanner;

public class InputHelper {

    private final Scanner scanner;

    public InputHelper() {
        this.scanner = new Scanner(System.in);
    }

    public String getNome() {
        String nome;

        do {
            System.out.print("Digite o nome do usuario: ");
            nome = scanner.nextLine().trim();

            if (nome.isEmpty()) {
                System.out.println("O nome do usuario não pode estar vazio. Tente novamente.");
            }
        } while (nome.isEmpty());

        return nome;
    }

    public int getIdade() {
        int idade = 0;
        do {
            System.out.print("Digite a idade do usuario: ");
            idade = scanner.nextInt();

            if (idade <= 0) {
                System.out.println("A idade do usuario deve ser maior que zero. Tente novamente.");
            }
        } while (idade <= 0);

        return idade;
    }

    public int getId() {
        System.out.print("Digite o ID do usuario: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        return id;
    }

    public int getOpcao() {
        System.out.print("Digite sua opcao: ");
        int opcao = scanner.nextInt();
        scanner.nextLine();
        return opcao;
    }

    public void close() {
        scanner.close();
    }
}
