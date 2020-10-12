import java.util.ArrayList;
import java.util.HashMap;

public class BuscaLargura {
    private boolean[] visitado; //Cv
    private int[] distancia; //Dv

    public BuscaLargura(graph meuGrafo, int raiz){
        visitado = new boolean[meuGrafo.getnVertices()];
        distancia = new int[meuGrafo.getnVertices()];

        //configurando todos os vertices
        for(int i = 0; i < visitado.length; i++) {
            visitado[i] = false;
            distancia[i] = -1;
        }

        visitado[raiz] = true;
        distancia[raiz] = 0;

        ArrayList<String> fila = new ArrayList<String>(meuGrafo.getnVertices());
        String u = meuGrafo.rotulo(raiz);

        fila.add(u);
        while(fila.size() > 0) {
            u = fila.remove(0);

            for(int i = 0; i < meuGrafo.getAdjacencyList().get(u).size(); i++) {
                String aux = meuGrafo.getAdjacencyList().get(u).get(i); // retorna o vertice da lista de adjacencia de u no indice i
                if(visitado[meuGrafo.getLabels().get(aux)] = false) {
                    visitado[meuGrafo.getLabels().get(aux)] = true;
                    distancia[meuGrafo.getLabels().get(aux)] = distancia[meuGrafo.getLabels().get(u)] + 1;
                    fila.add(aux);
                }
            }
        }
    }

    public void imprime(graph meuGrafo){
        int[][] matrizDeNivel = new int[meuGrafo.getnVertices()][meuGrafo.getnVertices()];
        for(int i = 0; i < meuGrafo.getnVertices(); i++) {
            int coluna = 0;
            for(int j = 0; j < distancia.length; j++) {
                if(distancia[j] == i) {
                    matrizDeNivel[distancia[j]][coluna] = j;
                    coluna++;
                }
            }
        }
        int i = 0;
        int j;
        while(matrizDeNivel[i][0] != 0) {
            j = 0;
            while(matrizDeNivel[i][j] != 0) {
                System.out.print(matrizDeNivel[i][j]);
                if(matrizDeNivel[i][j + 1] != 0)
                    System.out.print(",");
                else
                    System.out.println();
                j++;
            }
            i++;
        }
    }
}
