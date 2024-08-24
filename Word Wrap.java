class Solution {

    // Recursive function to calculate minimum cost
    public static int WordWrap(int remain, int i, int[] nums, int k, HashMap<String, Integer> memo) {
        // If we have processed all words, no extra cost
        if (i == nums.length) {
            return 0;
        }
        
        // Check if the result for this state is already computed
        String key = i + ":" + remain;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }
        
        int ans;
        // If the current word cannot fit in the remaining space
        if (nums[i] > remain) {
            ans = (int) Math.pow(remain + 1, 2) + WordWrap(k - nums[i] - 1, i + 1, nums, k, memo);
        } else {
            // Two choices:
            // 1. Place the current word on a new line
            int choice1 = (int) Math.pow(remain + 1, 2) + WordWrap(k - nums[i] - 1, i + 1, nums, k, memo);
            
            // 2. Place the current word on the current line
            int choice2 = WordWrap(remain - nums[i] - 1, i + 1, nums, k, memo);
            
            // Take the minimum of the two choices
            ans = Math.min(choice1, choice2);
        }

        // Memoize the result before returning
        memo.put(key, ans);
        return ans;
    }

    public int solveWordWrap(int[] nums, int k) {
        HashMap<String, Integer> memo = new HashMap<>();
        return WordWrap(k, 0, nums, k, memo);
    }

}
