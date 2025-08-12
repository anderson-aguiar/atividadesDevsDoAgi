package matrizes;

import java.util.Arrays;
import java.util.Scanner;

public class Atividade01 {
    /*1. Análise de Saldos em Contas Correntes
Um banco monitora os saldos diários de N clientes durante M dias em uma matriz double[N][M].
Crie um programa que permita:
Métodos a implementar:
double saldoFinal(double[][] saldos, int cliente) – retorna o saldo do cliente ao final do período.
double[] saldoFinalTodos(double[][] saldos) – retorna o saldo final de todos os clientes.
void imprimirExtratoClientes(double[][] saldos) – exibe todos os saldos por cliente em formato tabular.
*/
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double[][] saldosClientes = {
                {1500.75, 2300.50, 1980.00, 1200.25},
                {300.00, 450.50, 500.00, 750.75},
                {2000.00, 2100.25, 2050.50, 1999.99},
                {0.00, 150.00, 300.00, 450.00}
        };
        System.out.print("Informe o numero do cliente: ");
        int cliente = sc.nextInt();
        while (cliente < 0 || cliente >= saldosClientes.length) {
            System.out.print("Cliente não encontrado! Informe um cliente válido: ");
            cliente = sc.nextInt();
        }
        System.out.printf("O saldo do cliente %d é R$%.2f \n\n", cliente, saldoFinal(saldosClientes, cliente));
        double[] somaTodos = saldoFinalTodos(saldosClientes);
        int cont = 1;
        for (double v : somaTodos) {
            System.out.printf("Soma do cliente %d°: R$%.2f\n", cont, v);
            cont++;
        }
        System.out.println("--- Saldos de forma tabular ---\n");
        imprimirExtratoClientes(saldosClientes);
    }

    public static double saldoFinal(double[][] saldos, int cliente) {
        double soma = 0;
        for (int i = 0; i < saldos.length; i++) {
            soma += saldos[cliente][i];
        }
        return soma;
    }

    public static double[] saldoFinalTodos(double[][] saldos) {

        double[] somaTodos = new double[saldos.length];
        for (int i = 0; i < saldos.length; i++) {
            double soma = 0;
            for (int j = 0; j < saldos[i].length; j++) {
                soma += saldos[i][j];
            }
            somaTodos[i] = soma;
        }
        return somaTodos;
    }

    public static void imprimirExtratoClientes(double[][] saldos) {
        for (int i = 0; i < saldos.length; i++) {
            System.out.print("Cliente " + (i + 1) + "°: ");
            for (int j = 0; j < saldos[i].length; j++) {
                System.out.printf("R$ %.2f ", saldos[i][j]);
            }
            System.out.println();
        }
    }

}
