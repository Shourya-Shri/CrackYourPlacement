class Solution {
    public static boolean Possible(int[] arr,int dist,int cows){
        int countcows=1;
        int lastcow=arr[0];
        for(int i=1;i<arr.length;i++){
            if(arr[i]-lastcow>=dist){
                lastcow=arr[i];
                countcows++;
            }
            if(countcows>=cows) return true;
        }
        return false;
    }
    public static int solve(int n, int k, int[] stalls) {
        Arrays.sort(stalls);
        int low=1;
        int high=Arrays.stream(stalls).max().getAsInt()-Arrays.stream(stalls).min().getAsInt();
        while(low<=high){
            int mid=(low+high)/2;
            if(Possible(stalls,mid,k)) low=mid+1;
            else high=mid-1;
        }
        return high;
    }
}
