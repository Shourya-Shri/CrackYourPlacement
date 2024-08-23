class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] result = new int[nums1.length];
        Stack<Integer> stack = new Stack<>();
        HashMap<Integer, Integer> store = new HashMap<>();
        for(int i =0; i<nums1.length; i++){
            store.put(nums1[i], i);
        }

        for(int i =nums2.length-1; i>=0; i--){
            while(!stack.isEmpty() && nums2[i] > stack.peek()){
                stack.pop();
            }
            if(store.containsKey(nums2[i])){
                if(stack.isEmpty()){
                    result[store.get(nums2[i])] = -1;
                }
                else{
                    result[store.get(nums2[i])] = stack.peek();
                }
            }
            stack.push(nums2[i]);
        }
        return result;
        
    }
}
