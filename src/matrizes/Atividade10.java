package matrizes;

public class Atividade10 {
    /*Controle de Saques e Depósitos
Uma matriz double[N][M] armazena movimentações diárias de N contas bancárias (valores positivos são depósitos, negativos são saques).
Métodos a implementar:
double totalSaques(double[][] mov) – retorna o total sacado em todas as contas.
double totalDepositos(double[][] mov) – retorna o total depositado.
double[] saldoFinalContas(double[][] mov) – retorna o saldo final de cada conta.


    * */
    public static void main(String[] args) {
        double[][] movimentacoes = {
                {500.0, -200.0, 300.0, -150.0, 400.0},
                {-100.0, 250.0, -50.0, 300.0, -200.0},
                {1000.0, -500.0, 200.0, -300.0, 150.0},
                {200.0, -100.0, 50.0, 75.0, -25.0}
        };
        System.out.println("Total de saques: R$ " + totalSaques(movimentacoes));
        System.out.println("Total de depositos: R$ " + totalDepositos(movimentacoes));
        System.out.println("--- Saldo de cada conta ---");
        double[] saldos = saldoFinalContas(movimentacoes);
        for (int i = 0; i < saldos.length; i++) {
            System.out.printf("%2sSaldo conta %d: R$%.2f\n", "", i + 1, saldos[i]);
        }
        System.out.print("-".repeat(27));

    }

    public static double totalSaques(double[][] mov) {
        double totalSacado = 0;
        for (int i = 0; i < mov.length; i++) {
            for (int j = 0; j < mov[i].length; j++) {
                if (mov[i][j] < 0) {
                    totalSacado += Math.abs(mov[i][j]);
                }
            }
        }
        return totalSacado;
    }

    public static double totalDepositos(double[][] mov) {
        double totalDeposito = 0;
        for (int i = 0; i < mov.length; i++) {
            for (int j = 0; j < mov[i].length; j++) {
                if (mov[i][j] > 0) {
                    totalDeposito += mov[i][j];
                }
            }
        }
        return totalDeposito;
    }

    public static double[] saldoFinalContas(double[][] mov) {
        double[] saldos = new double[mov.length];
        for (int i = 0; i < mov.length; i++) {
            double saldo = 0;
            for (int j = 0; j < mov[i].length; j++) {
                saldo += mov[i][j];
            }
            saldos[i] = saldo;
        }
        return saldos;
    }
}
