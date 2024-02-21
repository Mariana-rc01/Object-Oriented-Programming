/** susana.v.marques@inestec.pt
 * sala 2.12 DI
*/

// a main só serve para interargir com o utilizador
import java.time.LocalDateTime;
import java.util.Scanner;
import java.time.format.DateTimeFormatter;

public class TestePrograma {
    public static void main(String[] args) { //só usar na main
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduza o número da pergunta: ");
        int pergunta = sc.nextInt();

        Ficha1 f1 = new Ficha1();

        switch (pergunta){
            case 1: {
             
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
                String a = "2024-02-21 12:00:00";
                String b = "2024-02-23 08:30:45";
        
                String soma = f1.somaDatas(a,b);
        
                System.out.println(soma);
                break;
            }

            case 3: {
                System.out.println("Quantas classificações pretende introduzir? ");
                int n = sc.nextInt();
                int f = 0, f2 = 0, f3 = 0, f4 = 0;

                for (int i = n; i != 0; i--) {
                    System.out.println("Introduza uma nota: ");
                    double nota = sc.nextDouble();
                    if (nota < 5.0 && nota > 0.0) f++;
                    else if (nota >= 5.0 && nota < 10.0) f2++;
                    else if (nota >= 10.0 && nota < 15.0) f3++;
                    else if (nota >=15.0 && nota <= 20.0) f4++;
                }

                System.out.println("No intervalo [0,5[ houveram "+f+" notas.");
                System.out.println("No intervalo [5,10[ houveram "+f2+" notas.");
                System.out.println("No intervalo [10,15[ houveram "+f3+" notas.");
                System.out.println("No intervalo [15,20] houveram "+f4+" notas.");
                break;
            }

            case 4: {
                System.out.println("Introduza um valor: ");
                int n = sc.nextInt();
                int maior = 0;
                int dias = 0;
                double media = 0;
                int anterior = 0;
                int antT = 0;

                while (n != 0) {
                    System.out.println("Introduza uma temperatura: ");
                    int t = sc.nextInt();

                    media += t;
                    if (Math.abs(t - antT) > Math.abs(maior)) {
                        maior = t - antT;
                        anterior = dias;
                    }
                    antT = t;
                    n--;
                    dias++;
                }

                media = media/dias;

                System.out.println("A média das "+n+" temperaturas foi de "+media+ " graus");
                if (maior > 0) System.out.println("A maior variação registou-se entre os dias " + anterior + " e " + (anterior + 1) + " tendo a temperatura subido " + maior + " graus");
                else System.out.println("A maior variação registou-se entre os dias " + anterior + " e " + (anterior + 1) + " tendo a temperatura descido " + maior + " graus");
                break;
            }

            case 5: {
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

            case 6: {
                System.out.println("Introduza um número: ");
                int n = sc.nextInt();

                for (int i = n; i > 1; i--)
                    if (f1.isPrime(i)) System.out.println(i);
                break;
            }

            case 7: {
                String n = "2001-10-01 00:00:00";

                long time = f1.calculaIdadeHoras(n);
                LocalDateTime agora = LocalDateTime.now();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
                String agoraF = agora.format(formatter);
                System.out.println("A sua idade atual em horas é "+time+". E foi calculada no dia "+agoraF+".");
                break;
            }
            default: {
                System.out.println("Não introduziste um número válido");
            }
        }
    }
}
