
import java.util.HashMap;

public class graphRecorder { // gravador de grafos
    private int nVertices; // numero de vertices
    private HashMap<String, Integer> label; //um relacionamento entre o nome do vertice e seu numero (importante para a criacao da matriz de adjacencia)
    private String[] edge1; // vertices da esquerda das ligacoes
    private String[] edge2; // vertices da direita das ligacoes
    private Float[] grau; // peso das aresta

    public graphRecorder() {
        this(0,null,null,null,null);
    }

    public graphRecorder(int nVertices, HashMap<String, Integer> label, String[] edge1, String[] edge2, Float[] grau) {
        this.nVertices = nVertices;
        this.label = label;
        this.edge1 = edge1;
        this.edge2 = edge2;
        this.grau = grau;
    }

    public int getnVertices() {
        return nVertices;
    }

    public void setnVertices(int nVertices) {
        this.nVertices = nVertices;
    }

    public HashMap<String, Integer> getLabel() {
        return label;
    }

    public void setLabel(HashMap<String, Integer> label) {
        this.label = label;
    }

    public String[] getEdge1() {
        return edge1;
    }

    public void setEdge1(String[] edge1) {
        this.edge1 = edge1;
    }

    public String[] getEdge2() {
        return edge2;
    }

    public void setEdge2(String[] edge2) {
        this.edge2 = edge2;
    }

    public Float[] getGrau() {
        return grau;
    }

    public void setGrau(Float[] grau) {
        this.grau = grau;
    }
}
