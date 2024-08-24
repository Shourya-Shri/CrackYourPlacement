class Solution {
    // Function to find if there is a celebrity in the party or not.
    public int celebrity(int mat[][]) {
        // code 
       int n = mat.length;
        int candidate = 0;

        // Step 1: Find the potential celebrity
        for (int i = 1; i < n; i++) {
            if (mat[candidate][i] == 1) {
                candidate = i; // candidate knows i, so candidate can't be a celebrity, i might be
            }
        }

        // Step 2: Verify the candidate
        for (int i = 0; i < n; i++) {
            if (i != candidate && (mat[candidate][i] == 1 || mat[i][candidate] == 0)) {
                return -1; // candidate knows someone or someone doesn't know candidate
            }
        }

        return candidate; // candidate is the celebrity
    }
}
