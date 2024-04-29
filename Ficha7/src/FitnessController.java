import java.io.*;

public class FitnessController {

    private Fitness fitness;

    public FitnessController() {
        try {
            this.fitness = importador("fitnessBinary");
        }
        catch (ClassNotFoundException | IOException a){
            throw new RuntimeException(a);
        }
    }

    public void shutdown(String filename){
        try {
            this.save("fitnessBinary", this.fitness);
        }
        catch (IOException a){
            throw new RuntimeException(a);
        }
    }

    public void save(String filename, Fitness fitness) throws IOException {
        FileOutputStream file = new FileOutputStream(filename);
        ObjectOutputStream oos = new ObjectOutputStream(file);
        oos.writeObject(fitness);
        oos.flush();
        oos.close();
    }

    public Fitness importador(String filename) throws IOException, ClassNotFoundException {
        FileInputStream file = new FileInputStream(filename);
        ObjectInputStream oos = new ObjectInputStream(file);
        Fitness f1 = (Fitness) oos.readObject();
        return f1;
    }
}
