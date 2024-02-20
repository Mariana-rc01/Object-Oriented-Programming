/** susana.v.marques@inestec.pt
 * sala 2.12 DI
*/

// a main só serve para interargir com o utilizador
import java.util.Scanner;

public class TestePrograma {
    public static void main(String[] args) { //só usar na main
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduza o número da pergunta: ");
        int pergunta = sc.nextInt();

        Ficha1 f1 = new Ficha1();

        switch (pergunta){
            case 1: { // done
             
                System.out.println("Introduza um dia (1-31): ");
                int day = sc.nextInt();

                System.out.println("Introduza um mês (1-12): ");
                int month = sc.nextInt();

                System.out.println("Introduza um ano: ");
                int year = sc.nextInt();

                if (day < 1 || day > 31) System.out.println("Não introduziu um dia válido");
                else if (month < 1 || month > 12) System.out.println("Não introduziu um mês válido");
                else {
                    String semana = f1.calculaSemana(day, month, year);
                    System.out.println("Esse dia corresponde a uma " + semana);
                }
                break;
            }

            case 2: {
                System.out.println("Introduza uma data: ");
                int a = sc.nextInt();
        
                System.out.println("Introduza outra data: ");
                int b = sc.nextInt();
        
                int max = f1.maximoNumeros(a, b);
        
                System.out.println("A diferença entre as duas datas que inseriu é ");
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
                int n = sc.nextInt();
                int maior = 0;
                int dias = 0;
                int media = 0;

                while (n != 0) {
                    System.out.println("Introduza uma temperatura: ");
                    int t = sc.nextInt();

                    n--;
                }
        
                System.out.println("Introduza uma taxaConversao: ");
                double taxa = sc.nextDouble();

                double libras = f1.eurosParaLibras(valor, taxa);
                System.out.println("O valor em libras é "+libras);
                break;
            }

            case 5: { // done
                double base = 1.0;
                double altura = 0.0;

                while (base != 0.0) {
                    System.out.println("Introduza um valor para a base do triângulo: ");
                    base = sc.nextDouble();

                    System.out.println("Introduza um valor para a altura do triângulo: ");
                    altura = sc.nextDouble();

                    double area = base * altura / 2.0;

                    double outroLado = Math.sqrt(Math.pow(base, 2) + Math.pow(altura, 2));

                    double perimetro = base + altura + outroLado;

                    System.out.println("A área do triângulo é: " + area);
                    System.out.println("O perimetro do triângulo é: " + perimetro);
                }
                break;
            }

            case 6: { // Done
                System.out.println("Introduza um número: ");
                int n = sc.nextInt();

                for (int i = n; i > 1; i--)
                    if (f1.isPrime(i)) System.out.println(i);
                break;
            }

            case 7: {
                long time = f1.tempoGasto();
                System.out.println("O sistema demorou "+time+" milissegundos a executar o fatorial de 5000.");
                break;
            }
            default: {
                System.out.println("Não introduziste um número válido");
            }
        }
    }
}
