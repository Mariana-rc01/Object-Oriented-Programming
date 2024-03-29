package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class EncEficiente {
    private String nome;
    private int nFiscal;
    private String morada;
    private int nEncomenda;
    private String data;
    private List<LinhaDeEncomenda> encomendas;

    public EncEficiente(){
        this.nome = "";
        this.nFiscal = 0;
        this.morada = "";
        this.nEncomenda = 0;
        this.data = "";
        this.encomendas = new ArrayList<>();
    }

    public EncEficiente(String nome, int nFiscal, String morada, int nEncomenda, String data, LinhaDeEncomenda[] encomendas) {
        this.nome = nome;
        this.nFiscal = nFiscal;
        this.morada = morada;
        this.nEncomenda = nEncomenda;
        this.data = data;
        this.encomendas = new ArrayList<>();
        for (LinhaDeEncomenda e : encomendas){
            this.encomendas.add(e.clone());
        }
    }

    public EncEficiente(EncEficiente e){
        this.nome = e.getNome();
        this.nFiscal = e.getnFiscal();
        this.morada = e.getMorada();
        this.nEncomenda = e.getnEncomenda();
        this.data = e.getData();
        this.encomendas = e.getEncomendas();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getnFiscal() {
        return nFiscal;
    }

    public void setnFiscal(int nFiscal) {
        this.nFiscal = nFiscal;
    }

    public String getMorada() {
        return morada;
    }

    public void setMorada(String morada) {
        this.morada = morada;
    }

    public int getnEncomenda() {
        return nEncomenda;
    }

    public void setnEncomenda(int nEncomenda) {
        this.nEncomenda = nEncomenda;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public List<LinhaDeEncomenda> getEncomendas() {
        List<LinhaDeEncomenda> ret = new ArrayList<>();
        for (LinhaDeEncomenda e: this.encomendas){
            this.encomendas.add(e.clone());
        }
        return ret;
    }

    public void setEncomendas(List<LinhaDeEncomenda> encomendas) {
        this.encomendas = new ArrayList<>();
        for (LinhaDeEncomenda e: encomendas){
            this.encomendas.add(e.clone());
        }
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        EncEficiente encomenda = (EncEficiente) o;
        return this.nFiscal == encomenda.getnFiscal() && this.nEncomenda == encomenda.getnEncomenda() &&
                Objects.equals(this.nome, encomenda.getNome()) && Objects.equals(this.morada, encomenda.getMorada()) &&
                Objects.equals(this.data, encomenda.getData()) && encomenda.getEncomendas().equals(this.encomendas);
    }

    public String toString() {
        return "Encomenda{" +
                "nome='" + nome + '\'' +
                ", nFiscal=" + nFiscal +
                ", morada='" + morada + '\'' +
                ", nEncomenda=" + nEncomenda +
                ", data='" + data + '\'' +
                ", encomendas=" + encomendas.toString() +
                '}';
    }

    public EncEficiente clone(){
        return new EncEficiente(this);
    }

    public double calculaValorTotal(){
        double total = 0;
        for (LinhaDeEncomenda e : this.encomendas){
            total += e.calculaValorLinhaEnc();
        }
        return total;
    }

    public double calculaValorDesconto(){
        double descontos = 0;
        for (LinhaDeEncomenda e: this.encomendas){
            descontos += e.calculaValorDesconto();
        }
        return descontos;
    }

    public int numeroTotalProdutos(){
        return this.encomendas.size();
    }

    public boolean existeProdutoEncomenda(String refProduto){
        boolean resultado = false;
        for (LinhaDeEncomenda e: this.encomendas){
            if (e.getReferencia().equals(refProduto)) resultado = true;
        }
        return resultado;
    }

    public void adicionaLinha (LinhaDeEncomenda linha){
        this.encomendas.add(linha.clone());
    }

    public void removeProduto (String codProd){
        for (LinhaDeEncomenda e: this.encomendas){
            if (e.getReferencia().equals(codProd)) {
                this.encomendas.remove(e);
                break;
            }
        }
    }
}

