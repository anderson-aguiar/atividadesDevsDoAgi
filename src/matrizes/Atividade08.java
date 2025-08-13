package matrizes;

import java.util.Scanner;

public class Atividade08 {
    /*Controle de Limite de Crédito por Categoria
Uma matriz double[N][T] representa os valores gastos por N clientes em T tipos de compra (mercado, viagens, serviços etc.).
Normalize os valores para ficar entre 0 e 1, com base no maior gasto total individual.
Métodos a implementar:
double gastoMaximoCliente(double[][] gastos, int cliente) – retorna o maior gasto entre as categorias de um cliente.
double[][] normalizarGastos(double[][] gastos) – retorna uma nova matriz com os valores normalizados.
*/
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double[][] gastosClientes = {
                {1500.75, 2300.50, 1980.00, 1200.25},
                {300.00, 450.50, 500.00, 750.75},
                {2000.00, 2100.25, 2050.50, 1999.99},
                {0.00, 150.00, 300.00, 450.00}
        };
        System.out.print("Informe o numero do cliente: ");
        int cliente = sc.nextInt();
        while (cliente < 0 || cliente >= gastosClientes.length) {
            System.out.print("Cliente não encontrado! Informe um cliente válido: ");
            cliente = sc.nextInt();
        }
        System.out.println("Maior gasto: " + gastoMaximoCliente(gastosClientes, cliente));
        double[][] gastosNormalizados = normalizarGastos(gastosClientes);
        System.out.println("--- Gastos normalizados entre 0 e 1 ---");
        for (int i = 0; i < gastosNormalizados.length; i++) {
            for (int j = 0; j < gastosNormalizados[i].length; j++) {
                System.out.printf("%4s %.1f ", "", gastosNormalizados[i][j]);
            }
            System.out.println();
        }
        sc.close();
    }

    public static double gastoMaximoCliente(double[][] gastos, int cliente) {
        double maior = gastos[cliente][0];
        for (int i = 1; i < gastos.length; i++) {
            for (int j = 1; j < gastos[i].length; j++) {
                if (gastos[cliente][j] > maior) {
                    maior = gastos[cliente][j];
                }
            }
        }
        return maior;
    }

    public static double[][] normalizarGastos(double[][] gastos) {
        double[][] normalizados = new double[gastos.length][gastos[0].length];
        for (int i = 0; i < gastos.length; i++) {
            double max = gastoMaximoCliente(gastos, i);
            for (int j = 0; j < gastos[i].length; j++) {
                normalizados[i][j] = gastos[i][j] / max;
            }
        }
        return normalizados;
    }
}
