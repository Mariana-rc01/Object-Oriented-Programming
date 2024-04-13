package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class CasaInteligente {
    private List<Lampada> lampadas;

    public CasaInteligente(){
        this.lampadas = new ArrayList<>();
    }

    public CasaInteligente(List<Lampada> lampadas){
        this.lampadas = new ArrayList<>();
        /*for (Lampada l: lampadas){
            this.lampadas.add(l.clone());
        }*/
        this.lampadas = lampadas.stream().map(Lampada::clone).collect(Collectors.toList());
    }

    public CasaInteligente(CasaInteligente casa){
        this.lampadas = casa.getLampadas();
    }

    public List<Lampada> getLampadas(){
        /*List<Lampada> ret = new ArrayList<>();
        for (Lampada l: this.lampadas){
            ret.add(l.clone());
        }
        return ret;*/
        return this.lampadas.stream().map(Lampada::clone).collect(Collectors.toList());
    }

    public void setLampadas(List<Lampada> l){
        /*this.lampadas = new ArrayList<>();
        for(Lampada ll: l){
            this.lampadas.add(ll.clone());
        }*/
        this.lampadas = l.stream().map(Lampada::clone).collect(Collectors.toList());
    }


    public void addLampada(Lampada l){
        this.lampadas.add(l.clone());
    }

    public void ligaLampadaNormal(int index){
        this.lampadas.get(index).lampON();
    }

    public void ligaLampadaEco(int index){
        this.lampadas.get(index).lampECO();
    }

    public int qtEmEco(){
        /*int qt = 0;
        for (Lampada l: this.lampadas){
            if (l.getModoEco() == true) qt++;
        }
        return qt;*/
        return (int)this.lampadas.stream().filter(l -> l.getModoEco() == true).count();
    }

    public void removeLampada(int index){
        this.lampadas.remove(index);
    }

    public void ligaTodasEco(){
        this.lampadas.forEach(a -> a.setModoEco(true));
        //this.lampadas = this.lampadas.stream().map(a -> {a.setModoEco(true); a.clone();}).collect(Collectors.toList());
    }

    public void ligaTodasMax(){
        this.lampadas.forEach(a -> a.setLigada(true));
    }

    public double consumoTotal(){
        /*double qt = 0;
        for (Lampada l: this.lampadas){
            qt += l.getConsumoTotal();
        }
        return qt;*/

        return this.lampadas.stream().mapToDouble(a -> a.getConsumoTotal()).sum();
    }



    public Lampada maisGastadora(){
        /*double maior = 0;
        Lampada lM = this.lampadas.get(0);
        for (Lampada l: this.lampadas){
            if (l.getConsumoTotal() > maior){
                maior = l.getConsumoTotal();
                lM = l.clone();
            }
        }
        return lM;*/
        return this.lampadas.stream().sorted((l1,l2) -> Double.compare(l2.getConsumoTotal(),l1.getConsumoTotal())).findFirst().get().clone();
    }

    
    public Set<Lampada> lampadasEmModoEco(){
        return this.lampadas.stream().filter(a -> a.getModoEco() == true).map(Lampada::clone).collect(Collectors.toSet());
    }

    public void reset(){
        this.lampadas.forEach(l -> l.resetConsumo());
    }

    public Set<Lampada> podiumEconomia(){
        return this.lampadas.stream().map(Lampada::clone).sorted((l1,l2) -> l1.compareTo(l2)).limit(3).collect(Collectors.toSet());
    }

    public CasaInteligente clone(){
        return new CasaInteligente(this);
    }

    public String toString(){
        return "lampadas " + lampadas.toString();
    }

    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || o.getClass() != this.getClass()) return false;
        CasaInteligente c = (CasaInteligente) o;
        return c.getLampadas().equals(this.lampadas);
    }
}

