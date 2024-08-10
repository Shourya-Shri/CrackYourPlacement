class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        // Handle edge cases
        if (nums == null || nums.length == 0 || k <= 0) {
            return new int[0];
        }
        
        // Initialize the result array
        int[] result = new int[nums.length - k + 1];
        
        // Initialize a deque to store indices of the array elements
        Deque<Integer> deque = new ArrayDeque<>();
        
        // Traverse through each element in the array
        for (int i = 0; i < nums.length; i++) {
            // Remove indices of elements that are out of the current window
            while (!deque.isEmpty() && deque.peekFirst() < i - k + 1) {
                deque.pollFirst();
            }
            
            // Remove indices of elements that are smaller than the current element
            // These elements are not useful because the current element is larger
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }
            
            // Add the current element's index to the deque
            deque.offerLast(i);
            
            // The maximum element of the current window is at the front of the deque
            if (i >= k - 1) {
                result[i - k + 1] = nums[deque.peekFirst()];
            }
        }
        
        return result;
    }
}
