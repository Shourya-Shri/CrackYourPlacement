class Solution {
    static ArrayList<ArrayList<String>> allPalindromicPerms(String S) {
        ArrayList<ArrayList<String>> result = new ArrayList<>();
        ArrayList<String> currentPartition = new ArrayList<>();
        backtrack(S, 0, currentPartition, result);
        return result;
    }

    private static void backtrack(String s, int start, ArrayList<String> currentPartition, ArrayList<ArrayList<String>> result) {
        // If we reach the end of the string, add the current partition to the result
        if (start == s.length()) {
            result.add(new ArrayList<>(currentPartition));
            return;
        }

        // Explore all possible partitions
        for (int end = start; end < s.length(); end++) {
            if (isPalindrome(s, start, end)) {
                // If the substring s[start:end+1] is a palindrome, add it to the current partition
                currentPartition.add(s.substring(start, end + 1));
                // Recurse for the remaining substring
                backtrack(s, end + 1, currentPartition, result);
                // Backtrack: remove the last added partition and explore further partitions
                currentPartition.remove(currentPartition.size() - 1);
            }
        }
    }

    private static boolean isPalindrome(String s, int low, int high) {
        while (low < high) {
            if (s.charAt(low) != s.charAt(high)) {
                return false;
            }
            low++;
            high--;
        }
        return true;
    }
}
