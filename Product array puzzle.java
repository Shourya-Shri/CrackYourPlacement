class Solution 
{ 
	public static long[] productExceptSelf(int nums[], int n) 
	{ 
        long prod[]=new long[nums.length];
        long p=1;
        
        for(int i=0;i<prod.length;i++){
            for(int j=0;j<prod.length;j++){
                if(i==j){
                    continue;
                }else{
                    p*=nums[j];
                }
            }
            prod[i]=p;
            p=1;
        }
        return prod;
	} 
} 
