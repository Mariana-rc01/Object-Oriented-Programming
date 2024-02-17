/** susana.v.marques@inestec.pt
 * sala 2.12 DI
*/

// Exercícios I em casa 
// a main só serve para interargir com o utilizador
import java.util.Scanner;

public class TestePrograma {
    public static void main(String[] args) throws Exception { //só usar na main
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduza o número da pergunta: ");
        int pergunta = sc.nextInt();

        Ficha1 f1 = new Ficha1();

        switch (pergunta){
            case 1: {
             
                System.out.println("Introduza a temperatura em graus Celsius: ");
                double d = sc.nextDouble();

                double f = f1.celsiusParaFarenheit(d);

                System.out.println("A temperatura em Farenheit é "+f);   
                break;
            }

            case 2: {
                System.out.println("Introduza um número: ");
                int a = sc.nextInt();
        
                System.out.println("Introduza outro número: ");
                int b = sc.nextInt();
        
                int max = f1.maximoNumeros(a, b);
        
                System.out.println("O número "+max+ " é o maior");
                break;
            }

            case 3: {
                System.out.println("Introduza um nome: ");
                String nome = sc.next();
        
                System.out.println("Introduza um saldo: ");
                double saldo = sc.nextDouble();

                String descricao = f1.criaDescricaoConta(nome, saldo);
                System.out.println("Descrição "+descricao);
                break;
            }

            case 4: {
                System.out.println("Introduza um valor: ");
                double valor = sc.nextDouble();
        
                System.out.println("Introduza uma taxaConversao: ");
                double taxa = sc.nextDouble();

                double libras = f1.eurosParaLibras(valor, taxa);
                System.out.println("O valor em libras é "+libras);
                break;
            }

            case 5: {
                System.out.println("Introduza um número: ");
                int a5 = sc.nextInt();
        
                System.out.println("Introduza outro número: ");
                int b5 = sc.nextInt();
        
                int menor = Math.min(a5,b5);
                int maior = Math.max(a5,b5);
                double media = (a5 + b5) / 2;
        
                System.out.println("O menor valor é " + menor + " a media é " + media + " e o maior valor é " + maior);
                break;
            }

            case 6: {
                System.out.println("Introduza um número que pretendas saber o fatorial: ");
                int n = sc.nextInt();
        
                long fatorial = f1.factorial(n);
        
                System.out.println("O fatorial de " + n + " é " + fatorial);
                break;
            }

            case 7: {
                long time = f1.tempoGasto();
                System.out.println("O sistema demorou "+time+" milissegundos a executar o fatorial de 5000.");
                break;
            }
            default:
                 System.out.println ("Não introduziste um número válido");
        }
    }
}
