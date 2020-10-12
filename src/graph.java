import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class graph { // um grafo
    private int nVertices;
    Map<String, List<String>> adjacencyList = new HashMap<>();
    float[][] adjacencyMatrix;
    HashMap<String, Integer> labels;
    String[] edgSrc;
    String[] edgDest;

    public graph(int nVertices, Map<String, List<String>> adjacencyList, float[][] adjacencyMatrix, HashMap<String, Integer> labels, String[] edgSrc, String[] edgDest) {
        this.nVertices = nVertices;
        this.adjacencyList = adjacencyList;
        this.adjacencyMatrix = adjacencyMatrix;
        this.labels = labels;
        this.edgSrc = edgSrc;
        this.edgDest = edgDest;
    }

    public int getnVertices() {
        return nVertices;
    }

    public void setnVertices(int nVertices) {
        this.nVertices = nVertices;
    }

    public Map<String, List<String>> getAdjacencyList() {
        return adjacencyList;
    }

    public void setAdjacencyList(Map<String, List<String>> adjacencyList) {
        this.adjacencyList = adjacencyList;
    }

    public float[][] getAdjacencyMatrix() {
        return adjacencyMatrix;
    }

    public void setAdjacencyMatrix(float[][] adjacencyMatrix) {
        this.adjacencyMatrix = adjacencyMatrix;
    }

    public HashMap<String, Integer> getLabels() {
        return labels;
    }

    public void setLabels(HashMap<String, Integer> labels) {
        this.labels = labels;
    }

    public String[] getEdgSrc() {
        return edgSrc;
    }

    public void setEdgSrc(String[] edgSrc) {
        this.edgSrc = edgSrc;
    }

    public String[] getEdgDest() {
        return edgDest;
    }

    public void setEdgDest(String[] edgDest) {
        this.edgDest = edgDest;
    }

    public int numArestas(){
        int acc = 0;
        for (int i = 0; i < nVertices; i++) {
            for (int j = 0; j < nVertices; j++) {
                if(adjacencyMatrix[i][j]>0 && adjacencyMatrix[i][j]<Float.POSITIVE_INFINITY){
                    acc++;
                }
            }
        }
        return acc/2;
    }
    public int grau(String x){
        int degree = adjacencyList.get(x).size();
        return degree;
    }

    public String rotulo(int x){
        Map<Integer, String> swapped = labels.entrySet().stream().collect(Collectors.toMap(Map.Entry::getValue, Map.Entry::getKey));
        return swapped.get(x);
    }

    public List<String> neighbours(String x){
        return adjacencyList.get(x);
    }

    public boolean arestaExists(String x, String y){
        if(adjacencyMatrix[labels.get(x)-1][labels.get(y)-1]>0 && adjacencyMatrix[labels.get(x)-1][labels.get(y)-1]<Float.POSITIVE_INFINITY){
            return true;
        } else {
            return false;
        }
    }

    public float weight(String x, String y){
        return adjacencyMatrix[labels.get(x)-1][labels.get(y)-1];
    }
}
