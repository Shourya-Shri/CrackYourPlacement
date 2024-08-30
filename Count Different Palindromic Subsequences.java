class Solution {
    int MOD = 1_000_000_007;
    Set<String> set = new HashSet<>();
    int count = 0;

    private boolean isPalindrom(String s) {
        int left = 0, right = s.length() - 1;
        while (left <= right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
    private void solveRec(String s, int idx, StringBuilder sb) {
        // Base case
        if (idx >= s.length()) {
            if (sb.length() != 0 && isPalindrom(sb.toString()) && !set.contains(sb.toString())) {
                count++;
                set.add(sb.toString());
                return;
            }
            return;
        }

        // BackTracking
        sb.append(s.charAt(idx));
        solveRec(s, idx + 1, sb);
        sb.deleteCharAt(sb.length() - 1);

        solveRec(s, idx + 1, sb);
    }


    // DP + Memoization
    private int solveMemo(String s, int start, int end, Integer[][] dp) {
        // Base Case
        if (start == end) {
            return 1;
        }
        if (start > end) {
            return 0;
        }

        // step-2 => if already calculated just return it
        if (dp[start][end] != null) {
            return dp[start][end];
        }

        // Step-3 => if not calculated just calculate it
        int res = 0;
        if (s.charAt(start) == s.charAt(end)) {
            int left = start + 1;
            int right = end - 1;
            while (left <= right && s.charAt(left) != s.charAt(start)) left++;
            while (left <= right && s.charAt(right) != s.charAt(end)) right--;

            if (left < right) {
                res += 2 * solveMemo(s, start + 1, end - 1, dp) - solveMemo(s, left + 1, right - 1, dp);
            } else if (left > right) {
                res += 2 * solveMemo(s, start + 1, end - 1, dp) + 2;
            } else {
                res += 2 * solveMemo(s, start + 1, end - 1, dp) + 1;
            }
        } else {
            res += solveMemo(s, start + 1, end, dp) + solveMemo(s, start, end - 1, dp)
                    - solveMemo(s, start + 1, end - 1, dp);
        }

        return dp[start][end] = res < 0 ? res + MOD : res % MOD;
    }




    public int countPalindromicSubsequences(String s) {
        // Recursive + BackTracking
        // solveRec(s, 0, new StringBuilder());
        // return count % MOD;

        // DP + Memoization
        Integer[][] dp = new Integer[1001][1001];
        return solveMemo(s, 0, s.length() - 1, dp);
    }
}
