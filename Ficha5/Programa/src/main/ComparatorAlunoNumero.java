package main;

import java.util.Comparator;

public class ComparatorAlunoNumero implements Comparator<Aluno> {
    public int compare (Aluno al1, Aluno al2){
        if (al1.getNumero().compareTo(al2.getNumero()) < 0) return -1;
        else if (al1.getNumero().compareTo(al2.getNumero()) > 0) return 1;
        else return 0;
    }
}
