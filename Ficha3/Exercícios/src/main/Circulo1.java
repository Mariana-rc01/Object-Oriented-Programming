import java.util.Objects;
package main;

public class Circulo1 {
    // Variáveis de instância
    private Ponto centro;
    private double raio;

    /**
     * Construtor por omissão de Circlo.
     */
    public Circulo1(){
        this.centro = new Ponto();
        this.raio = 0;
    }

    /**
     * Construtor parametrizado de Circulo1.
     * Aceita como parâmetros os valores para cada coordenada.
     */
    public Circulo1(Ponto p, double craio){
        this.centro = p.clone();
        this.raio = craio;
    }

    /**
     * Construtor de cópia de Circulo1. Aceita como parâmetro outro Circulo1 e utiliza
     * os métodos de acesso aos valores das variáveis de instância.
     * @param umCirculo1 circulo
     */
    public Circulo1(Circulo1 umCirculo1){
        this.centro = umCirculo1.getCentro();
        this.raio = umCirculo1.getRaio();
    }

    /**
     * Métodos de instância
     */

    /**
     * Devolve o valor da coordenada em x.
     * @return valor da coordenada em x.
     */
    public Ponto getCentro(){
        return this.centro.clone();
    }

    /**
     * Devolve o valor do raio.
     * @return valor do raio.
     */
    public double getRaio(){
        return this.raio;
    }

    /**
     * Atualiza o valor da coordenada em x.
     * @param novo ponto
     */
    public void setCentro(Ponto novo){
        this.centro = novo.clone();
    }

    /**
     * Atualiza o valor do raio.
     * @param novoR raio
     */
    public void setRaio(double novoR){
        this.raio = novoR;
    }

    /**
     * Altera a posição do círculo
     * @param x x
     * @param y y
     */
    public void alteraCentro(double x, double y) {
        this.getCentro().setX((int)x);
        this.getCentro().setY((int)y);
    }

    /**
     * Calcula a area de um Circulo1.
     * @return área do círculo
     */
    public double calculaArea(){
        return (Math.pow(this.raio,2)*Math.PI);
    }

    /**
     * Calcula o perimetro do Circulo1.
     * @return perimetro do Circulo1
     */
    public double calculaPerimetro(){
        return (2*Math.PI*this.raio);
    }

    /**
     * Método que implementa a igualdade entre dois Circulo1s.
     * @param o objeto que é comparado com o recetor da mensagem
     * @return boolean resultado booleano da comparação do parâmetro com o recetor
     */
    public boolean equals(Object o){
        if (this == o) return true;

        if ((o == null) || (this.getClass() != o.getClass())) return false;

        Circulo1 c = (Circulo1) o;
        return (this.centro.equals(c.getCentro()) && this.raio == c.getRaio());
    }

    /**
     * Método que devolve a representação em String do Circulo1.
     * @return String com as coordenadas x e y e raio
     */
    public String toString(){
        return "Centro = " + this.centro + "; Raio = " + this.raio;
    }

    /**
     * Método que faz uma cópia do objecto receptor da mensagem .
     * Para tal invoca o construtor de cópia .
     *
     * @return objecto clone do objecto que recebe a mensagem .
     */
    public Circulo1 clone(){
        return new Circulo1(this);
    }
}
