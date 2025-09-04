import java.util.*;
public class BellmanFord {


        public static int[] bellmanFord(int[][] graph, int src) {
            int V = graph.length;
            int[] dist = new int[V];
            Arrays.fill(dist, Integer.MAX_VALUE);
            dist[src] = 0;

            // Relax all edges V-1 times
            for (int i = 0; i < V - 1; i++) {
                for (int u = 0; u < V; u++) {
                    for (int v = 0; v < V; v++) {
                        if (graph[u][v] != 0 && dist[u] != Integer.MAX_VALUE && dist[u] + graph[u][v] < dist[v]) {
                            dist[v] = dist[u] + graph[u][v];
                        }
                    }
                }
            }

            // Check for negative weight cycles
            for (int u = 0; u < V; u++) {
                for (int v = 0; v < V; v++) {
                    if (graph[u][v] != 0 && dist[u] != Integer.MAX_VALUE && dist[u] + graph[u][v] < dist[v]) {
                        System.out.println("Graph contains a negative weight cycle");
                        return null;
                    }
                }
            }

            return dist;
        }

        public static void main(String[] args) {
            // Example graph as adjacency matrix
            // 0 means no edge
            int[][] graph = {
                    {0, 6, 0, 7, 0},
                    {0, 0, 5, 8, -4},
                    {0, -2, 0, 0, 0},
                    {0, 0, -3, 0, 9},
                    {2, 0, 7, 0, 0}
            };

            int src = 0;
            int[] distances = bellmanFord(graph, src);

            if (distances != null) {
                System.out.println("Shortest distances from node " + src + ":");
                for (int i = 0; i < distances.length; i++) {
                    System.out.println("To " + i + " -> " + distances[i]);
                }
            }
        }


}