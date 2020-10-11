public class floydWarshall {
    private graph g;

    public floydWarshall(graph g) {
        this.g = g;
    }

    public void execute(){
        int nvert = g.getnVertices();
        float[][] adj = g.getAdjacencyMatrix();
        float[][] dv = new float[nvert][nvert];
        for (int i = 0; i < nvert; i++) {
            for (int j = 0; j < nvert; j++) {
                dv[i][j] = adj[i][j];
            }
        }
        for (int k = 0; k < nvert; k++) {
            for (int i = 0; i < nvert; i++) {
                for (int j = 0; j < nvert; j++) {
                    if (dv[i][k] + dv[k][j] < dv[i][j]) {
                        dv[i][j] = dv[i][k] + dv[k][j];
                    }
                }
            }
        }
        for (int i = 0; i < nvert; i++) {
            System.out.print(i+1 + ": ");
            for (int j = 0; j < nvert; j++) {
                System.out.print(dv[i][j] + ",");
            }
            System.out.print("\n");
        }
    }
}
