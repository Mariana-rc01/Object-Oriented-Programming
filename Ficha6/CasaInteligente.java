 

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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * A CasaInteligente faz a gestão dos SmartDevices que existem e dos 
 * espaços (as salas) que existem na casa.
 *
 * @author Mariana
 * @version 13.04.2024
 */
public class CasaInteligente {
   
    private String morada;
    private Map<String, SmartDevice> devices; // identificador -> SmartDevice
    private Map<String, List<String>> locations; // Espaço -> Lista codigo dos devices

    /**
     * Constructor for objects of class CasaInteligente
     */
    public CasaInteligente() {
        // initialise instance variables
        this.morada = "";
        this.devices = new HashMap();
        this.locations = new HashMap();
    }

    public CasaInteligente(String morada) {
        // initialise instance variables
        this.morada = morada;
        this.devices = new HashMap();
        this.locations = new HashMap();
    }

    public void setDeviceOn(String devCode) {
        this.devices.get(devCode).turnOn();
    }
    
    public boolean existsDevice(String id) {
        return this.devices.containsKey(id);
    }

    public void addDevice(SmartDevice s) {
        this.devices.put(s.getID(), s.clone());
    }
    
    public SmartDevice getDevice(String s) {
        if(this.devices.containsKey(s)){
            return this.devices.get(s);
        }
        else return null;
    }
    
    public void setOn(String s, boolean b) {
        if (this.devices.containsKey(s)){
            this.devices.get(s).setOn(b);
        }
    }
    
    public void setAllOn(boolean b) {
        for (SmartDevice s: this.devices.values()){
            s.setOn(b);
        }
    }
    
    public void addRoom(String s) {
        List devices = new ArrayList<String>();
        this.locations.put(s, devices);
    }
    
    public boolean hasRoom(String s) {
        if (this.locations.containsKey(s))
            return true;
        else return false;
    }
    
    public void addToRoom (String s1, String s2) {
        if (hasRoom(s1)){
            this.locations.get(s1).add(s2);
        }
    }
    
    public boolean roomHasDevice (String s1, String s2) {
        if (hasRoom(s1) && this.locations.get(s1).contains(s2)) return true;
        return false;
    }
    
}
