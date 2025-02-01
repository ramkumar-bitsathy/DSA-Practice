import java.util.*;


public class Graph {

    public ArrayList<ArrayList<Integer>> AdjList = null;

    Graph(){
        AdjList = new ArrayList<>();
    }
    
    private ArrayList<ArrayList<Integer>> createAdjacencyList(int[][] edges,ArrayList<ArrayList<Integer>> AdjList){
        for(int[] edge: edges){
            int u = edge[0];
            int v = edge[1];
            AdjList.get(u).add(v);
            AdjList.get(v).add(u);
        }
        return AdjList;
    }

    public ArrayList<ArrayList<Integer>> createAdjacencyList(int[][] edges){
        
        for(int i = 0;i<=edges.length;i++) AdjList.add(new ArrayList<>());
        createAdjacencyList(edges,AdjList);

        return AdjList;
    }

    public void printAdjList(ArrayList<ArrayList<Integer>> graphAdjList){
        for(int i= 0;i<graphAdjList.size();i++){
            System.out.println(i+" --> "+graphAdjList.get(i));
        }
    }


    public ArrayList<Integer> bfs(int start){
        ArrayList<Integer> bfsResult = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);

        int[] visited = new int[AdjList.size()+1];

        while(!queue.isEmpty()){
            int node = queue.poll();
            if(visited[node]==0)
            bfsResult.add(node);    
            visited[node]++;

            for(int x: AdjList.get(node)){
                if (visited[x]==0) queue.add(x);
            }
            
        }
        return bfsResult;
    }


    private ArrayList<Integer> dfs(int node,int[] visited,ArrayList<Integer> dfsResult){
        visited[node]++;
        dfsResult.add(node);

        for(int adj:AdjList.get(node)){
            if (visited[adj]==0){
                dfs(adj,visited,dfsResult);
            }
        }

        return dfsResult;
    }

    public ArrayList<Integer> dfs(int start){
        int[] visited = new int[AdjList.size()+1];
        ArrayList<Integer> dfsResult = new ArrayList<>();
        dfs(start,visited,dfsResult);
        return dfsResult;
    }

    
}
