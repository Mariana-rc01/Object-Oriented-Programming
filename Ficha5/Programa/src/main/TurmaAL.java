package main;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class TurmaAL {
    private String descricao;
    private Map<String,Aluno> alunos;

    public TurmaAL(){
        this.descricao = new String("POO");
        this.alunos = new HashMap<>();
    }

    public TurmaAL(String descricao, Map<String,Aluno> al){
        this.descricao = descricao;
        //this.alunos = al.keySet().stream().collect(Collectors.toMap(chave -> chave, chave -> this.alunos.get(chave)).clone());
        // ou
        this.alunos = al.values().stream().collect(Collectors.toMap(a -> a.getNumero(), a -> a.clone()));
        
        this.alunos = al.entrySet().stream().collect(Collectors.toMap(par -> par.getKey(), par -> par.getValue().clone()));
    }

    public TurmaAL(Turma al){
        this.descricao = al.getDescricao();
        this.alunos = al.getAlunos();
    }

    public String getDescricao(){
        return this.descricao;
    }

    public Map<String,Aluno> getAlunos(){
        return this.alunos.values().stream().collect(Collectors.toMap(a -> a.getNumero(), a -> a.clone()));
    }

    public void setAlunos(Map<String,Aluno> al){
        this.alunos = al.values().stream().map(a -> a.clone()).collect(Collectors.toMap(a -> a.getNumero(), a -> a.clone()));
    }

    public void addAluno(Aluno al){
        this.alunos.put(al.getNumero(), al.clone());
    }

    public boolean existeAluno(Aluno a){
        return this.alunos.containsKey(a.getNumero());
        //ou
        // return this.alunos.keySet().contains(al);
    }

    public Aluno getAluno(String numero){
        if (this.alunos.existeAluno(numero)){
            return this.alunos.get(numero).clone();
        }
        else return null;
    }

    public boolean removeAluno(Aluno a){
        boolean flag = false;
        if (this.alunos.containsKey(a.getNumero())){
            this.alunos.remove(a);
            flag = true;
        }
        return flag;
    }

    public TurmaAL clone(){
        return new TurmaAL(this);
    }

    public String toString(){
        return "descricao "+ descricao + " alunos: " + alunos.toString();
    }

    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || o.getClass() != this.getClass()) return false;
        TurmaAL t = (TurmaAL) o;
        return (t.getDescricao().equals(this.descricao) && t.getAlunos().equals(this.alunos));
    }

    public Set<String> todosOsCodigos(){
        return new TreeSet<>(this.alunos.keySet());
    }

    public int qtsAlunos(){

    }

    public Collection<Aluno> alunosOrdemAlfabetica(){
        Set<Aluno> novo = new TreeSet<>();
        for (Aluno al: this.alunos.values()){
            new.add(al.clone());
        }
        return novo;
    }

    public Collection<Aluno> alunosOrdemAlfabeticaAOcontrario(){
        /*Set<Aluno> novo = new TreeSet<>();
        for (Aluno al: this.alunos.values()){
            new.add(al.clone());
        }*/
        //ou
        novo = this.alunos.values().stream().map(Aluno::clone).sorted((o1,o2)-> o2.getNome().compareTo(o1.getNome())).collect(Collectors.toSet());
        return novo;
    }

    public Collection<Aluno> alunosOrdemAlfabeticaAOcontrario1(){
        //return this.alunos.values().stream().map(Aluno::clone).sorted(new ComparatorAlunoNumero()).collect(Collectors.toSet());
        //ou
        Set<Aluno> novo = new TreeSet<>(new ComparatorAlunoNumero());
        for (Aluno al: this.alunos.values()){
            new.add(al.clone());
        }
        return novo;
    }


}
