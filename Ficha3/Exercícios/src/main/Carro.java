import java.util.Objects;

public class Carro {
    private String marca;
    private String modelo;
    private int ano;
    private double consumoPorKm;
    private double kmsTotais;
    private double mediaT;
    private double kmsUltimos;
    private double mediaU;
    private double capacidade;
    private boolean ligado;

    public Carro(){
        this.marca = "";
        this.modelo = "";
        this.ano = 0;
        this.consumoPorKm = 0;
        this.kmsTotais = 0;
        this.mediaT = 0;
        this.kmsUltimos = 0;
        this.mediaU = 0;
        this.capacidade = 0;
        this.ligado = false;
    }

    public Carro(String marca, String modelo, int ano, int consumoPorKm, int kmsTotais, double mediaT, int kmsUltimos, double mediaU, int capacidade, boolean ligado) {
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.consumoPorKm = consumoPorKm;
        this.kmsTotais = kmsTotais;
        this.mediaT = mediaT;
        this.kmsUltimos = kmsUltimos;
        this.mediaU = mediaU;
        this.capacidade = capacidade;
        this.ligado = ligado;
    }

    public Carro(Carro c){
        this.marca = c.getMarca();
        this.modelo = c.getModelo();
        this.ano = c.getAno();
        this.consumoPorKm = c.getConsumoPorKm();
        this.kmsTotais = c.getKmsTotais();
        this.mediaT = c.getMediaT();
        this.kmsUltimos = c.getKmsUltimos();
        this.mediaU = c.getMediaU();
        this.capacidade = c.getCapacidade();
        this.ligado = c.isLigado();
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public double getConsumoPorKm() {
        return consumoPorKm;
    }

    public void setConsumoPorKm(double consumoPorKm) {
        this.consumoPorKm = consumoPorKm;
    }

    public double getKmsTotais() {
        return kmsTotais;
    }

    public void setKmsTotais(double kmsTotais) {
        this.kmsTotais = kmsTotais;
    }

    public double getMediaT() {
        return mediaT;
    }

    public void setMediaT(double mediaT) {
        this.mediaT = mediaT;
    }

    public double getKmsUltimos() {
        return kmsUltimos;
    }

    public void setKmsUltimos(double kmsUltimos) {
        this.kmsUltimos = kmsUltimos;
    }

    public double getMediaU() {
        return mediaU;
    }

    public void setMediaU(double mediaU) {
        this.mediaU = mediaU;
    }

    public double getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(double capacidade) {
        this.capacidade = capacidade;
    }

    public boolean isLigado() {
        return ligado;
    }

    public void setLigado(boolean ligado) {
        this.ligado = ligado;
    }


    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        Carro carro = (Carro) o;
        return this.ano == carro.getAno() && this.consumoPorKm == carro.getConsumoPorKm() &&
                this.kmsTotais == carro.getKmsTotais() && Double.compare(this.mediaT, carro.getMediaT()) == 0
                && this.kmsUltimos == carro.getKmsUltimos() && Double.compare(this.mediaU, carro.getMediaU()) == 0
                && this.capacidade == carro.getCapacidade() && this.ligado == carro.isLigado() &&
                Objects.equals(this.marca, carro.getMarca()) && Objects.equals(this.modelo, carro.getModelo());
    }

    public String toString() {
        return "Carro{" +
                "marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", ano=" + ano +
                ", consumoPorKm=" + consumoPorKm +
                ", kmsTotais=" + kmsTotais +
                ", mediaT=" + mediaT +
                ", kmsUltimos=" + kmsUltimos +
                ", mediaU=" + mediaU +
                ", capacidade de regeneração=" + capacidade +
                ", ligado=" + ligado +
                '}';
    }

    public Carro clone(){
        return new Carro(this);
    }

    public void ligaCarro(){
        this.setLigado(true);
        this.setKmsUltimos(0);
        this.setMediaU(0);
    }

    public void desligaCarro(){
        this.setLigado(false);
    }

    public void resetUltimaViagem(){
        this.setKmsUltimos(0);
        this.setMediaU(0);
    }

    public void avancaCarro(double metros, double velocidade){
        double horas = metros / (velocidade * 1000 / 3600);
        double kmsP = metros * horas;

        this.kmsTotais += kmsP;
        this.kmsUltimos += kmsP;

        double consumoU = this.consumoPorKm * kmsP;

        this.mediaU = consumoU / kmsP;
        this.mediaT = (this.mediaT * (this.kmsTotais - kmsP) + consumoU) / this.kmsTotais;
    }

    public void travaCarro(double metros){
        double consumoTravagem = metros * this.consumoPorKm;
        double regeneracao = metros * this.capacidade;
        double consumoLiquido = consumoTravagem - regeneracao;

        this.kmsTotais += metros;
        kmsUltimos += metros;

        this.mediaU = consumoLiquido / metros;
        this.mediaT = (this.mediaT * (this.kmsTotais - metros) + consumoLiquido) / this.kmsTotais;
    }

}
