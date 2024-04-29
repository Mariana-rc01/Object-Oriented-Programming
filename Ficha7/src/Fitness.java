import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Fitness{

    private Map<String, Utilizador> users;
    private Map<String,Atividade> atividades;

    public Fitness(){
        this.atividades = new HashMap<>();
        this.users = new HashMap<>();
    }
    public boolean existeUtilizador(String email){
        return this.users.containsKey(email);
    }

    public int quantos(){
        return this.users.size();
    }

    public int quantos(String actividade, String email){
        return (int) this.atividades.values().stream().filter(Atividade -> Atividade.getUser().getEmail().equals(email)).filter(Atividade->Atividade.getCodigo().equals(actividade)).count();
    }

    public Utilizador getUtilizador(String email) throws UserNaoExisteException { //ali metia vírgula para incluir a outra classe de exceção
        /*
        * E aqui tentava outra coisa e mandava para outro throw */
        if (existeUtilizador(email)){
            return this.users.get(email).clone();
        }
        else {
            throw new UserNaoExisteException();

        }
    }

    public void adicionarUtilizador(Utilizador user) throws UserJaExisteException{
        if (!existeUtilizador(user.getEmail())){
            this.users.put(user.getEmail(),user);
        }
        else {
            throw new UserJaExisteException();
        }
    }

    public Utilizador UtilizadorComMaisRegistos(){
        return users.values().stream().max(Comparator.comparingInt(u -> u.getAtividades().size())).orElse(null);
    }

    /*public Utilizador UtilizadorComMaisRegistos1 implements Comparator<Utilizador>(){
        public int compare(Utilizador u1, Utilizador u2){
            if(u1.getAtividades().values().size() > u2.getAtividades().values().size()){
                return -1;
            }
            else{
                return u1.getAtividades().values().stream().map(Atividade::getData).sorted().findFirst().get.compareTo(
                    u1.get
                )
            }
        }
    }*/

    public Set<Utilizador> ordenarUtilizadores(){
        return users.values().stream().map(Utilizador::clone).collect(TreeSet());
    }

    public List<Utilizador> ordenarUtilizadores1(){
        return users.values().stream().map(Utilizador::clone).collect(Collectors.toList());
    }

    public List<FazMetros> daoPontos(){
        return atividades.values().stream().map(Atividade::clone).filter(a -> a instanceof FazMetros).map(a -> (FazMetros) a).collect(Collectors.toList());
    }
}
