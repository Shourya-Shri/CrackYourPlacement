class Solution {

    static int equalPartition(int N, int arr[]) {
        int sum = 0;
        for (int i = 0; i < N; i++) {
            sum += arr[i];
        }

        // If the sum is odd, we cannot partition it into two equal subsets
        if (sum % 2 != 0) {
            return 0;
        }

        // Check if there's a subset with sum equal to sum/2
        boolean isSubsetSum = subsetSum(N, arr, sum / 2);
        return isSubsetSum ? 1 : 0;
    }

    private static boolean subsetSum(int N, int[] arr, int sum) {
        Boolean dp[][] = new Boolean[N + 1][sum + 1];

        for (int i = 0; i <= N; i++) {
            dp[i][0] = true; // A sum of 0 can always be achieved with an empty subset
        }
        for (int j = 1; j <= sum; j++) {
            dp[0][j] = false; // If there are no elements, no positive sum can be achieved
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= sum; j++) {
                if (arr[i - 1] <= j) {
                    dp[i][j] = dp[i - 1][j - arr[i - 1]] || dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[N][sum];
    }
}
