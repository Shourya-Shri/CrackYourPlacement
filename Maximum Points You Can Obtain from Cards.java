class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int[] leftSum=new int[cardPoints.length+1];
        leftSum[0]=0;
        for(int i=1;i<leftSum.length;i++){
            leftSum[i]=leftSum[i-1]+cardPoints[i-1];
        }
        int[] rightSum=new int[cardPoints.length+1];
        rightSum[rightSum.length-1]=0;
        for(int i=rightSum.length-2;i>=0;i--){
            rightSum[i]=rightSum[i+1]+cardPoints[i];
        }
        int i=k;
        int j=rightSum.length-1;
        int ans=Integer.MIN_VALUE;
        while(i>=0){
            if(leftSum[i]+rightSum[j]>=ans){
                ans=leftSum[i]+rightSum[j];   
            }
            i--;
            j--;
        }
        return ans;
        
    }
}
