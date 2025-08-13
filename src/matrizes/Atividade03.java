package matrizes;

import java.util.Scanner;

public class Atividade03 {
    /* Avaliação de Investimentos Mensais
Cada linha da matriz double[F][M] representa a evolução mensal da cota de um fundo de investimento ao longo de M meses.
Métodos a implementar:
double rentabilidade(double[][] fundos, int fundo) – retorna a variação percentual do fundo entre o 1º e o último mês.
int fundoMaisRentavel(double[][] fundos) – retorna o índice do fundo com maior rentabilidade.
*/
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double[][] cotasFundos = {
                {10.50, 10.75, 11.00, 11.20},
                {8.30, 8.45, 8.60, 8.80},
                {15.00, 15.20, 15.50, 15.70}
        };
        System.out.print("Informe o numero do fundo: ");
        int fundo = sc.nextInt();
        while (fundo < 0 || fundo >= cotasFundos.length) {
            System.out.print("Fundo não encontrado! Informe um fundo válido: ");
            fundo = sc.nextInt();
        }
        System.out.printf("A rentabilidade do fundo foi %.2f%%", rentabilidade(cotasFundos, fundo));
        System.out.printf("\nO fundo mais rentável foi o %dº.", fundoMaisRentavel(cotasFundos)+1);
        sc.close();
    }

    public static double rentabilidade(double[][] fundos, int fundo) {
        double valorFinal = fundos[fundo][fundos[fundo].length - 1];
        double valorinicial = fundos[fundo][0];
        return ((valorFinal - valorinicial) / valorinicial) * 100;

    }
    public static int fundoMaisRentavel(double[][] fundos){
        int indice = 0;
        double maior = rentabilidade(fundos, 0);
        for (int i = 1; i < fundos.length ; i++) {
                if(rentabilidade(fundos, i) > maior){
                    maior = rentabilidade(fundos, i);
                    indice = i;
                }
            }
        return indice;
    }
}
