package matrizes;

import java.util.Scanner;

public class Atividade02 {
    /*Controle de Pagamentos de Empréstimos
Uma matriz double[C][P] armazena os valores pagos por C clientes ao longo de P parcelas de seus empréstimos.
Métodos a implementar:
double totalPago(double[][] pagamentos, int cliente) – retorna o valor total pago por um cliente.
double[] totalPagoTodos(double[][] pagamentos) – retorna um vetor com o total pago por cada cliente.
int clienteMaisAdiantado(double[][] pagamentos) – retorna o índice do cliente com maior soma de pagamentos.
*/
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double[][] valoresPagos = {
                {1500.75, 2300.50, 1980.00, 1200.25},
                {300.00, 450.50, 500.00, 750.75},
                {2000.00, 2100.25, 2050.50, 1999.99},
                {0.00, 150.00, 300.00, 450.00}
        };
        System.out.print("Informe o numero do cliente: ");
        int cliente = sc.nextInt();
        while (cliente < 0 || cliente >= valoresPagos.length) {
            System.out.print("Cliente não encontrado! Informe um cliente válido: ");
            cliente = sc.nextInt();
        }
        System.out.printf("O saldo do cliente %d é R$%.2f\n\n", cliente, totalPago(valoresPagos, cliente));
        double[] somaTodos = totalPagoTodos(valoresPagos);
        int cont = 1;
        for (double v : somaTodos) {
            System.out.printf("Cliente %d° já pagou: R$%.2f\n", cont, v);
            cont++;
        }
        int indice = clienteMaisAdiantado(valoresPagos);
        System.out.printf("\nO cliente %d pagou o maior valor - com total de R$%.2f", indice+1, somaTodos[indice]);

    }
    public static double totalPago(double[][] pagamentos, int cliente){
        double soma = 0;
        for (int i = 0; i < pagamentos.length; i++) {
            soma += pagamentos[cliente][i];
        }
        return soma;
    }
    public static double[] totalPagoTodos(double[][] pagamentos) {

        double[] somaTodos = new double[pagamentos.length];
        for (int i = 0; i < pagamentos.length; i++) {
            double soma = 0;
            for (int j = 0; j < pagamentos[i].length; j++) {
                soma += pagamentos[i][j];
            }
            somaTodos[i] = soma;
        }
        return somaTodos;
    }
    public static int clienteMaisAdiantado(double[][] pagamentos){
        double[] somaTotal = totalPagoTodos(pagamentos);
        double maior = somaTotal[0];
        int indice = 0;
        for (int i = 0; i < somaTotal.length ; i++) {
            if(somaTotal[i] > maior){
                maior = somaTotal[i];
                indice = i;
            }
        }
        return indice;
    }
}
