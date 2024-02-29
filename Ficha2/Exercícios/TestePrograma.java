import java.time.LocalDate;
import java.util.Arrays;
import java.util.Scanner;
import java.lang.Math;

public class TestePrograma {
    public static void main(String[] args) throws Exception{
        System.out.println("Insira o tamanho do array de inteiros: ");
        Scanner sc = new Scanner(System.in);

        int array_size = sc.nextInt();

        int[] array = new int[array_size];

        for (int i = 0; i < array_size; i++) {
            int el = sc.nextInt();
            array[i] = el;
        }

        System.out.println("Insira o tamanho do array de datas: ");
        int arrayDT = sc.nextInt();

        LocalDate[] arrayD = new LocalDate[arrayDT];

        for (int i = 0; i < arrayDT; i++) {
            System.out.println("Insira uma data no formato yyyy-MM-dd: ");
            String dateString= sc.next();
            LocalDate date = LocalDate.parse(dateString);
            arrayD[i] = date;
        }

        System.out.println("Insira o tamanho do array de strings: ");
        int arrayST = sc.nextInt();

        String[] arrayS = new String[arrayST];

        for (int i = 0; i < arrayST; i++) {
            String s = sc.next();
            arrayS[i] = s;
        }

        Ficha2 f2 = new Ficha2(array,arrayD,arrayS);
        String[] repetidas = f2.apenasReps();

        for (String palavra: repetidas){
            System.out.println(palavra);
        }
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
                break;
            }
            case 7:{

                int[] numerosChave;
                int[] estrelasChave;

                numerosChave = Arrays.copyOfRange(f2.geracaoNumeros(),0,5);
                estrelasChave = Arrays.copyOfRange(f2.geracaoEstrelas(),0,2);

                System.out.println("Insira 5 numeros para o EuroMilhoes: ");
                int[] arrayN = new int[5];
                for (int i = 0; i < 5; i++) {
                    int el = sc.nextInt();
                    arrayN[i] = el;
                }

                System.out.println("Insira 2 estrelas para o EuroMilhoes: ");
                int[] arrayE = new int[2];
                for (int i = 0; i < 2; i++) {
                    int el = sc.nextInt();
                    arrayE[i] = el;
                }

                int[] repetidosNumero = f2.Euromilhoes(numerosChave,arrayN);
                int[] repetidosEstrela = f2.Euromilhoes(estrelasChave,arrayE);

                if (repetidosEstrela.length == 2 && repetidosNumero.length == 5){
                    System.out.println("Acertou na chave!!!");
                    for (int i = 0; i < 50; i++){
                        for (int numero: numerosChave)
                            System.out.print(numero + " ");

                        for (int estrela: estrelasChave)
                            System.out.print(estrela + " ");

                        System.out.println();

                        for (int j = 0; j < i+1; j++){
                            System.out.print("  ");
                        }
                    }
                }
                else {
                    System.out.println("Numeros coincidentes: ");
                    for (int j : repetidosNumero) {
                        System.out.println(j);
                    }

                    System.out.println("Estrelas coincidentes: ");
                    for (int k : repetidosEstrela) {
                        System.out.println(k);
                    }
                }

            }
        }




    }
}
