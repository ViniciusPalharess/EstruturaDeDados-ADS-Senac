package Atividade_03;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Temática_03 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        System.out.println("Informe a quantidade de notas: ");
        int quantidade = lerInteiro(entrada);

        ArrayList<Double> notas = new ArrayList<>();

        for (int i = 1; i <= quantidade; i++) {
            System.out.println("Informe a nota " + i + ": ");
            notas.add(lerNota(entrada));
        }

        ordenarPorSelecao(notas);

        System.out.println("\nNotas em ordem crescente:");

        for (Double nota : notas) {
            System.out.println(nota);
        }

        entrada.close();
    }

    public static int lerInteiro(Scanner entrada) {
        int valor = -1;

        do {
            try {
                valor = entrada.nextInt();
            } catch (InputMismatchException e) {
                entrada.next();
                valor = -1;
            }

            if (valor <= 0) {
                System.out.println("Informe um número maior que zero.");
            }
        } while (valor <= 0);

        return valor;
    }

    public static double lerNota(Scanner entrada) {
        double nota = -1;

        do {
            try {
                nota = entrada.nextDouble();
            } catch (InputMismatchException e) {
                entrada.next();
                nota = -1;
            }

            if (nota < 0 || nota > 10) {
                System.out.println("Informe uma nota entre 0 e 10.");
            }
        } while (nota < 0 || nota > 10);

        return nota;
    }

    public static void ordenarPorSelecao(ArrayList<Double> notas) {
        for (int i = 0; i < notas.size() - 1; i++) {
            int menor = i;

            for (int j = i + 1; j < notas.size(); j++) {
                if (notas.get(j) < notas.get(menor)) {
                    menor = j;
                }
            }

            double auxiliar = notas.get(i);
            notas.set(i, notas.get(menor));
            notas.set(menor, auxiliar);
        }
    }
}