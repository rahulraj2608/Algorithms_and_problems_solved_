import java.util.*;

class FloydWarshall {

    public static void floydWarshall(int[][] graph) {
        int V = graph.length;

        // Make a copy of graph distances
        int[][] dist = new int[V][V];
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                dist[i][j] = graph[i][j];
            }
        }

        // Core Floyd-Warshall DP
        for (int k = 0; k < V; k++) {       // intermediate node
            for (int i = 0; i < V; i++) {   // source
                for (int j = 0; j < V; j++) { // destination
                    if (dist[i][k] != Integer.MAX_VALUE && dist[k][j] != Integer.MAX_VALUE
                            && dist[i][k] + dist[k][j] < dist[i][j])import java.util.*;

                    class FloydWarshall {

                        public static void floydWarshall(int[][] graph) {
                            int V = graph.length;

                            // Make a copy of graph distances
                            int[][] dist = new int[V][V];
                            for (int i = 0; i < V; i++) {
                                for (int j = 0; j < V; j++) {
                                    dist[i][j] = graph[i][j];
                                }
                            }

                            // Core Floyd-Warshall DP
                            for (int k = 0; k < V; k++) {       // intermediate node
                                for (int i = 0; i < V; i++) {   // source
                                    for (int j = 0; j < V; j++) { // destination
                                        if (dist[i][k] != Integer.MAX_VALUE && dist[k][j] != Integer.MAX_VALUE
                                                && dist[i][k] + dist[k][j] < dist[i][j]) {
                                            dist[i][j] = dist[i][k] + dist[k][j];
                                        }
                                    }
                                }
                            }

                            // Print result
                            System.out.println("All-pairs shortest path matrix:");
                            for (int i = 0; i < V; i++) {
                                for (int j = 0; j < V; j++) {
                                    if (dist[i][j] == Integer.MAX_VALUE)
                                        System.out.print("INF ");
                                    else
                                        System.out.print(dist[i][j] + "   ");
                                }
                                System.out.println();
                            }
                        }

                        public static void main(String[] args) {
                            final int INF = Integer.MAX_VALUE;

                            // Example graph as adjacency matrix
                            int[][] graph = {
                                    {0, 3, INF, 7},
                                    {8, 0, 2, INF},
                                    {5, INF, 0, 1},
                                    {2, INF, INF, 0}
                            };

                            floydWarshall(graph);
                        }
                    } {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }

        // Print result
        System.out.println("All-pairs shortest path matrix:");
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                if (dist[i][j] == Integer.MAX_VALUE)
                    System.out.print("INF ");
                else
                    System.out.print(dist[i][j] + "   ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        final int INF = Integer.MAX_VALUE;

        // Example graph as adjacency matrix
        int[][] graph = {
                {0, 3, INF, 7},
                {8, 0, 2, INF},
                {5, INF, 0, 1},
                {2, INF, INF, 0}
        };

        floydWarshall(graph);
    }
}