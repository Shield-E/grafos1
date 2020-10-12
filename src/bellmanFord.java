import java.util.*;

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

        List<ArrayList<Integer>> paths = new ArrayList<>();
        dv[vertice-1] = 0;

        Map<Integer, LinkedList<Integer>> path = new HashMap<>();

        for (int i = 0; i < nvert; i++) {
            path.put(i, new LinkedList<>());
        }

        String[] rotu = g.getEdgSrc();
        String[] rotv = g.getEdgDest();
        for (int i = 0; i < nvert - 1; i++){
            for (int j = 0; j < g.numArestas(); j++) {
                int u = g.getLabels().get(rotu[j])-1;
                int v = g.getLabels().get(rotv[j])-1;
                float peso = g.weight(g.rotulo(u+1), g.rotulo(v+1));
                if(dv[u] != Float.POSITIVE_INFINITY && dv[u] + peso < dv[v]){
                    dv[v] = dv[u] + peso;
                    path.get(u).add(v);
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
            System.out.print(i+1 + ":" + path.get(i) +"; d=" + dv[i] + "\n");
        }

    }
}
