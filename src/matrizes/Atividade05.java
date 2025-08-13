package matrizes;

public class Atividade05 {
    /*
    * Simulação de Juros Compostos Mensais
Uma matriz double[C][M] armazena os saldos mensais de C clientes, considerando juros compostos.
Métodos a implementar:
double calcularJurosMensal(double saldoAnterior, double saldoAtual) – retorna a taxa de juros mensal implícita.
double[] jurosMediosClientes(double[][] saldos) – retorna a média de juros mensais de cada cliente.
*/
    public static void main(String[] args) {
        double[][] saldosMensais = {
                {1000.00, 1030.00, 1070.90, 1123.63},
                {2000.00, 2045.00, 2100.00, 2165.25},
                {1500.00, 1575.00, 1648.75, 1726.18}
        };
        double[] medias = jurosMediosClientes(saldosMensais);
        int cont = 1;
        for (double v : medias) {
            System.out.printf("A média do cliente %d: %.2f%%\n", cont, (v * 100));
            cont++;
        }
    }

    public static double calcularJurosMensal(double saldoAnterior, double saldoAtual) {
        return (saldoAtual / saldoAnterior) - 1;
    }

    public static double[] jurosMediosClientes(double[][] saldos) {
        double[] medias = new double[saldos.length];
        for (int i = 0; i < saldos.length; i++) {
            double soma = 0;
            for (int j = 0; j < saldos[i].length - 1; j++) {
                soma += calcularJurosMensal(saldos[i][j], saldos[i][j + 1]);
            }
            medias[i] = soma / (saldos[i].length - 1);
        }
        return medias;
    }
}
