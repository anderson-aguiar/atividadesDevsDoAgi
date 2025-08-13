package matrizes;

import java.util.Scanner;

public class Atividade07 {
    /*Monitoramento de Cartões de Crédito
Uma matriz double[C][M] registra os gastos de C clientes com cartões de crédito durante M meses.
Métodos a implementar:
double gastoTotalCliente(double[][] gastos, int cliente) – retorna o gasto total de um cliente.
int clienteMaiorGasto(double[][] gastos) – retorna o índice do cliente com maior gasto acumulado.
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
        double gasto = gastoTotalCliente(gastosClientes, cliente);
        System.out.printf("O gasto do cliente informado: R$%.2f", gasto);
        int indiceMaiorGasto = clienteMaiorGasto(gastosClientes);
        System.out.printf("\nO cliente %d teve o maior gasto.", indiceMaiorGasto);
        sc.close();
    }

    public static double gastoTotalCliente(double[][] gastos, int cliente) {
        double gasto = 0;
        for (int i = 0; i < gastos.length; i++) {
            gasto += gastos[cliente][i];
        }
        return gasto;
    }

    public static int clienteMaiorGasto(double[][] gastos) {
        int indice = 0;
        double maior = 0;
        for (int i = 0; i < gastos.length; i++) {
            double totalGasto = gastoTotalCliente(gastos, i);
            if (totalGasto > maior) {
                maior = totalGasto;
                indice = i;
            }
        }
        return indice;
    }
}
