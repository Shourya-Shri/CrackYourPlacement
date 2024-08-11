class Solution {
    // Function to return Breadth First Traversal of given graph.
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        boolean vis[]= new boolean[V+1];
        Queue<Integer> q= new LinkedList<>();
        ArrayList<Integer> al= new ArrayList<Integer>();
        int s=0;
        vis[s]=true;
        q.add(s);
        while(!q.isEmpty()){
            int u=q.poll();
            al.add(u);
            for(int v:adj.get(u)){
                if(vis[v]==false){
                    vis[v]=true;
                    q.add(v);
                }
            }
        }
        return al;
    }
}
