package main;

/**
 * Classe que implementa um Circulo num plano 2D.
 * As coordenadas e o raio do Circlo são doubles.
 *
 * @author Mariana
 */

public class Circulo {
    // Variáveis de instância
    private double x;
    private double y;
    private double raio;

    /**
     * Construtores da classe Circulo.
     * Declaração dos construtores por omissão, parametrizado e de cópia.
     */

    /**
     * Construtor por omissão de Circlo.
     */
    public Circulo(){
        this.x = 0;
        this.y = 0;
        this.raio = 0;
    }

    /**
     * Construtor parametrizado de Circulo.
     * Aceita como parâmetros os valores para cada coordenada.
     */
    public Circulo(double cx, double cy, double craio){
        this.x = cx;
        this.y = cy;
        this.raio = craio;
    }

    /**
     * Construtor de cópia de Circulo. Aceita como parâmetro outro Circulo e utiliza
     * os métodos de acesso aos valores das variáveis de instância.
     * @param umCirculo
     */
    public Circulo(Circulo umCirculo){
        this.x = umCirculo.getX();
        this.y = umCirculo.getY();
        this.raio = umCirculo.getRaio();
    }

    /**
     * Métodos de instância
     */

    /**
     * Devolve o valor da coordenada em x.
     * @return valor da coordenada em x.
     */
    public double getX(){
        return this.x;
    }

    /**
     * Devolve o valor da coordenada em y.
     * @return valor da coordenada em y.
     */
    public double getY(){
        return this.y;
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
     * @param novoX
     */
    public void setX(double novoX){
        this.x = novoX;
    }

    /**
     * Atualiza o valor da coordenada em y.
     * @param novoY
     */
    public void setY(double novoY){
        this.y = novoY;
    }

    /**
     * Atualiza o valor do raio.
     * @param novoR
     */
    public void setRaio(double novoR){
        this.raio = novoR;
    }

    /**
     * Altera a posição do círculo
     * @param x
     * @param y
     */
    public void alteraCentro(double x, double y){
        this.setX(x);
        this.setY(y);
    }

    /**
     * Calcula a area de um circulo.
     * @return área do círculo
     */
    public double calculaArea(){
        return (Math.pow(this.raio,2)*Math.PI);
    }

    /**
     * Calcula o perimetro do circulo.
     * @return perimetro do circulo
     */
    public double calculaPerimetro(){
        return (2*Math.PI*this.raio);
    }

    /**
     * Método que implementa a igualdade entre dois circulos.
     * @param o objeto que é comparado com o recetor da mensagem
     * @return boolean resultado booleano da comparação do parâmetro com o recetor
     */
    public boolean equals(Object o){
        if (this == o) return true;

        if ((o == null) || (this.getClass() != o.getClass())) return false;

        Circulo c = (Circulo) o;
        return (this.x == c.getX() && this.y == c.getY() && this.raio == c.getRaio());
    }

    /**
     * Método que devolve a representação em String do Circulo.
     * @return String com as coordenadas x e y e raio
     */
    public String toString(){
        return "Cx = " + this.x + "; Cy = " + this.y + "; Craio = " + this.raio;
    }

    /**
     * Método que faz uma cópia do objecto receptor da mensagem .
     * Para tal invoca o construtor de cópia .
     *
     * @return objecto clone do objecto que recebe a mensagem .
     */
    public Circulo clone(){
        return new Circulo(this);
    }
}
