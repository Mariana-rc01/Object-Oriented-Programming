package main;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Turma {
    private String descricao;
    private List<Aluno> alunos; //numero, nota, nome, curso

    public Turma(){
        this.descricao = new String("POO");
        this.alunos = new ArrayList<>();
    }

    public Turma(String descricao, List<Aluno> alunos){
        this.descricao = descricao;
        this.alunos = new ArrayList<>();
        this.alunos = alunos.stream().map(a -> a.clone()).collect(Collectors.toList());
        /*
        for (Aluno a: alunos) this.alunos.add(a.clone());
        */
    }

    public Turma(Turma al){
        this.descricao = al.getDescricao();
        this.alunos = al.getAlunos();
    }

    public String getDescricao(){
        return this.descricao;
    }

    public List<Aluno> getAlunos(){
        List<Aluno> ret = new ArrayList<>();
        ret = this.alunos.stream().map(a -> a.clone()).collect(Collectors.toList());
        /*for(Aluno a: this.alunos){
            ret.add(a.clone());
        }*/
        return ret;
    }

    public void setAlunos(List<Aluno> al){
        this.alunos = new ArrayList<>();
        this.alunos = al.stream().map(a -> a.clone()).collect(Collectors.toList());
        /*for (Aluno a: al){
            this.alunos.add(a.clone());
        }*/
    }

    public void addAluno(Aluno al){
        this.alunos.add(al.clone());
    }

    public boolean existeAluno(Aluno a){
        return this.alunos.contains(a);
    }

    public boolean existeAluno(String numero){
        /*boolean flag = false;
        for(Aluno a: this.alunos){
            if (a.getNumero().equals(numero)) flag = true;
        }
        return flag;*/
        return this.alunos.stream().anyMatch(a -> a.getNumero().equals(numero));
    }

    public boolean removeAluno(Aluno a){
        boolean flag = false;
        if (this.alunos.contains(a)){
            this.alunos.remove(a);
            flag = true;
        }
        return flag;
    }

    public Turma clone(){
        return new Turma(this);
    }

    public String toString(){
        return "descricao "+ descricao + " alunos: " + alunos.toString();
    }

    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || o.getClass() != this.getClass()) return false;
        Turma t = (Turma) o;
        return (t.getDescricao().equals(this.descricao) && t.getAlunos().equals(this.alunos));
    }

    public void removeAluno_Nota(int nota){
        Iterator<Aluno> it = this.alunos.iterator();

        Aluno a;
        while (it.hasNext()){
            a = it.next(); //primeiro colocámos o aluno em a e depois faz next
            if (a.getNota() > nota){
                it.remove();
            }
        }
    }

    Predicate<Aluno> a = aluno -> aluno.getNota() > 10;

    public List<Aluno> adicionaAluno_Nota(){
        return this.alunos.stream().filter(aluno -> aluno.getNota() > 10).map(a -> a.clone()).collect(Collectors.toList());
    }

    public List<Aluno> adiciona2Valores(){
        return this.alunos.stream().map(a -> {a.setNota(a.getNota() + 2); a.clone();}).collect(Collectors.toList());
        //return this.alunos.forEach(a -> a.setNota(a.getNota() + 2)); //aqui não estamos a fazer o clone tho
    }


    public int somaNotas(){
        //return (int) this.alunos.stream().map(a -> a.getNota()).reduce(0, (n1, n2) -> n1+n2);
        return this.alunos.stream().mapToInt(a -> a.getNota()).sum();
    }


    public List<Aluno> ordenarCrescente(){
        // com nota
        return this.alunos.stream().map(a -> a.clone()).sorted((o1,o2)-> o1.getNota() - o2.getNota()).collect(Collectors.toList());

        // com nome
        //return this.alunos.stream().map(a -> a.clone()).sorted((o1,o2)-> o1.getNome().compareTo(o2.getNome())).collect(Collectors.toList());
    }

    public List<Aluno> ordenarDecrescente(){
        // com nota
        return this.alunos.stream().map(Aluno::clone).sorted((o1,o2)-> o2.getNota() - o1.getNota()).collect(Collectors.toList());
    }

    public Aluno melhorNota(){
        //return this.alunos.stream().max((o1,o2) -> o1.getNota() > o2.getNota()).get().clone();
        return this.alunos.ordenarDescrescente().findFirst().get().clone();
    }

}
