public class Ficha1 {
    /* Exercício 1 */
    public double celsiusParaFarenheit(double graus) {
        return graus*9/5 + 32;
    }

    /* Exercício 2 */
    public int maximoNumeros(int a, int b) {
        return Math.max(a,b);
    }

    /* Exercício 3 */
    public String criaDescricaoConta(String nome, double saldo) {
        return "O saldo de " + nome + " é " + saldo;
    }

    /* Exercício 4 */
    public double eurosParaLibras(double valor, double taxaConversao) {
        return valor*taxaConversao;
    }

    /* Exercício 5 feito na main*/

    /* Exercício 6 */
    public long factorial(int num) {
        long fatorial = 1;

        while (num != 1) {
            fatorial = fatorial * num;
            num = num - 1;
        }

        return fatorial;
    }

    /* Exercício 7 */
    public long tempoGasto(){
        long f;

        long before = System.currentTimeMillis();
        factorial(5000);
        long after = System.currentTimeMillis();
        
        f = after - before;

        return f;
    }
}
