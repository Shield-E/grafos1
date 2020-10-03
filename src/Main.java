public class Main {
    public static void main(String[] args){

        fileReader leitor = new fileReader();
        leitor.openFile();

        graphRecorder gravador = leitor.readFile();
        graphBuilder BobOConstrutor = new graphBuilder(gravador);

        graph meuGrafo = BobOConstrutor.build(gravador);

        for (int i = 0; i < meuGrafo.adjacencyMatrix.length; i++) {
            for (int j = 0; j < meuGrafo.adjacencyMatrix.length; j++) {
                System.out.print(meuGrafo.adjacencyMatrix[i][j] + " ");
            }
            System.out.print("\n");
        }


        System.out.print(meuGrafo.getnVertices() + "\n");

        System.out.print(meuGrafo.numArestas() + "\n");

        System.out.print(meuGrafo.grau("c") + "\n");

        System.out.print(meuGrafo.rotulo(3) + "\n");

        System.out.print(meuGrafo.neighbours("c") + "\n");

        System.out.print(meuGrafo.arestaExists("c", "d") + "\n");

        System.out.print(meuGrafo.arestaExists("c", "a") + "\n");

        System.out.print(meuGrafo.weight("c", "d") + "\n");

        leitor.closeFile();

    }
}
