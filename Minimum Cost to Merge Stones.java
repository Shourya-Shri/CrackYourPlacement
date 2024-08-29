class Solution {
    int prefix[];
    public int mergeStones(int[] stones, int k) {
        int n=stones.length;
        if((n-1)%(k-1) != 0) return -1;
        prefix=new int[stones.length+1];
        prefix[0]=0;
        int sum=0;
        for(int i=0;i<stones.length;i++){
            sum+=stones[i];
            prefix[i+1]=sum;
        }
        int dp[][]=new int[stones.length][stones.length];
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                dp[i][j]=-1;
            }
        }
        return check(prefix,k,0,stones.length-1,dp);
    }
    public int check(int[] prefix,int k,int i,int j,int dp[][]){
        if(i>=j){
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int min=Integer.MAX_VALUE;
        for(int t=i;t<j;t=t+k-1){
            int min1=check(prefix,k,i,t,dp)+check(prefix,k,t+1,j,dp);
            min=Math.min(min,min1);
        }
        if((j-i)%(k-1)==0){
            min+=prefix[j+1]-prefix[i];
        }
        dp[i][j]=min;
        return min;
    }
}
