package matrizes;

import java.util.Scanner;

public class Atividade09 {
    /*Classificação de Risco de Crédito
Uma matriz int[C][Q] armazena as notas de crédito (0 a 100) de C clientes,
avaliadas por Q critérios (renda, histórico, uso de limite etc.).
Métodos a implementar:
double mediaNotaCliente(int[][] notas, int cliente) – retorna a média das notas de um cliente.
int[] clientesComRiscoBaixo(int[][] notas, double limiar) – retorna os índices dos clientes com média acima do limiar.*/
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] notas = {
                {85, 70, 92, 60},
                {76, 88, 54, 73},
                {90, 95, 89, 84},
                {62, 55, 77, 68},
                {80, 91, 66, 79}
        };
        System.out.print("Informe o numero do cliente: ");
        int cliente = sc.nextInt();
        while (cliente < 0 || cliente >= notas.length) {
            System.out.print("Cliente não encontrado! Informe um cliente válido: ");
            cliente = sc.nextInt();
        }
        System.out.println("A média da nota de crédito: " + mediaNotaCliente(notas, cliente));
        int[] aprovados = clientesComRiscoBaixo(notas, 70);
        System.out.println("--- Indices Aprovados ---");
        for (int v : aprovados) {
            System.out.println(" " + v);
        }

        sc.close();
    }

    public static double mediaNotaCliente(int[][] notas, int cliente) {
        double soma = 0;
        for (int i = 0; i < notas[cliente].length; i++) {
            soma += notas[cliente][i];
        }
        return soma / notas[cliente].length;
    }

    public static int[] clientesComRiscoBaixo(int[][] notas, double limiar) {
        int cont = 0;
        for (int i = 0; i < notas.length; i++) {
            if (mediaNotaCliente(notas, i) > limiar) {
                cont++;
            }
        }
        int[] notasAcimaLimiar = new int[cont];
        int pos = 0;
        for (int i = 0; i < notas.length; i++) {
            if (mediaNotaCliente(notas, i) > limiar) {
                notasAcimaLimiar[pos] = i;
                pos++;
            }
        }
        return notasAcimaLimiar;
    }
}