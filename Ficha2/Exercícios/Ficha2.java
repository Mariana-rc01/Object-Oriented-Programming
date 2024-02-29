import java.time.Duration;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

public class Ficha2 {
    private int[] arr;
    private LocalDate[] datas;

    private String[] strings;

    public Ficha2(int[] array, LocalDate[] dates, String[] string){
        this.arr = Arrays.copyOfRange(array, 0, array.length);
        this.datas = Arrays.copyOfRange(dates,0, dates.length);
        this.strings = Arrays.copyOfRange(string,0,string.length);
    }

    /* Exercício 1*/

    // Exercício 1a)
    public int valorMinimo(){
        int min = Integer.MAX_VALUE;
        for (int el : arr)
            if (el < min) min = el;

        return min;
    }

    // Exercício 1b)
    public int[] valorEntre(int ind1, int ind2){
        int[] array_return = new int[ind2-ind1+1];
        int j = 0;
        for (int i = ind1; i <= ind2; i++){
            array_return[j++] = arr[i];
        }

        return array_return;
    }

    // Exercício 1c)
    public int[] elementosComuns(int[] array2){
        int[] array_return = new int[arr.length];
        int el = 0;
        for (int i = 0; i < arr.length; i++){
            for (int j = 0; j < array2.length; j++){
                if(arr[i] == array2[j]) {
                    boolean flag = false;
                    for(int k = 0; k < el && !flag; k++){ // Verificar se ainda está no result
                        if (array_return[k] == arr[i]) flag = true;
                    }
                    if (!flag) array_return[el++] = arr[i];
                }
            }
        }

        return Arrays.copyOfRange(array_return,0,el);
    }


    /* Exercício 2*/

    // Exercício 2a)
    public void insereData(LocalDate data){
        LocalDate[] newArr = Arrays.copyOf(datas, datas.length + 1);
        newArr[newArr.length-1] = data;
        datas = newArr;
    }

    // Exercício 2b)
    public LocalDate dataMaisProxima(LocalDate data){
        long diferenca = 0, duracao = 0;
        LocalDate maisProxima = datas[0];
        for (LocalDate d: datas){
            duracao = Duration.between(data, d).getSeconds();
            if (Math.abs(duracao) < Math.abs(diferenca)) {
                diferenca = duracao;
                maisProxima = d;
            }
        }
        return maisProxima;
    }

    // Exercício 2c)
    public String toString(){
        return Arrays.toString(datas);
    }

    /* Exercício 3*/

    // Exercício 3a)
    public int[] ordena(){
        Arrays.sort(arr);
        return arr;
    }

    // Exercício 3b)
    public int procura(int i){
        return Arrays.binarySearch(arr,i);
    }

    /* Exercício 4*/

    // Exercício 4a)
    public String[] semReps(){
        HashSet<String> set = new HashSet<>();
        for(String s: strings){
            set.add(s);
        }
        // Collections.addAll(set, strings); -> outra forma de fazer o for
        return set.toArray(new String[set.size()]);
    }

    // Exercicio 4b)

    public String maiorString(){
        String maior = strings[0];
        int tamanho = 0;
        for(String string: strings){
            if (string.length() > tamanho){
                tamanho = string.length();
                maior = string;
            }
        }
        return maior;
    }

    // Exercício 4c)
    public String[] apenasReps(){
        String[] repeticoes = new String[strings.length];
        Arrays.sort(strings);
        int tamanho = 0;
        for (int i = 0; i < strings.length-1; i++){
            if (strings[i].equals(strings[i+1])) {
                if (tamanho == 0 || !strings[i].equals(repeticoes[tamanho - 1]))
                    repeticoes[tamanho++] = strings[i];
            }
        }
        repeticoes = Arrays.copyOf(repeticoes, tamanho);
        return repeticoes;
    }

    // Exercício 4d)
    public int numeroString(String string){
        int n = 0;
        for(String s: strings){
            if (s.equals(string)) n++;
        }
        return n;
    }

    /* Exercício 5*/

    // Exercício 5b)
    public int somaNotasUC(int[][] notasTurma, int UC){
        int soma = 0;
        for (int i = 0; i < notasTurma[0].length; i++){
            soma += notasTurma[i][UC];
        }
        return soma;
    }

    // Exercício 5c)
    public int mediaAluno(int[][] notasTurma, int aluno){
        int soma = 0;
        for (int i = 0; i < notasTurma.length; i++){
            soma += notasTurma[aluno][i];
        }
        soma /= notasTurma.length;
        return soma;
    }

    // Exercício 5d)
    public int mediaNotasUC(int[][] notasTurma, int UC){
        return (somaNotasUC(notasTurma,UC) / notasTurma[0].length);
    }

    // Exercício 5e)
    public int notaMaisAlta(int[][] notasTurma){
        int maior = notasTurma[0][0];
        for (int i = 0; i < notasTurma.length; i++){
            for (int j = 0; j < notasTurma[0].length; j++){
                if (notasTurma[i][j] > maior) maior = notasTurma[i][j];
            }
        }
        return maior;
    }

    // Exercício 5f)
    public int notaMaisBaixa(int[][] notasTurma){
        int menor = notasTurma[0][0];
        for (int i = 0; i < notasTurma.length; i++){
            for (int j = 0; j < notasTurma[0].length; j++){
                if (notasTurma[i][j] < menor) menor = notasTurma[i][j];
            }
        }
        return menor;
    }

    // Exercício 5g)
    public int[] notasAcima(int[][] notasTurma, int nota){
        int[] notas = new int[notasTurma.length * notasTurma[0].length];
        int tamanho = 0;

        for (int i = 0; i < notasTurma.length; i++){
            for (int j = 0; j < notasTurma[0].length; j++){
                if (notasTurma[i][j] > nota) notas[tamanho++] = notasTurma[i][j];
            }
        }

        return Arrays.copyOfRange(notas,0, tamanho);
    }

    // Exercício 5h)
    public String stringNotas(int[][] notasTurma){
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < notasTurma.length; i++){
            sb.append("Aluno ").append(i+1).append(": ");
            for (int j = 0; j < notasTurma[i].length; j++){
                sb.append(notasTurma[i][j]).append(" ");
            }
            sb.append("\n");
        }

        return sb.toString();
    }

    // Exercício 5i)

    public int indiceUCMaisAlta(int[][] notasTurma){
        int maior = 0;
        int indice = 0;
        for (int j = 0; j < notasTurma[0].length; j++){
            int media = mediaNotasUC(notasTurma, j);
            if (media > maior) {
                media = maior;
                indice = j;
            }
        }
        return indice;
    }

    /* Exercício 6*/

    // Exercício 6a)
    public void lerMatriz(int[][] matriz){
        for (int i = 0; i < matriz.length; i++){
            for (int j = 0; j < matriz[0].length; j++){
                matriz[i][j] = 0;
            }
        }
    }

    // Exercício 6b)
    public int[][] somaMatrizes(int[][] matriz1, int[][] matriz2){
        int linhas = matriz1.length;
        int colunas = matriz1[0].length;
        int[][] resultado= new int[linhas][colunas];

        for (int i = 0; i < linhas; i++){
            for (int j = 0; j < colunas; j++){
                resultado[i][j] = matriz1[i][j] + matriz2[i][j];
            }
        }

        return resultado;
    }

    // Exercício 6c)

    public boolean iguaisMatrizes(int[][] matriz1, int[][] matriz2){
        if (matriz1.length != matriz2.length || matriz1[0].length != matriz2[0].length)
            return false;

        int linhas = matriz1.length;
        int colunas = matriz1[0].length;

        for (int i = 0; i < linhas; i++){
            for (int j = 0; j < colunas; j++){
                if(matriz1[i][j] != matriz2[i][j]) return false;
            }
        }

        return true;
    }

    // Exercício 6d)

    public int[][] matrizOposta(int[][] matriz){
        int linhas = matriz.length;
        int colunas = matriz[0].length;
        int[][] resultado= new int[linhas][colunas];

        for (int i = 0; i < linhas; i++){
            for (int j = 0; j < colunas; j++){
                resultado[i][j] = -matriz[i][j];
            }
        }

        return resultado;
    }

    /* Exercício 7*/
    public int[] geracaoNumeros(){
        int[] numerosChave = new int[5];
        int i = 0, numero;
        while (i != 5){
            numero = (int) (Math.random() % 50 + 1);
            boolean repetido = false;
            for (int j = 0; j < i; j++){
                if (numerosChave[j] == numero) {
                    repetido = true;
                    break;
                }
            }
            if (!repetido){
                numerosChave[i++] = numero;
            }
        }
        return numerosChave;
    }

    public int[] geracaoEstrelas(){
        int[] estrelasChave = new int[2];
        int i = 0, numero = 0;
        while (i != 2){
            numero = (int) (Math.random() % 9 + 1);
            boolean repetido = false;
            for (int j = 0; j < i; j++){
                if (estrelasChave[j] == numero) {
                    repetido = true;
                    break;
                }
            }
            if (!repetido){
                estrelasChave[i++] = numero;
            }
        }
        return estrelasChave;
    }

    public int[] Euromilhoes(int[] chave, int[] user){
        int[] array_return = new int[chave.length];
        int el = 0;
        for (int i = 0; i < chave.length; i++){
            for (int j = 0; j < user.length; j++){
                if(chave[i] == user[j]) {
                    boolean flag = false;
                    for(int k = 0; k < el && !flag; k++){ // Verificar se ainda está no result
                        if (array_return[k] == chave[i]) flag = true;
                    }
                    if (!flag) array_return[el++] = chave[i];
                }
            }
        }
        return Arrays.copyOfRange(array_return,0,el);
    }

}
