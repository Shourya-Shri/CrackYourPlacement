class Solution {
    static int maxConnections;
    static int nodeCount;

    public void dfs(int currentNode, HashSet<Integer>[] graph, HashSet<Integer> unvisited) {
        // Remove the current node from the unvisited set
        unvisited.remove(currentNode);

        // Traverse all neighbors of the current node
        for (int neighbor : graph[currentNode]) {
            maxConnections++;
            // If the neighbor is unvisited, continue the DFS from that neighbor
            if (unvisited.contains(neighbor)) {
                dfs(neighbor, graph, unvisited);
            }
        }

        // Increment the node count for the current connected component
        nodeCount++;
    }

    public void buildGraph(HashSet<Integer>[] graph, int[][] connections) {
        // Build the graph from the connections
        for (int[] connection : connections) {
            graph[connection[0]].add(connection[1]);
            graph[connection[1]].add(connection[0]);
        }
    }

    public int makeConnected(int n, int[][] connections) {
        maxConnections = 0;
        nodeCount = 0;

        // Initialize the graph as an array of hash sets
        HashSet<Integer>[] graph = new HashSet[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new HashSet<>();
        }

        // Set to keep track of unvisited nodes
        HashSet<Integer> unvisited = new HashSet<>();
        for (int i = 0; i < n; i++) {
            unvisited.add(i);
        }

        // Build the graph using the connections
        buildGraph(graph, connections);

        int connectedComponents = 0;
        int redundantConnections = 0;

        // DFS to count the number of connected components and redundant connections
        for (int i = 0; i < n; i++) {
            if (unvisited.contains(i)) {
                maxConnections = 0;
                nodeCount = 0;
                connectedComponents++;
                dfs(i, graph, unvisited);
                redundantConnections += maxConnections / 2 - nodeCount + 1;
            }
        }

        // Check if we have enough redundant connections to connect all components
        if (redundantConnections >= connectedComponents - 1) {
            return connectedComponents - 1;
        }

        // If not enough redundant connections, return -1
        return -1;
    }
}
