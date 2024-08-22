class Solution {
    int tour(int petrol[], int distance[]) {
        
	   int n = petrol.length;
	   
	   int [] arr = new int [n];
	   
	   for(int i=0; i<n; i++){
	       arr[i] = petrol[i]-distance[i];
	   }
	   
	   int left = 0, right = 0;
	   int sum = 0, size = 0;
	   
	   while(size < n && left < n){
	       right = right%n;
	       sum += arr[right++];
	       size++;
	       while(sum<0 && size > 0 && left < n){
	           sum -= arr[left++];
	           size--;
	       }
	   }
	   
	   if(size == n){
	       return left;
	   }
	   
	   return -1;
    }
}
