
import java.util.*;
public class Djkstra {
    static class Node {
        int vertex, dist;

        Node(int vertex, int dist) {
            this.vertex = vertex;
            this.dist = dist;
        }
    }
    public static int[] dijkstra(int[][] graph, int src) {
        int V = graph.length; // Number of vertices
        int[] dist = new int[V];
        boolean[] visited = new boolean[V];

        Arrays.fill(dist, Integer.MAX_VALUE); // Setting all distance to infinity
        dist[src] = 0; // Setting source distance to 0

        // Priority Queue to minimize time complexity
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(n -> n.dist));
        pq.offer(new Node(src, 0));

        while (!pq.isEmpty()) {
            Node node = pq.poll();
            int u = node.vertex;

            if (visited[u]) continue;
            visited[u] = true;

            // Relaxation
            for (int v = 0; v < V; v++) {
                if (graph[u][v] != 0 && !visited[v]) {
                    int newDist = dist[u] + graph[u][v];
                    if (newDist < dist[v]) {
                        dist[v] = newDist;
                        pq.offer(new Node(v, newDist));
                    }
                }
            }
        }
        return dist;
    }
    public static void main(String[] args) {
        // Example adjacency matrix
        int[][] graph = {
                {0, 10, 0, 0, 3},
                {10, 0, 2, 0, 4},
                {0, 2, 0, 9, 0},
                {0, 0, 9, 0, 7},
                {3, 4, 0, 7, 0}
        };

        int src = 0;
        int[] distances = dijkstra(graph, src);

        System.out.println("Shortest distances from node " + src + ":");
        for (int i = 0; i < distances.length; i++) {
            System.out.println("To " + i + " -> " + distances[i]);
        }
    }
}
