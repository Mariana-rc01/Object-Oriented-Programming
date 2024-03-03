import java.util.Arrays;
import java.util.Objects;

public class Telemovel {

    private String marca;
    private String modelo;
    private String display;
    private String[] msgs;
    private int nMsgs;
    private int aMsgs;
    private int aApp;
    private int aFotos;
    private int aTotal = aApp + aFotos;
    private int nBytes;
    private int nFotos;
    private int nApps;
    private String[] apps;

    public Telemovel(){
        this.marca = "";
        this.modelo = "";
        this.display = "";
        this.msgs = new String[0];
        this.aMsgs = 0;
        this.nMsgs = 0;
        this.aTotal = 0;
        this.aFotos = 0;
        this.aApp = 0;
        this.nBytes = 0;
        this.nFotos = 0;
        this.nApps = 0;
        this.apps = new String[0];
    }

    public Telemovel(String marca, String modelo, String display, String[] msgs, int nMsgs, int aFotos, int aMsgs, int aTotal, int aApp, int nBytes, int nFotos, int nApps, String[] apps) {
        this.marca = marca;
        this.modelo = modelo;
        this.display = display;
        this.msgs = msgs;
        this.nMsgs = nMsgs;
        this.aMsgs = aMsgs;
        this.aTotal = aTotal;
        this.aApp = aApp;
        this.aFotos = aFotos;
        this.nBytes = nBytes;
        this.nFotos = nFotos;
        this.nApps = nApps;
        this.apps = apps;
    }

    public Telemovel(Telemovel t){
        this.marca = t.getMarca();
        this.modelo = t.getModelo();
        this.display = t.getDisplay();
        this.msgs = t.getMsgs();
        this.nMsgs = t.getnMsgs();
        this.aMsgs = t.getaMsgs();
        this.aTotal = t.getaTotal();
        this.aApp = t.getaApp();
        this.aFotos = t.getaFotos();
        this.nBytes = t.getnBytes();
        this.nFotos = t.getnFotos();
        this.nApps = t.getnApps();
        this.apps = t.getApps();
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

    public String getDisplay() {
        return display;
    }

    public void setDisplay(String display) {
        this.display = display;
    }

    public String[] getMsgs() {
        return msgs;
    }

    public void setMsgs(String[] msgs) {
        this.msgs = msgs;
    }

    public int getaTotal() {
        return aTotal;
    }

    public void setaTotal(int aTotal) {
        this.aTotal = aTotal;
    }

    public int getaApp() {
        return aApp;
    }

    public void setaApp(int aApp) {
        this.aApp = aApp;
    }

    public int getnBytes() {
        return nBytes;
    }

    public void setnBytes(int nBytes) {
        this.nBytes = nBytes;
    }

    public int getnFotos() {
        return nFotos;
    }

    public void setnFotos(int nFotos) {
        this.nFotos = nFotos;
    }

    public int getnApps() {
        return nApps;
    }

    public void setnApps(int nApps) {
        this.nApps = nApps;
    }

    public String[] getApps() {
        return apps;
    }

    public void setApps(String[] apps) {
        this.apps = apps;
    }

    public int getaMsgs() {
        return aMsgs;
    }

    public void setaMsgs(int aMsgs) {
        this.aMsgs = aMsgs;
    }

    public int getaFotos() {
        return aFotos;
    }

    public void setaFotos(int aFotos) {
        this.aFotos = aFotos;
    }

    public int getnMsgs() {
        return nMsgs;
    }

    public void setnMsgs(int nMsgs) {
        this.nMsgs = nMsgs;
    }

    public String toString() {
        return "Telemovel{" +
                "marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", display='" + display + '\'' +
                ", msgs=" + Arrays.toString(msgs) +
                ", aTotal=" + aTotal +
                ", aApp=" + aApp +
                ", nBytes=" + nBytes +
                ", nFotos=" + nFotos +
                ", nApps=" + nApps +
                ", apps=" + Arrays.toString(apps) +
                '}';
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Telemovel telemovel = (Telemovel) o;
        return aTotal == telemovel.aTotal && aApp == telemovel.aApp
                && nBytes == telemovel.nBytes && nFotos == telemovel.nFotos
                && nApps == telemovel.nApps && Objects.equals(marca, telemovel.marca)
                && Objects.equals(modelo, telemovel.modelo) &&
                Objects.equals(display, telemovel.display) &&
                Arrays.equals(msgs, telemovel.msgs) && Arrays.equals(apps, telemovel.apps);
    }

    public boolean existeEspaco(int numeroBytes){
        return (numeroBytes + this.nBytes < this.aTotal + this.aMsgs);
    }
    public void instalaApp(String nome, int tamanho){
        this.aApp += tamanho;
        this.nBytes += tamanho;
        this.nApps += 1;
        String[] novoArray = new String[this.nApps];
        System.arraycopy(this.apps,0,novoArray,0,this.nApps);
        novoArray[this.nApps-1] = nome;
        this.apps = novoArray;
    }

    public void recebeMsg(String msg){
        this.nBytes += msg.length();
        this.aMsgs += 1;
        String[] novoArray = new String[this.aMsgs];
        System.arraycopy(this.msgs,0,novoArray,0,this.aMsgs);
        novoArray[this.nMsgs - 1] = msg;
        this.msgs = novoArray;
    }

    public double tamMedioApps(){
        return this.aApp / this.nApps;
    }

    public String maiorMsg(){
        int m = 0;
        String maior = "";
        for(String s : this.msgs){
            if (s.length() > m) {
                maior = s;
                m = s.length();
            }
        }
        return maior;
    }

    public void removeApp(String nome, int tamanho){
        this.aApp -= tamanho;
        this.nBytes -= tamanho;
        this.nApps -= 1;
        String[] novoArray = new String[this.nApps];
        int i = 0;
        for(String s: this.apps){
            if (!s.equals(nome)){
                novoArray[i] = s;
                i += 1;
            }
        }
        this.apps = novoArray;
    }
}
