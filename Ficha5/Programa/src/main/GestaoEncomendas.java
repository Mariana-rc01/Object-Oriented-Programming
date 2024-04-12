package main;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class GestaoEncomendas {
    private Map<Integer, EncEficiente> encomendas;

    public GestaoEncomendas(){
        this.encomendas = new HashMap<>();
    }

    public GestaoEncomendas(Map<Integer,EncEficiente> al){
        this.encomendas = al.values().stream().collect(Collectors.toMap(a -> a.getnEnc(), a -> a.clone()));
    }

    public GestaoEncomendas(GestaoEncomendas al){
        this.encomendas = al.getEncomendas();
    }

    public Map<Integer,EncEficiente> getEncomendas(){
        return this.encomendas.values().stream().collect(Collectors.toMap(a -> a.getnEnc(), a -> a.clone()));
    }

    public void setEncomendas(Map<Integer,EncEficiente> al){
        this.encomendas = al.values().stream().map(a -> a.clone()).collect(Collectors.toMap(a -> a.getnEnc(), a -> a.clone()));
    }

    public GestaoEncomendas clone(){
        return new GestaoEncomendas(this);
    }

    public String toString(){
        return " encomendas: " + encomendas.toString();
    }

    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || o.getClass() != this.getClass()) return false;
        GestaoEncomendas t = (GestaoEncomendas) o;
        return (t.getEncomendas().equals(this.encomendas));
    }

    public Set<Integer> todosCodigosEnc(){
        return new TreeSet<>(this.encomendas.keySet());
    }

    public void addEncomenda(EncEficiente enc){
        this.encomendas.put(enc.getnEnc(), enc.clone());
    }

    public EncEficiente getEncomenda(Integer codEnc){
        if (this.encomendas.containsKey(codEnc)){
            return this.encomendas.get(codEnc).clone();
        }
        else return null;
    }

    public void removeEncomenda(Integer codEnc){
        if (this.encomendas.containsKey(codEnc)){
            this.encomendas.remove(codEnc);
        }
    }

    public Integer encomendaComMaisProdutos(){
        int max = 0;
        Integer M = 0;
        for (EncEficiente enc: this.encomendas.values()){
            if (enc.numeroTotalProdutos() > max){
                max = enc.numeroTotalProdutos();
                M = enc.nEnc;
            }
        }
        return M;
    }

    //ver apartir desta
    public Set<Integer> encomendasComProduto(String codProd){
        return this.encomendas.values().stream().map(EncEficiente::clone).filter(a -> a.existeProdutoEncomenda(codProd) == true).collect(Collectors.toSet());
    }
}
