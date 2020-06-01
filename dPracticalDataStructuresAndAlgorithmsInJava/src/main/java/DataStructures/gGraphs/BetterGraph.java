package DataStructures.gGraphs;

public class BetterGraph {

    private Vertex[] arrayOfLists;
    private int indexCounter;
    private boolean undirected;

    public BetterGraph(int vCount, String graphType) {
        this.undirected = !graphType.equals("directed");
        this.arrayOfLists = new Vertex[vCount];
        this.indexCounter = 0;
    }

    public void addVertex(String vertexName) {
        arrayOfLists[indexCounter] = new Vertex(vertexName,null);
        indexCounter++;
    }

    public void addEdge(String srcVertexName, String destVertexName) {
        int v1Idx = indexForName(srcVertexName);
        int v2Idx = indexForName(destVertexName);
        arrayOfLists[v1Idx].adjList = new Node(v2Idx, arrayOfLists[v1Idx].adjList);
        if (undirected) {
            arrayOfLists[v2Idx].adjList = new Node(v1Idx, arrayOfLists[v2Idx].adjList);
        }
    }

    private int indexForName(String name) {
        for (var v = 0; v < arrayOfLists.length; v++) {
            if (arrayOfLists[v].name.equals(name)) {
                return v;
            }
        }
        return -1;
    }

    public void print() {
        System.out.println();
        for (var v = 0; v < arrayOfLists.length; v++) {
            System.out.print(arrayOfLists[v].name);
            for (var aNode = arrayOfLists[v].adjList; aNode != null; aNode = aNode.next) {
                System.out.print(" --> " + arrayOfLists[aNode.vertexId].name);
            }
            System.out.println("\n");
        }
    }

    private class Node {

        int vertexId;
        Node next;

        public Node(int vertexId, Node next) {
            this.vertexId = vertexId;
            this.next = next;
        }
    }

    private class Vertex {

        String name;
        Node adjList;

        public Vertex(String name, Node aNode) {
            this.name = name;
            this.adjList = aNode;
        }
    }
}

