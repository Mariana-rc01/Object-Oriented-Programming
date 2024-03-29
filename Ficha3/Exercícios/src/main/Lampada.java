import java.util.Objects;

public class Lampada {
    private boolean ligada;
    private boolean modoEco;
    private double consumoPorMilissegundo; // caracteristica da lâmpada
    private long ultimoResetTempo;
    private double consumoTotal;

    public Lampada(){
        this.ligada = false;
        this.modoEco = false;
        this.consumoPorMilissegundo = 0;
        this.ultimoResetTempo = System.currentTimeMillis();
        this.consumoTotal = 0;
    }

    public Lampada(boolean ligada, boolean modoEco, double consumoPorMilissegundo, long ultimoResetTempo, double consumoTotal) {
        this.ligada = ligada;
        this.modoEco = modoEco;
        this.consumoPorMilissegundo = consumoPorMilissegundo;
        this.ultimoResetTempo = ultimoResetTempo;
        this.consumoTotal = consumoTotal;
    }

    public Lampada(Lampada l){
        this.ligada = l.getLigada();
        this.modoEco = l.getModoEco();
        this.consumoPorMilissegundo = l.getConsumoPorMilissegundo();
        this.ultimoResetTempo = l.getUltimoResetTempo();
        this.consumoTotal = l.getConsumoTotal();
    }

    public Lampada clone(){
        return new Lampada(this);
    }

    public boolean getLigada() {
        return ligada;
    }

    public void setLigada(boolean ligada) {
        this.ligada = ligada;
    }

    public boolean getModoEco() {
        return modoEco;
    }

    public void setModoEco(boolean modoEco) {
        this.modoEco = modoEco;
    }

    public double getConsumoPorMilissegundo() {
        return consumoPorMilissegundo;
    }

    public void setConsumoPorMilissegundo(double consumoPorMilissegundo) {
        this.consumoPorMilissegundo = consumoPorMilissegundo;
    }

    public long getUltimoResetTempo() {
        return ultimoResetTempo;
    }

    public void setUltimoResetTempo(long ultimoResetTempo) {
        this.ultimoResetTempo = ultimoResetTempo;
    }

    public double getConsumoTotal() {
        return consumoTotal;
    }

    public void setConsumoTotal(double consumoTotal) {
        this.consumoTotal = consumoTotal;
    }

    public String toString() {
        return "Lampada{" +
                "ligada=" + ligada +
                ", modoEco=" + modoEco +
                ", consumoPorMilissegundo=" + consumoPorMilissegundo +
                ", ultimoResetTempo=" + ultimoResetTempo +
                ", consumoTotal=" + consumoTotal +
                '}';
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        Lampada lampada = (Lampada) o;
        return this.ligada == lampada.getLigada() && this.modoEco == lampada.getModoEco() &&
                Double.compare(this.consumoPorMilissegundo, lampada.getConsumoPorMilissegundo()) == 0
                && this.ultimoResetTempo == lampada.getUltimoResetTempo() &&
                Double.compare(this.consumoTotal, lampada.getConsumoTotal()) == 0;
    }

    public void lampON(){
        this.setLigada(true);
        this.setModoEco(false);
    }

    public void lampOFF(){
        this.setLigada(false);
        this.setModoEco(false);
    }

    public void lampECO(){
        this.setModoEco(true);
        this.setLigada(false);
    }

    public double totalConsumo(){
        return this.getConsumoTotal();
    }

    public void resetConsumo() {
        long tempoAtual = System.currentTimeMillis();
        long periodo = tempoAtual - this.ultimoResetTempo;

        if (this.ligada){
            this.consumoTotal += consumoPorMilissegundo * periodo;
        }
        else if (this.modoEco) {
            this.consumoTotal += consumoPorMilissegundo * periodo/2;
        }

        this.ultimoResetTempo = tempoAtual;
    }

    public double periodoConsumo() {
        long tempoAtual = System.currentTimeMillis();
        long periodo = tempoAtual - ultimoResetTempo;

        double consumo = 0;
        if (ligada){
            consumo = consumoPorMilissegundo * periodo;
        }
        else if (this.modoEco) {
            consumo += consumoPorMilissegundo * periodo/2;
        }

        consumoTotal += consumo;
        ultimoResetTempo = tempoAtual;

        return consumo;
    }

}
