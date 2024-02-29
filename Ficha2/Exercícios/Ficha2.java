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
