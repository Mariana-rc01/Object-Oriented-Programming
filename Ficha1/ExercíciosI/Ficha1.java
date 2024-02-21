import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Ficha1 {
    /* Exercício 1 */
    public String calculaSemana(int day, int month, int year) {

        int totalDias = (year - 1900) * 365;
        if (bissexto(totalDias))
            totalDias = (totalDias - 1900) / 4;

        if (bissexto(year))
            totalDias -= 1;

        totalDias += contarDiasAno(day, month, year);

        int diaSemana = totalDias % 7;

        return obterNomeDiaDaSemana(diaSemana);

    }

    public String obterNomeDiaDaSemana(int diaDaSemana) {
        switch (diaDaSemana) {
            case 0:
                return "Domingo";
            case 1:
                return "Segunda-feira";
            case 2:
                return "Terça-feira";
            case 3:
                return "Quarta-feira";
            case 4:
                return "Quinta-feira";
            case 5:
                return "Sexta-feira";
            case 6:
                return "Sábado";
            default:
                return "Erro: dia da semana inválido!";
        }
    }


    public int contarDiasAno(int day, int month, int year) {
        int days = 0;

        for (int i = 1; i < month; i++) {
            days += obterDiasMes(i, year);
        }
        days += day;

        return days;
    }

    public int obterDiasMes (int month, int year) {
        if (month == 2)
            return bissexto(year) ? 29 : 28;
        else if (month == 4 || month == 6 || month == 9 || month == 11) return 30;
        else return 1;
    }

    public boolean bissexto(int year){
        return year % 4 == 0 && (year % 100 != 0 || year % 400 == 0);
    }

    /* Exercício 2 */
    public String somaDatas(String data1, String data2) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime d1, d2;
        try {
            d1 = LocalDateTime.parse(data1, formatter);
            d2 = LocalDateTime.parse(data2, formatter);
        } catch (Exception e) {
            return "Formato de data inválido. Use o formato yyyy-MM-dd HH:mm:ss.";
        }

        Duration duration = Duration.between(d1,d2);

        long dias = duration.toDays();
        long horas = duration.toHours() % 24;
        long minutos = duration.toMinutes() % 60;
        long segundos = duration.getSeconds() % 60;

        return String.format("%02dD %02dH %02dM %02dS", dias, horas, minutos,segundos);
    }

    /* Exercício 3 feito na main*/

    /* Exercício 4 feito na main*/

    /* Exercício 5 feito na main*/

    /* Exercício 6 */
    public boolean isPrime(int num) {
        if (num <= 1) return false;

        for (int i = 2; i < num; i++)
            if (num % i == 0) return false;

        return true;
    }

    /* Exercício 7 */
    public long calculaIdadeHoras(String dia){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime d, local;
        try {
            d = LocalDateTime.parse(dia, formatter);
        } catch (Exception e) {
            return -1;
        }

        local = LocalDateTime.now();
        Duration duracao = Duration.between(d,local);

        return duracao.toHours();
    }
}