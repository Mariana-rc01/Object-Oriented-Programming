package main;

public class Sensor {
    private double pressao;

    /**
     * Construtores da classe Sensor.
     * Declaração dos construtores por omissão, parametrizado e de cópia.
     */

    /**
     * Construtor por omissão de Sensor.
     */
    public Sensor(){
        this.pressao = 0;
    }

    /**
     * Construtor parametrizado de Sensor.
     * Aceita como parâmetros os valores para cada coordenada.
     */
    public Sensor(double p){
        if (p >= 0) this.pressao = p;
    }

    /**
     * Construtor de cópia de Sensor. Aceita como parâmetro outro Sensor e utiliza
     * os métodos de acesso aos valores das variáveis de instância.
     * @param umSensor
     */
    public Sensor(Sensor umSensor){
        this.pressao = umSensor.getPressao();
    }

    /**
     * Métodos de instância
     */

    /**
     * Devolve o valor da pressao.
     * @return valor da pressao.
     */
    public double getPressao(){
        return this.pressao;
    }

    /**
     * Atualiza o valor da pressão.
     * @param novoP
     */
    public boolean setPressao(double novoP){
        if (novoP >= 0) this.pressao = novoP;
        return (novoP >= 0);
    }

    /**
     * Método que implementa a igualdade entre dois Sensors.
     * @param o objeto que é comparado com o recetor da mensagem
     * @return boolean resultado booleano da comparação do parâmetro com o recetor
     */
    public boolean equals(Object o){
        if (this == o) return true;

        if ((o == null) || (this.getClass() != o.getClass())) return false;

        Sensor s = (Sensor) o;
        return (this.pressao == s.getPressao());
    }

    /**
     * Método que devolve a representação em String do Sensor.
     * @return String com as coordenadas x e y e raio
     */
    public String toString(){
        return "Pressao do sensor = " + this.pressao;
    }

    /**
     * Método que faz uma cópia do objecto receptor da mensagem .
     * Para tal invoca o construtor de cópia .
     *
     * @return objecto clone do objecto que recebe a mensagem .
     */
    public Sensor clone(){
        return new Sensor(this);
    }
}
