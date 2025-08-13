package matrizes;

public class Atividade06 {
    /*Distribuição de Receitas por Agência
Uma matriz double[A][S] representa o total de receitas obtidas por A agências em S segmentos (crédito, tarifas, câmbio etc.).
Métodos a implementar:
double[] totalPorAgencia(double[][] receitas) – retorna um vetor com o total arrecadado por cada agência.


double[] percentualPorSegmento(double[][] receitas) – retorna o percentual que cada segmento representa no total geral.*/
    public static void main(String[] args) {
        double[][] receitasAgencias = {
                {150000.00, 45000.00, 32000.00, 67000.00, 25000.00},
                {130000.00, 55000.00, 30000.00, 72000.00, 27000.00},
                {160000.00, 47000.00, 31000.00, 68000.00, 26000.00},
                {140000.00, 49000.00, 29000.00, 65000.00, 28000.00}
        };
        double[] soma = totalPorAgencia(receitasAgencias);
        System.out.println("--- A soma de cada agência ---");
        for (int i = 0; i < soma.length; i++) {
            System.out.printf("Agência %d: %.2f\n", i + 1, soma[i]);
        }
        System.out.println("------------------------------");
        double[] percentual = percentualPorSegmento(receitasAgencias);
        for (int i = 0; i < percentual.length; i++) {
            System.out.printf("Segmento %d: %.2f%%\n", i + 1, percentual[i]);
        }

    }

    public static double[] totalPorAgencia(double[][] receitas) {
        double[] totalAgencias = new double[receitas.length];
        for (int i = 0; i < receitas.length; i++) {
            double soma = 0;
            for (int j = 0; j < receitas[i].length; j++) {
                soma += receitas[i][j];
            }
            totalAgencias[i] = soma;
        }
        return totalAgencias;
    }

    public static double[] percentualPorSegmento(double[][] receitas) {
        double[] percentual = new double[receitas[0].length];
        double[] somaSegmentos = new double[receitas[0].length];
        double somaTotal = 0;
        for (int i = 0; i < receitas.length; i++) {
            for (int j = 0; j < receitas[i].length; j++) {
                somaTotal += receitas[i][j];
            }
        }
        for (int j = 0; j < receitas[0].length; j++) {
            double soma = 0;
            for (int i = 0; i < receitas.length; i++) {
                soma += receitas[i][j];
            }
            somaSegmentos[j] = soma;
        }
        for (int i = 0; i < percentual.length; i++) {
            percentual[i] = (somaSegmentos[i] / somaTotal) * 100;
        }
        return percentual;
    }
}
