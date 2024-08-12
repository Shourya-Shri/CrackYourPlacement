class Solution {
    // Function to detect cycle in a directed graph.
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        
        boolean vis[]=new boolean[V];
        
        boolean stack[]=new boolean[V];
        
        for(int i=0;i<adj.size();i++){
            if(!vis[i]){
                if(isCyclicUtil(adj,i,vis,stack)){
                    return true;
                }
            }
        }
        return false;
    }
    public boolean isCyclicUtil(ArrayList<ArrayList<Integer>> adj,int curr,boolean vis[],boolean stack[]){
        
        vis[curr]=true;
        stack[curr]=true;
        
        for(int i=0;i<adj.get(curr).size();i++){
            int a=adj.get(curr).get(i);
            if(stack[a]){
                return true;
            }
            if(!vis[a] && isCyclicUtil(adj,a,vis,stack)){
                return true;
            }
        }
        stack[curr]=false;
        return false;
    }
}
