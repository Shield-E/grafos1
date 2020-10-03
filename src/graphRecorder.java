
public class graphRecorder {
    private int nVertices;
    private String[] label;
    private String[] edge1;
    private String[] edge2;
    private Float[] grau;

    public graphRecorder() {
        this(0,null,null,null,null);
    }

    public graphRecorder(int nVertices, String[] label, String[] edge1, String[] edge2, Float[] grau) {
        setnVertices(nVertices);
        setLabel(label);
        setEdge1(edge1);
        setEdge2(edge2);
        setGrau(grau);
    }

    public int getnVertices() {
        return nVertices;
    }

    public void setnVertices(int nVertices) {
        this.nVertices = nVertices;
    }

    public String[] getLabel() {
        return label;
    }

    public void setLabel(String[] label) {
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
