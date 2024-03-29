package main;

public class Futebol {
    private int golosT; // golos dos visitados
    private int golosV; // golos dos visistantes
    private int estado; // 0 - por iniciar, 1 - a decorrer, 2 - terminado

    public Futebol(){
        this.golosT = 0;
        this.golosV = 0;
        this.estado = 0;
    }

    public Futebol(int golosT, int golosV, int estado) {
        this.golosT = golosT;
        this.golosV = golosV;
        this.estado = estado;
    }

    public Futebol(Futebol f){
        this.golosT = f.getGolosT();
        this.golosV = f.getGolosV();
        this.estado = f.getEstado();
    }

    public int getGolosT() {
        return golosT;
    }

    public void setGolosT(int golosT) {
        this.golosT = golosT;
    }

    public int getGolosV() {
        return golosV;
    }

    public void setGolosV(int golosV) {
        this.golosV = golosV;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        Futebol futebol = (Futebol) o;
        return this.golosT == futebol.getGolosT() && this.golosV == futebol.getGolosV() &&
                this.estado == futebol.getEstado();
    }

    public String toString() {
        return "Futebol{" +
                "golos dos visitados =" + golosT +
                ", golos dos visitantes=" + golosV +
                ", estado do jogo=" + estado +
                '}';
    }

    public Futebol clone(){
        return new Futebol(this);
    }

    public void startGame(){
        if (this.getEstado() == 0) this.setEstado(1);
    }

    public void endGame(){
        if (this.getEstado() == 1) this.setEstado(2);
    }

    public void goloVisitado(){
        if (this.getEstado() == 1) this.setGolosT(this.getGolosT() + 1);
    }

    public void goloVisitante(){
        if (this.getEstado() == 1) this.setGolosV(this.getGolosV() + 1);
    }

    public String resultadoAtual(){
        if (this.getEstado() != 0) return this.toString();
        else return "O jogo ainda não começou";
    }
}
