import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.io.*;

public class fileReader {
    private Scanner input;
    public void openFile(){
        try {
            input = new Scanner( new File("grafo.txt"));

            while(input.hasNext()){

            }
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
        finally{
            if(input != null){
                input.close();
            }
        }
    }

    public graphRecorder readFile(){
        graphRecorder recorder = new graphRecorder();
        ArrayList<String> labels = new ArrayList<String>();
        ArrayList<String> edge1s = new ArrayList<String>();
        ArrayList<String> edge2s = new ArrayList<String>();
        ArrayList<Float> graus = new ArrayList<Float>();

        recorder.setnVertices(input.nextInt());
        input.nextLine();
        while( input.nextLine() != "*edges"){
            int position = input.nextInt() - 1;
            labels.add(position, input.next());
        }
        while(input.hasNext()){
            edge1s.add(input.next());
            edge2s.add(input.next());
            graus.add(input.nextFloat());
        }

        recorder.setLabel(labels.toArray(new String[0]));
        recorder.setEdge1(edge1s.toArray(new String[0]));
        recorder.setEdge2(edge2s.toArray(new String[0]));
        recorder.setGrau(graus.toArray(new Float[0]));

        return recorder;
    }

}
