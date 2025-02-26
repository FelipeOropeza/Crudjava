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
        return scanner.nextInt();
    }

    public void close() {
        scanner.close();
    }
}
