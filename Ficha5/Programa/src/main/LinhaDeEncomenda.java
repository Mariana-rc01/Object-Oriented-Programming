package main;
import java.util.Objects;

public class LinhaDeEncomenda {
    private String referencia;
    private String descricao;
    private double precoAntes;
    private int quantidadeE;
    private double imposto;
    private double desconto;

    public LinhaDeEncomenda(){
        this.referencia = "";
        this.descricao = "";
        this.precoAntes = 0;
        this.quantidadeE = 0;
        this.imposto = 0;
        this.desconto = 0;
    }

    public LinhaDeEncomenda(String referencia, String descricao, double precoAntes, int quantidadeE, double imposto, double desconto) {
        this.referencia = referencia;
        this.descricao = descricao;
        this.precoAntes = precoAntes;
        this.quantidadeE = quantidadeE;
        this.imposto = imposto;
        this.desconto = desconto;
    }

    public LinhaDeEncomenda(LinhaDeEncomenda l){
        this.referencia = l.getReferencia();
        this.descricao = l.getDescricao();
        this.precoAntes = l.getPrecoAntes();
        this.quantidadeE = l.getQuantidadeE();
        this.imposto = l.getImposto();
        this.desconto = l.getDesconto();
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPrecoAntes() {
        return precoAntes;
    }

    public void setPrecoAntes(double precoAntes) {
        this.precoAntes = precoAntes;
    }

    public int getQuantidadeE() {
        return quantidadeE;
    }

    public void setQuantidadeE(int quantidadeE) {
        this.quantidadeE = quantidadeE;
    }

    public double getImposto() {
        return imposto;
    }

    public void setImposto(double imposto) {
        this.imposto = imposto;
    }

    public double getDesconto() {
        return desconto;
    }

    public void setDesconto(double desconto) {
        this.desconto = desconto;
    }

    public String toString() {
        return "LinhaDeEncomenda{" +
                "referencia='" + referencia + '\'' +
                ", descricao='" + descricao + '\'' +
                ", precoAntes=" + precoAntes +
                ", quantidadeE=" + quantidadeE +
                ", imposto=" + imposto +
                ", desconto=" + desconto +
                '}';
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        LinhaDeEncomenda that = (LinhaDeEncomenda) o;
        return Double.compare(this.precoAntes, that.getPrecoAntes()) == 0 && this.quantidadeE == that.getQuantidadeE() &&
                Double.compare(this.imposto, that.getImposto()) == 0 && Double.compare(this.desconto, that.getDesconto()) == 0 &&
                Objects.equals(this.referencia, that.getReferencia()) && Objects.equals(this.descricao, that.getDescricao());
    }

    public LinhaDeEncomenda clone(){
        return new LinhaDeEncomenda(this);
    }

    public double calculaValorLinhaEnc(){
        return this.precoAntes * (1 + (this.imposto - this.desconto) / 100) * this.quantidadeE;
    }

    public double calculaValorDesconto(){
        return this.precoAntes * this.desconto / 100;
    }
}
