class Solution
{
    //Function to return list containing vertices in Topological order. 
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) 
    {
        // add your code here
        boolean vis[]=new boolean[V];
        Stack<Integer> s=new Stack<>();
        
        int arr[]=new int[V];
        
        for(int i=0;i<V;i++){
            if(!vis[i]){
                topSortUtil(adj,i,vis,s);
            }
        }
        int i=0;
        while(!s.isEmpty()){
            arr[i]=s.pop();
            i++;
        }
        return arr;
    }
    static void topSortUtil(ArrayList<ArrayList<Integer>> adj,int curr,boolean vis[],Stack<Integer> s){
        vis[curr]=true;
        
        for(int i=0;i<adj.get(curr).size();i++){
            int a=adj.get(curr).get(i);
            
            if(!vis[a]){
                topSortUtil(adj,a,vis,s);
            }
        }
        s.push(curr);
    }
}
