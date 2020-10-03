import java.util.HashMap;
import java.util.Map;
public class graphBuilder {
    private graphRecorder recorder;

    public graphBuilder(graphRecorder recorder) {
        this.recorder = recorder;
    }

    public graphRecorder getRecorder() {
        return recorder;
    }

    public void setRecorder(graphRecorder recorder) {
        this.recorder = recorder;
    }

    public graph build(graphRecorder recorder){
        int vertices = recorder.getnVertices();
        String[] labels = recorder.getLabel();
        String[] edg1 = recorder.getEdge1();
        String[] edg2 = recorder.getEdge2();
        Map<String, String> arestas = new HashMap<String, String>();
        for (int i = 0; i < recorder.getEdge1().length; i++) {
            arestas.put(edg1[i], edg2[i]);
        }
        arestas.
    }
}
