import java.util.Arrays;

class Graph {
    class Edge {
        int src, dest, weight;
        Edge() {
            src = dest = weight = 0;
        }
    }

    int V, E;
    Edge[] edge;

    // Constructor to create a graph with V vertices and E edges
    Graph(int v, int e) {
        V = v;
        E = e;
        edge = new Edge[e];
        for (int i = 0; i < e; ++i) {
            edge[i] = new Edge();
        }
    }

    // Function to detect negative cycle using Bellman-Ford
    void detectNegativeCycle(int src) {
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        // Relax all edges V-1 times
        for (int i = 1; i < V; ++i) {
            for (int j = 0; j < E; ++j) {
                int u = edge[j].src;
                int v = edge[j].dest;
                int weight = edge[j].weight;
                if (dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v]) {
                    dist[v] = dist[u] + weight;
                }
            }
        }

        // Check for negative-weight cycles
        for (int j = 0; j < E; ++j) {
            int u = edge[j].src;
            int v = edge[j].dest;
            int weight = edge[j].weight;
            if (dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v]) {
                System.out.println("Graph contains negative weight cycle");
                return;
            }
        }

        System.out.println("No negative weight cycle detected");
    }

    // Main function to run the Bellman-Ford algorithm
    public static void main(String[] args) {
        int V = 5;  // Number of vertices in graph
        int E = 8;  // Number of edges in graph

        Graph graph = new Graph(V, E);

        // Add edges
        graph.edge[0].src = 0;
        graph.edge[0].dest = 1;
        graph.edge[0].weight = -1;

        graph.edge[1].src = 0;
        graph.edge[1].dest = 2;
        graph.edge[1].weight = 4;

        graph.edge[2].src = 1;
        graph.edge[2].dest = 2;
        graph.edge[2].weight = 3;

        graph.edge[3].src = 1;
        graph.edge[3].dest = 3;
        graph.edge[3].weight = 2;

        graph.edge[4].src = 1;
        graph.edge[4].dest = 4;
        graph.edge[4].weight = 2;

        graph.edge[5].src = 3;
        graph.edge[5].dest = 2;
        graph.edge[5].weight = 5;

        graph.edge[6].src = 3;
        graph.edge[6].dest = 1;
        graph.edge[6].weight = 1;

        graph.edge[7].src = 4;
        graph.edge[7].dest = 3;
        graph.edge[7].weight = -3;

        graph.detectNegativeCycle(0);
    }
}
