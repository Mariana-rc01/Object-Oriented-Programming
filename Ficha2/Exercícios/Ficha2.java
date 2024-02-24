import java.util.Arrays;

public class Ficha2 {
    private int[] arr;

    public Ficha2(int[] array){
        this.arr = Arrays.copyOfRange(array, 0, array.length);
    }

    // Exercício 1 a)
    public int valorMinimo(){
        int min = Integer.MAX_VALUE;
        for (int el : arr)
            if (el < min) min = el;

        return min;
    }

    // Exercício 1 b)
    public int[] valorEntre(int ind1, int ind2){
        int[] array_return = new int[ind2-ind1+1];
        int j = 0;
        for (int i = ind1; i <= ind2; i++){
            array_return[j++] = arr[i];
        }

        return array_return;
    }

    // Exercício 1 c)
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

    // Exercício 3 a)
    public int[] ordena(){
        Arrays.sort(arr);
        return arr;
    }

    // Exercício 3 b)

    public int procura(int i){
        return Arrays.binarySearch(arr,i);
    }

    // Exercício 5

}
