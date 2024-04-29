import java.awt.geom.FlatteningPathIterator;
import java.io.*;

public class Main {
    public static void main(String[] args) throws UserNaoExisteException, IOException, ClassNotFoundException {
        FitnessController fitnessController = new FitnessController();
        Fitness f1 = (Fitness) fitnessController.importador("fitnessBinary");
        try { //avalia
            Utilizador user = ((Fitness) f1).getUtilizador("ola");
        }
        catch (UserNaoExisteException e){ // apanha se tiver exceção
            System.out.println("User não existe. " + e.getMessage());
        }
        // caso haja mais do que um catch fazia
        /*
        * catch (OutraExceção a) {
        * }*/
        finally { // termina algo
            System.out.println("terminei");
        }
    }


}