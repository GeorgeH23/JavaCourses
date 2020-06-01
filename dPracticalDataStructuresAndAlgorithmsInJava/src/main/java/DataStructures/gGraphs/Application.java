package DataStructures.gGraphs;

public class Application {

    public static void main(String[] args) {

        BetterGraph myGraph = new BetterGraph(5, "directed");
        myGraph.addVertex("State");
        myGraph.addVertex("Angel");
        myGraph.addVertex("Elm");
        myGraph.addVertex("Pocono");
        myGraph.addVertex("William");

        myGraph.addEdge("Angel", "Pocono");
        myGraph.addEdge("State", "Elm");
        myGraph.addEdge("Elm", "Angel");
        myGraph.addEdge("Elm", "William");
        myGraph.addEdge("William", "State");
        myGraph.addEdge("William", "Pocono");
        myGraph.addEdge("Pocono", "Elm");
        myGraph.addEdge("State", "Angel");

        myGraph.print();
    }
}
