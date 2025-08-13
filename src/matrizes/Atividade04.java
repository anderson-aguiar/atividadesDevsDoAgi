package matrizes;

public class Atividade04 {
    /*Monitoramento de Transações Acima do Limite
    Uma matriz double[N][D] armazena o valor de transações feitas por N clientes durante D dias.
    Transações acima de R$10.000 devem ser sinalizadas.
    Métodos a implementar:
    boolean[][] transacoesSuspeitas(double[][] transacoes, double limite) – retorna uma matriz booleana com as transações suspeitas.
    void exibirTransacoesSuspeitas(double[][] transacoes, boolean[][] flags) – exibe cliente, dia e valor de cada transação acima do limite.*/
    public static void main(String[] args) {
        final double LIMITE = 10000;
        double[][] transacoesClientes = {
                {9500.00, 10200.50, 8500.75, 11000.00, 7600.30},
                {12000.00, 5000.00, 13000.25, 7000.00, 9800.00},
                {8000.00, 9000.00, 15000.00, 4000.00, 10500.00}
        };
        boolean[][] flags = transacoesSuspeitas(transacoesClientes, LIMITE);
        exibirTransacoesSuspeitas(transacoesClientes, flags);
    }

    public static boolean[][] transacoesSuspeitas(double[][] transacoes, double limite) {
        boolean[][] flags = new boolean[transacoes.length][transacoes[0].length];
        for (int i = 0; i < transacoes.length; i++) {
            for (int j = 0; j < transacoes[i].length; j++) {
                if (transacoes[i][j] > limite) {
                    flags[i][j] = true;
                } else {
                    flags[i][j] = false;
                }
            }
        }
        return flags;
    }

    public static void exibirTransacoesSuspeitas(double[][] transacoes, boolean[][] flags) {
        System.out.println("--- Transações suspeitas por cliente ---");
        for (int i = 0; i < transacoes.length; i++) {
            for (int j = 0; j < transacoes[i].length; j++) {
                if (flags[i][j]) {
                    System.out.printf("Cliente %d - dia %d - R$%.2f\n", i + 1, j + 1, transacoes[i][j]);
                }
            }
        }
    }
}
