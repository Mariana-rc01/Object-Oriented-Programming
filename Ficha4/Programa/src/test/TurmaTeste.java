package test;
import java.util.ArrayList;
import java.util.List;

import main.Turma;

public class TurmaTeste {

    Turma al;
    
    void setUp(){
        List<Aluno> list = new ArrayList<>();
        for (int i = 0; i < 10; i++){
            list.add(new Aluno(String.valueOf(i,20, "Joao","POO")));
        }
        al = new Turma("POO", list);
    }

    void getDescricao(){
        assertEquals(al.getDescricao().equals("POO"),true);
    }

    void getAluno(){
        Aluno x = new Aluno("2",20,"Joao","POO");
        assertEquals(al.getAlunos().get(2).equals(x),true);
    }

    void testClone(){
        Turma turma = al.clone();
        assertEquals(turma.equals(al),true);
    }

    void testEquals(){
        assertEquals(al.equals(a),true);
    }
}

