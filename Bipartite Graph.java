class Solution {

    public boolean isBipartite(int V, ArrayList<ArrayList<Integer>> adj) {
        // Create a queue to perform BFS
        Queue<Integer> queue = new LinkedList<>();
        
        // Array to store colors assigned to vertices
        int[] color = new int[V];
        
        // Initialize all vertices as uncolored
        Arrays.fill(color, -1);
        
        // Check each component of the graph
        for (int i = 0; i < V; i++) {
            // If the vertex is not colored, start a BFS
            if (color[i] == -1) {
                // Start with the current vertex
                queue.add(i);
                color[i] = 0; // Assign color 0 to the starting vertex
                
                // Perform BFS
                while (!queue.isEmpty()) {
                    int current = queue.remove();
                    
                    // Check all adjacent vertices
                    for (int neighbor : adj.get(current)) {
                        // If the neighbor is not colored, assign alternate color
                        if (color[neighbor] == -1) {
                            color[neighbor] = (color[current] + 1) % 2;
                            queue.add(neighbor);
                        } else {
                            // If neighbor is colored the same as the current vertex, it's not bipartite
                            if (color[neighbor] == color[current]) {
                                return false;
                            }
                        }
                    }
                }
            }
        }
        
        // If all components are bipartite, return true
        return true;
    }
}
