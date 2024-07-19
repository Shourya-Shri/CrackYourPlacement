class Solution {
    public int majorityElement(int[] nums) {

        HashMap<Integer,Integer> hm=new HashMap<>();

        for(int i=0;i<nums.length;i++){
            hm.put(nums[i], hm.getOrDefault(nums[i],0)+1);
        }
        int a=0;

        for(Integer key: hm.keySet()){
            if(hm.get(key)>nums.length/2){
                a=key;
            }
        }
        return a;
    }
}
