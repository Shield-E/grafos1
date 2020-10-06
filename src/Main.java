public class Main {
    public static void main(String[] args){

        fileReader leitor = new fileReader();
        leitor.openFile();

        graphRecorder gravador = leitor.readFile();
        graphBuilder BobOConstrutor = new graphBuilder(gravador);

        graph meuGrafo = BobOConstrutor.build(gravador);

        System.out.print("Lista de adjacencia: \n" + meuGrafo.adjacencyList + "\n" + "\n");

        System.out.print("Matriz de adjacencia: \n");
        for (int i = 0; i < meuGrafo.adjacencyMatrix.length; i++) {
            for (int j = 0; j < meuGrafo.adjacencyMatrix.length; j++) {
                System.out.print(meuGrafo.adjacencyMatrix[i][j] + " ");
            }
            System.out.print("\n");
        }
        System.out.print("\n");

        System.out.print("Numero de vertices: " + meuGrafo.getnVertices() + "\n");

        System.out.print("Numero de arestas: " + meuGrafo.numArestas() + "\n");

        System.out.print("grau do vertice b: " + meuGrafo.grau("b") + "\n");

        System.out.print("Rotulo do terceiro vertice: " + meuGrafo.rotulo(3) + "\n");

        System.out.print("vizinhos do vertice c: " + meuGrafo.neighbours("c") + "\n");

        System.out.print("existe aresta c-d ?: " + meuGrafo.arestaExists("c", "d") + "\n");

        System.out.print("existe aresta c-a ?: " + meuGrafo.arestaExists("c", "a") + "\n");

        System.out.print("peso da aresta c-d: " + meuGrafo.weight("c", "d") + "\n");
        System.out.print("peso da aresta c-a: " + meuGrafo.weight("c", "a") + "\n");

        leitor.closeFile();

    }
}
