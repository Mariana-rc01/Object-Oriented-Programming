package main;

import java.util.Scanner;

public class TestePrograma {
    public static void main(String[] args) throws Exception {
        System.out.println("Insira o tamanho do array de inteiros: ");
        Scanner sc = new Scanner(System.in);

        int array_size = sc.nextInt();

        int[] array = new int[array_size];

        for (int i = 0; i < array_size; i++) {
            int el = sc.nextInt();
            array[i] = el;
        }
    }
}
