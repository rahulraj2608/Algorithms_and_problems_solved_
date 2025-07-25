// Online Java Compiler
// Use this editor to write, compile and run your Java code online
import java.util.*;

class Graph {
    private int[][] Matrix;
    private int numVertices;
    
    Graph(int numVertices){
        this.numVertices=numVertices;
        Matrix = new int[numVertices][numVertices];
    }
    
    public void addEdge(int src, int dest){
        Matrix[src][dest]=1;
        Matrix[dest][src]=1;
    }
    
    public void removeEdge(int src, int dest){
        Matrix[src][dest]=0;
        Matrix[dest][src]=0;
    }
    
    public void display(){
        int n = numVertices;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.print(Matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
    
    public void BFS(int start){
        boolean[] visited = new boolean[numVertices];
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visited[start] = true;

        while(!q.isEmpty()){
            int node = q.poll();
            System.out.print(node + " ");
            for(int i = 0; i < numVertices; i++){
                if(Matrix[node][i] == 1 && !visited[i]){
                    q.add(i);
                    visited[i] = true;
                }
            }
        }
    }
    
        public void DFS(int start){
        boolean[] visited = new boolean[numVertices];
        Stack<Integer> s = new Stack<>();
        s.push(start);
        visited[start] = true;

        while(!s.isEmpty()){
            int node = s.pop();
            System.out.print(node + " ");
            for(int i = 0; i < numVertices; i++){
                if(Matrix[node][i] == 1 && !visited[i]){
                    s.push(i);
                    visited[i] = true;
                }
            }
        }
    }
    public static void main(String[] args) {
        Graph x = new Graph(5) ;
        x.addEdge(0,1);
        x.addEdge(0,3);
        x.addEdge(1,3);
        x.addEdge(1,2);
        x.addEdge(3,4);
        
        
        
        x.BFS(0);
    }
}