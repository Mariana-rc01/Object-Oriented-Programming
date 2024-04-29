import java.time.LocalDate;
import java.util.Objects;

public class Abs extends Atividade{
    private int numeroAbs;
    private int reps;

    public Abs(){
        super();
        this.reps = 0;
        this.numeroAbs = 0;
    }

    public Abs(int numeroAbs, int reps) {
        this.numeroAbs = numeroAbs;
        this.reps = reps;
    }

    public Abs(String codigo, String descricao, LocalDate data, int duracao, int numeroAbs, int reps) {
        super(codigo, descricao, data, duracao);
        this.numeroAbs = numeroAbs;
        this.reps = reps;
    }

    public Abs(Abs a) {
        super(a);
        this.numeroAbs = a.getNumeroAbs();
        this.reps = a.getReps();
    }

    public int getNumeroAbs() {
        return numeroAbs;
    }

    public void setNumeroAbs(int numeroAbs) {
        this.numeroAbs = numeroAbs;
    }

    public int getReps() {
        return reps;
    }

    public void setReps(int reps) {
        this.reps = reps;
    }

    @Override
    public double calorias() {
        return getDuracao()*getReps()*3/5;
    }

    @Override
    public Abs clone() {
        return new Abs(this);
    }

    @Override
    public String toString() {
        return "Abs{" +
                "numeroAbs=" + numeroAbs +
                ", reps=" + reps +
                '}';
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Abs abs = (Abs) o;
        return Integer.compare(getNumeroAbs(),abs.getNumeroAbs()) == 0 && Integer.compare(getReps(), abs.getReps()) == 0;
    }

}
