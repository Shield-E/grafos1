import java.util.HashMap;
import java.util.Map;

public class graph {
    private int nVertices;
    private String[] labels;
    Map<String, String> arestas = new HashMap<String, String>(); // hashmap deve ser usado para implementar a matriz de adjacencia
    Map<Map<String, String>, Float> graus = new HashMap<Map<String, String>, Float>();

    public graph(int nVertices, String[] labels, Map<String, String> arestas, Map<Map<String, String>, Float> graus) {
        this.nVertices = nVertices;
        this.labels = labels;
        this.arestas = arestas;
        this.graus = graus;
    }

    public int getnVertices() {
        return nVertices;
    }

    public void setnVertices(int nVertices) {
        this.nVertices = nVertices;
    }

    public String[] getLabels() {
        return labels;
    }

    public void setLabels(String[] labels) {
        this.labels = labels;
    }

    public Map<String, String> getArestas() {
        return arestas;
    }

    public void setArestas(Map<String, String> arestas) {
        this.arestas = arestas;
    }

    public Map<Map<String, String>, Float> getGraus() {
        return graus;
    }

    public void setGraus(Map<Map<String, String>, Float> graus) {
        this.graus = graus;
    }
}
