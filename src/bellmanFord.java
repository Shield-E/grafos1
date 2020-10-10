import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class bellmanFord {
    private graph g;
    private int vertice;

    public bellmanFord(graph g, int vertice) {
        this.g = g;
        this.vertice = vertice;
    }

    public void execute(){
        int nvert = g.getnVertices();
        float[][] adjMatr = g.getAdjacencyMatrix();

        float[] dv = new float[nvert];
        for (int i = 0; i < nvert; i++) {
            dv[i] = Float.POSITIVE_INFINITY;
        }
        Map<Integer, LinkedList<Integer>> path = new HashMap<>();

        dv[vertice] = 0;

        for (int i = 0; i < nvert; i++) {
            path.put(i, new LinkedList<>());
        }
        for (int i = 0; i < nvert; i++){
            for (int j = 0; j < nvert; j++) {
                for (int k = 0; k < nvert; k++) {
                    if (adjMatr[j][k] != Float.POSITIVE_INFINITY){
                        if (dv[k] > dv[j] + adjMatr[j][k]) {
                            path.get(j).add(k);
                            dv[k] = dv[j] + adjMatr[j][k];
                        }
                    }
                }
            }
        }

        for (int i = 0; i < nvert; i++) {
            for (int j = 0; j < nvert; j++) {
                if (adjMatr[i][j] != Float.POSITIVE_INFINITY){
                    if(dv[j] > dv[i] + adjMatr[i][j]){
                        System.out.print("O grafo possui ciclo negativo");
                    }
                }
            }
        }

        for (int i = 0; i < nvert; i++) {
            System.out.print(g.labels.get(g.rotulo(i)) + ": " + path.get(i) +"; d=" + dv[i] + "\n");
        }

    }
}
