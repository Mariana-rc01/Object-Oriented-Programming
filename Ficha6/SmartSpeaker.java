 

/*********************************************************************************/
/** DISCLAIMER: Este código foi criado e alterado durante as aulas práticas      */
/** de POO. Representa uma solução em construção, com base na matéria leccionada */ 
/** até ao momento da sua elaboração, e resulta da discussão e experimentação    */
/** durante as aulas. Como tal, não deverá ser visto como uma solução canónica,  */
/** ou mesmo acabada. É disponibilizado para auxiliar o processo de estudo.      */
/** Os alunos são encorajados a testar adequadamente o código fornecido e a      */
/** procurar soluções alternativas, à medida que forem adquirindo mais           */
/** conhecimentos de POO.                                                        */
/*********************************************************************************/

/**
 * Um SmartSpeaker é um SmartDevice que além de ligar e desligar permite também
 * reproduzir som.
 * Consegue ligar-se a um canal (por simplificação uma rádio online) e permite
 * a regulação do seu nível de volume.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class SmartSpeaker extends SmartDevice {
    public static final int MAX = 20; //volume máximo
    
    private int volume;
    private String channel;

    /**
     * Constructor for objects of class SmartSpeaker
     */
    public SmartSpeaker() {
        // initialise instance variables
        this.volume = 0;
        this.channel = "";
    }

    public SmartSpeaker(String s) {
        // initialise instance variables
        super(s);
        this.volume = 0;
        this.channel = "";
    }

    public SmartSpeaker(String cod, String channel, int i) {
        // initialise instance variables
        super(cod,true);
        this.volume = i > 0 ? i : 0;
        this.channel = channel;
    }

    public SmartSpeaker(SmartSpeaker s){
        this.setID(s.getID());
        this.setOn(s.getOn());
        this.volume = s.getVolume();
        this.channel = s.getChannel();
    }

    public void volumeUp() {
        if (this.volume<MAX) this.volume++;
    }

    public void volumeDown() {
        if (this.volume>0) this.volume--;
    }

    public int getVolume() {
        return this.volume;
    }
    
    public String getChannel() {
        return this.channel;
    }
    
    public void setChannel(String c) {
        this.channel = c;
    }

    public SmartSpeaker clone(){
        return new SmartSpeaker(this);
    }

}
