import java.util.Arrays;
import java.util.Scanner;

public class TestePrograma {
    public static void main(String[] args) throws Exception{
        System.out.println("Insira o tamanho do array: ");
        Scanner sc = new Scanner(System.in);

        int array_size = sc.nextInt();

        int[] array = new int[array_size];

        for (int i = 0; i < array_size; i++) {
            int el = sc.nextInt();
            array[i] = el;
        }

        Ficha2 f2 = new Ficha2(array);
        System.out.println("Introduza o número da pergunta: ");
        int pergunta = sc.nextInt();

        switch(pergunta){
            case 1: {
                // 1a)
                int min = f2.valorMinimo();
                System.out.println("O valor minimo é "+ min);

                // 1b)
                System.out.println("Insere um indice");
                int ind1 = sc.nextInt();

                System.out.println("Insere um indice");
                int ind2 = sc.nextInt();

                int[] resultado1b = f2.valorEntre(ind1, ind2);

                String res1b = Arrays.toString(resultado1b);

                System.out.println("Array entre os indices indicados" + res1b);

                // 1c)
                System.out.println("Insira o tamanho do array: ");
                int array_size2 = sc.nextInt();

                int[] array2 = new int[array_size2];

                for (int i = 0; i < array_size; i++) {
                    int el = sc.nextInt();
                    array2[i] = el;
                }
            }
        }




    }
}
