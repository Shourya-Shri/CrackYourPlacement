class Solution {
    // Function to find the maximum number of cuts.
    public int maximizeCuts(int n, int x, int y, int z) {
        int[] dp = new int[n+1];  // DP array to store the maximum number of cuts
        int[] itm = new int[]{x, y, z};  // Array to store the cut lengths

        // Initialize dp array with minimum value
        for (int i = 1; i <= n; i++) {
            dp[i] = Integer.MIN_VALUE;
        }
        dp[0] = 0;  // If length is 0, no cuts can be made, so the max cuts is 0

        // Process each length from 1 to n
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < 3; j++) {
                if (i >= itm[j] && dp[i - itm[j]] != Integer.MIN_VALUE) {
                    dp[i] = Math.max(dp[i], dp[i - itm[j]] + 1);
                }
            }
        }

        // If dp[n] is still Integer.MIN_VALUE, it means no cuts can be made, so return 0
        return Math.max(dp[n], 0);
    }
}
