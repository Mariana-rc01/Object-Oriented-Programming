import java.util.Objects;

public class Triangulo {
    private Ponto p1;
    private Ponto p2;
    private Ponto p3;

    public Triangulo(){
        this.p1 = new Ponto();
        this.p2 = new Ponto();
        this.p3 = new Ponto();
    }

    public Triangulo(Ponto p1, Ponto p2, Ponto p3) {
        this.p1 = p1.clone();
        this.p2 = p2.clone();
        this.p3 = p3.clone();
    }

    public Triangulo(Triangulo t){
        this.p1 = t.getP1();
        this.p2 = t.getP2();
        this.p3 = t.getP3();
    }

    public Ponto getP1() {
        return p1.clone();
    }

    public void setP1(Ponto p1) {
        this.p1 = p1.clone();
    }

    public Ponto getP2() {
        return p2.clone();
    }

    public void setP2(Ponto p2) {
        this.p2 = p2.clone();
    }

    public Ponto getP3() {
        return p3.clone();
    }

    public void setP3(Ponto p3) {
        this.p3 = p3.clone();
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        Triangulo triangulo = (Triangulo) o;
        return Objects.equals(this.p1, triangulo.getP1()) && Objects.equals(this.p2, triangulo.getP2()) && Objects.equals(this.p3, triangulo.getP3());
    }

    public String toString() {
        return "Triangulo{" +
                "p1=" + p1 +
                ", p2=" + p2 +
                ", p3=" + p3 +
                '}';
    }

    public Triangulo clone(){
        return new Triangulo(this);
    }

    // como não sabemos se é equilátero ou retângulo ou escaleno, usamos uma formula mais geral que é
    // A = sqrt(p * (p - dist1) * (p - dist2) * (p - dist3)), com p = (dist1 + dist2 + dist3) / 2
    public double calculaAreaTriangulo(){
        double area = 0;
        double p = this.calculaPerimetroTriangulo() / 2;
        area = Math.sqrt(p * (p - this.getP1().distancia(getP2())) *
                (p - this.getP2().distancia(getP3())) *
                (p - this.getP3().distancia(getP1())));
        return area;
    }

    public double calculaPerimetroTriangulo(){
        return this.getP1().distancia(getP2()) +
                this.getP2().distancia(getP3()) +
                this.getP3().distancia(getP1());
    }

    public double calculaAlturaTriangulo(){
        double menory = this.getP1().getY();
        double maiory = this.getP1().getY();
        double[] ys = {this.getP1().getY(), this.getP2().getY(), this.getP3().getY()};
        for (double y: ys){
            if (y < menory) menory = y;
            else if (y > maiory) maiory = y;
        }
        return maiory - menory;
    }
}
