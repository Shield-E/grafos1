import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.io.*;

public class fileReader {
    private Scanner input;
    public void openFile(){
        try {
            input = new Scanner( new File("resources/grafo.txt"));
        }
        catch (NoSuchElementException elementException){
            System.err.print("File improperly formed");
            input.close();
            System.exit(1);
        }
        catch (IllegalStateException stateException){
            System.err.print("Error reading from file");
            System.exit(1);
        }
        catch(FileNotFoundException fileNotFoundException){
            System.err.print("File cannot be found");
            System.exit(1);
        }

    }
    /* este atributo serve para ler o arquivo de texto e criar um "gravador de grafo" que interpreta e armazena as
       informacoes dele em atributos para serem usados posteriormente
     */
    public graphRecorder readFile(){
        graphRecorder recorder = new graphRecorder();
        HashMap<String, Integer> labels= new HashMap<>();
        ArrayList<String> edge1s = new ArrayList<String>();
        ArrayList<String> edge2s = new ArrayList<String>();
        ArrayList<Float> graus = new ArrayList<Float>();
        boolean stop = false;
        while(input.hasNext()){
            input.next();
            recorder.setnVertices(input.nextInt());
            for (int i = 0; i < recorder.getnVertices(); i++) {
                int integer1 = input.nextInt();
                String string1 = input.next();
                labels.put(string1, integer1);
            }
            input.next();
            while (input.hasNext()) {
                edge1s.add(input.next());
                edge2s.add(input.next());
                graus.add(input.nextFloat());
            }
        }

        recorder.setLabel(labels);
        recorder.setEdge1(edge1s.toArray(new String[0]));
        recorder.setEdge2(edge2s.toArray(new String[0]));
        recorder.setGrau(graus.toArray(new Float[0]));

        return recorder;
    }

    public void closeFile(){
            if(input != null){
                input.close();
            }
    }

}
