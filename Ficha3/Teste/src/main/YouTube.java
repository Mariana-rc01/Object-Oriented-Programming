package main;

import java.time.Duration;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class YouTube {

    private String nome;
    private byte[] conteudo;
    private LocalDate data;
    private String display;
    private Duration duracao;
    private List<String> comentarios;
    private int contLikes;
    private int contDislikes;

    public YouTube() {
        this.nome = "";
        this.conteudo = new byte[0];
        this.data = LocalDate.now();
        this.display = "";
        this.duracao = Duration.ZERO;
        this.comentarios = new ArrayList<>();
        this.contLikes = 0;
        this.contDislikes = 0;
    }

    public YouTube(String nomeDoVideo, byte[] conteudoDoVideo, LocalDate dataDeCarregamento,
    String resolucao, Duration duracao, List<String> comentarios, int contadorLikes, int contadorDislikes) {
        this.conteudo = conteudoDoVideo;
        this.nome = nomeDoVideo;
        this.display = resolucao;
        this.data = dataDeCarregamento;
        this.comentarios = comentarios;
        this.duracao = duracao;
        this.contDislikes = contadorDislikes;
        this.contLikes = contadorLikes;
    }

    public YouTube(YouTube y){
        this.conteudo = y.getConteudo();
        this.nome = y.getNome();
        this.display = y.getDisplay();
        this.data = y.getData();
        this.comentarios = y.getComentarios();
        this.duracao = y.getDuracao();
        this.contDislikes = y.getContDislikes();
        this.contLikes = y.getContLikes();
    }

    /**
     * @return String return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return byte[] return the conteudo
     */
    public byte[] getConteudo() {
        return conteudo;
    }

    /**
     * @param conteudo the conteudo to set
     */
    public void setConteudo(byte[] conteudo) {
        this.conteudo = conteudo;
    }

    /**
     * @return LocalDate return the data
     */
    public LocalDate getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(LocalDate data) {
        this.data = data;
    }

    /**
     * @return String return the display
     */
    public String getDisplay() {
        return display;
    }

    /**
     * @param display the display to set
     */
    public void setDisplay(String display) {
        this.display = display;
    }

    /**
     * @return Duration return the duracao
     */
    public Duration getDuracao() {
        return duracao;
    }

    /**
     * @param duracao the duracao to set
     */
    public void setDuracao(Duration duracao) {
        this.duracao = duracao;
    }

    /**
     * @return List<String> return the comentarios
     */
    public List<String> getComentarios() {
        return comentarios;
    }

    /**
     * @param comentarios the comentarios to set
     */
    public void setComentarios(List<String> comentarios) {
        this.comentarios = comentarios;
    }

    /**
     * @return int return the contLikes
     */
    public int getContLikes() {
        return contLikes;
    }

    /**
     * @param contLikes the contLikes to set
     */
    public void setContLikes(int contLikes) {
        this.contLikes = contLikes;
    }

    /**
     * @return int return the contDislikes
     */
    public int getContDislikes() {
        return contDislikes;
    }

    /**
     * @param contDislikes the contDislikes to set
     */
    public void setContDislikes(int contDislikes) {
        this.contDislikes = contDislikes;
    }

    public YouTube clone(){
        return new YouTube(this);
    }

    public boolean equals (Object o){
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        YouTube y = (YouTube) o;
        return this.getNome().equals(y.getNome()); //....
    }

    public String toString(){
        return "nome: " + nome; //....
    }

    public void insereComentario(String comentario){
        comentarios = this.getComentarios();
        comentarios.add(comentario);
        this.setComentarios(comentarios);
    }

    public long qtsDiasDepois(){
        long now = LocalDate.now().toEpochDay();
        long before = this.getData().toEpochDay();
        return  now - before;
    }

    public void thumbsUp(){
        this.setContLikes(this.getContLikes() + 1);
    }

    public String processa(){
        return this.toString();
    }
}
