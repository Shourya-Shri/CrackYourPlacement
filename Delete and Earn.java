class Solution {
    public int deleteAndEarn(int[] nums) {
        Arrays.sort(nums);
        
        List<int[]> list = new ArrayList<>();
        for(int num : nums){
            if(!list.isEmpty() && list.get(list.size()-1)[0] == num){
                list.get(list.size()-1)[1]++;
            }
            else{
                list.add(new int[]{num, 1});
            }
        }
        int n = list.size(); 
        int[] memo = new int[n];
        
        for(int i=n-1; i>=0; i--){
            int curr = list.get(i)[0] * list.get(i)[1];
            
            int nextToAdj = (i+2 < n ? memo[i+2] : 0) + curr;
            
            int adj = i+1 < n ? memo[i+1] : 0;
            
            if(i<n-1 && list.get(i+1)[0] != list.get(i)[0]+1){
                adj += curr;
            }
            memo[i] = Math.max(adj, nextToAdj);
        }
    
        return memo[0];
    }
}
