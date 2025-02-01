import java.util.*;
public class GraphTraversal {

    ArrayList<Integer> TraversalResult;

    
    
    public static void main(String[] args) {
        int[][] edges = {{1,2},{1,3},{2,4},{3,4},{3,5},{4,5}};
        
        Graph GraphObj = new Graph();
        ArrayList<ArrayList<Integer>> graph = GraphObj.createAdjacencyList(edges);
        
        GraphObj.printAdjList(graph);

        ArrayList<Integer> bfsResult = GraphObj.bfs(1);
        System.out.println("BFS "+bfsResult);

        ArrayList<Integer> dfsResult = GraphObj.dfs(1);
        System.out.println("DFS "+dfsResult);
    }
}
