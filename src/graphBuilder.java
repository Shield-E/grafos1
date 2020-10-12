
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
/*
   esta classe serve para construir um grafo a partir dos dados interpretados pelo graphRecorder
 */
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
        HashMap<String, Integer> labels = recorder.getLabel();
        String[] edg1 = recorder.getEdge1();
        String[] edg2 = recorder.getEdge2();
        /*
            a lista de adjacencia e um hashmap de string e de uma lista de strings, representando um vertice
            e todos os vertices que ele se conecta

            a matriz de adjacencia e um array bidimensional de floats (os pesos das arestas)
         */
        Map<String, List<String>> adjacencyList = new HashMap<>();
        float[][] adjacencyMatrix = new float[vertices][vertices];

        /*
            percorre toda a matriz de adjacencia, seta todas as distancias para infinito, a menos que seja do vertice
            para ele mesmo, neste caso a distancia e 0
         */
        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < vertices; j++) {
                if(i == j){
                    adjacencyMatrix[i][j] = 0;
                } else {
                    adjacencyMatrix[i][j] = Float.POSITIVE_INFINITY;
                }
            }
        }

        for (int i = 0; i < recorder.getEdge1().length; i++) { // percorre todas as ligacoes, edge1.lenght == edge2.lenght sempre, pelo padrao do arquivo
            if (!adjacencyList.containsKey(edg1[i])) { // se a lista ainda nao contem um vertice com o nome do edg1
                adjacencyList.put(edg1[i], new LinkedList<>()); // adiciona o edg1 e uma lista para suas adjacencias
                adjacencyList.get(edg1[i]).add(edg2[i]); // adiciona uma adjacencia a edg1
                adjacencyMatrix[labels.get(edg1[i])-1][labels.get(edg2[i])-1] = recorder.getGrau()[i]; // adiciona o peso de uma aresta para a matriz de adjacencia na posicao padrao do nome dos vertices provenientes do arquivo
            } else {
                adjacencyList.get(edg1[i]).add(edg2[i]); // adiciona uma adjacencia a edg1
                adjacencyMatrix[labels.get(edg1[i])-1][labels.get(edg2[i])-1] = recorder.getGrau()[i]; // adiciona o peso de uma aresta para a matriz de adjacencia na posicao padrao do nome dos vertices provenientes do arquivo
            }
            if(!adjacencyList.containsKey(edg2[i])){
                adjacencyList.put(edg2[i], new LinkedList<>());
                adjacencyList.get(edg2[i]).add(edg1[i]);
                adjacencyMatrix[labels.get(edg2[i])-1][labels.get(edg1[i])-1] = recorder.getGrau()[i];
            } else {
                adjacencyList.get(edg2[i]).add(edg1[i]);
                adjacencyMatrix[labels.get(edg2[i])-1][labels.get(edg1[i])-1] = recorder.getGrau()[i];
            }
        }
        graph g1 = new graph(vertices, adjacencyList, adjacencyMatrix, labels, edg1, edg2); //constroi, finalmente, o grafo
        return g1;
    }
}
