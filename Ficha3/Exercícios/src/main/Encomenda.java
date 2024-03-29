import java.util.Arrays;
import java.util.Objects;

public class Encomenda{
    private String nome;
    private int nFiscal;
    private String morada;
    private int nEncomenda;
    private String data;
    private LinhaDeEncomenda[] encomendas;

    public Encomenda(){
        this.nome = "";
        this.nFiscal = 0;
        this.morada = "";
        this.nEncomenda = 0;
        this.data = "";
        this.encomendas = new LinhaDeEncomenda[0];
    }

    public Encomenda(String nome, int nFiscal, String morada, int nEncomenda, String data, LinhaDeEncomenda[] encomendas) {
        this.nome = nome;
        this.nFiscal = nFiscal;
        this.morada = morada;
        this.nEncomenda = nEncomenda;
        this.data = data;
        this.encomendas = encomendas.clone();
    }

    public Encomenda(Encomenda e){
        this.nome = e.getNome();
        this.nFiscal = e.getnFiscal();
        this.morada = e.getMorada();
        this.nEncomenda = e.getnEncomenda();
        this.data = e.getData();
        this.encomendas = e.getEncomendas().clone();
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

    public LinhaDeEncomenda[] getEncomendas() {
        return encomendas;
    }

    public void setEncomendas(LinhaDeEncomenda[] encomendas) {
        this.encomendas = encomendas;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        Encomenda encomenda = (Encomenda) o;
        return this.nFiscal == encomenda.getnFiscal() && this.nEncomenda == encomenda.getnEncomenda() &&
                Objects.equals(this.nome, encomenda.getNome()) && Objects.equals(this.morada, encomenda.getMorada()) &&
                Objects.equals(this.data, encomenda.getData()) && Arrays.equals(this.encomendas, encomenda.getEncomendas());
    }

    public String toString() {
        return "Encomenda{" +
                "nome='" + nome + '\'' +
                ", nFiscal=" + nFiscal +
                ", morada='" + morada + '\'' +
                ", nEncomenda=" + nEncomenda +
                ", data='" + data + '\'' +
                ", encomendas=" + Arrays.toString(encomendas) +
                '}';
    }

    public Encomenda clone(){
        return new Encomenda(this);
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
        int numero = 0;
        for (LinhaDeEncomenda e : this.encomendas){
            numero += e.getQuantidadeE();
        }
        return numero;
    }

    public boolean existeProdutoEncomenda(String refProfuto){
        boolean resultado = false;
        for (LinhaDeEncomenda e: this.encomendas){
            if (e.getReferencia().equals(refProfuto)) {
                resultado = true;
                break;
            }
        }
        return resultado;
    }

    public void adicionaLinha (LinhaDeEncomenda linha){
        LinhaDeEncomenda[] novoArray = new LinhaDeEncomenda[this.encomendas.length];
        System.arraycopy(this.encomendas,0,novoArray,0,this.encomendas.length);
        novoArray[this.encomendas.length - 1] = linha;
        this.encomendas = novoArray;
    }

    public void removeProduto (String codProd){
        LinhaDeEncomenda[] novoArray = new LinhaDeEncomenda[this.encomendas.length - 1];
        int i = 0;
        for(LinhaDeEncomenda e: this.encomendas){
            if (!e.getReferencia().equals(codProd)){
                novoArray[i] = e;
                i += 1;
            }
        }
        this.encomendas = novoArray;
    }
}
