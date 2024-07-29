class Solution {

    // Return the size of the largest sub-tree which is also a BST
    static int largestBst(Node root) {
        return largestBstUtil(root).maxSize;
    }

    // Helper class to store information about a subtree
    static class Info {
        int min;      // Minimum value in the subtree
        int max;      // Maximum value in the subtree
        int size;     // Size of the subtree
        int maxSize;  // Size of the largest BST in the subtree
        boolean isBST;// Is the subtree a BST

        Info(int min, int max, int size, int maxSize, boolean isBST) {
            this.min = min;
            this.max = max;
            this.size = size;
            this.maxSize = maxSize;
            this.isBST = isBST;
        }
    }

    // Utility function to find the largest BST subtree
    static Info largestBstUtil(Node root) {
        // Base case: empty tree
        if (root == null) {
            return new Info(Integer.MAX_VALUE, Integer.MIN_VALUE, 0, 0, true);
        }

        // Recursively get info for left and right subtrees
        Info left = largestBstUtil(root.left);
        Info right = largestBstUtil(root.right);

        // If the current node's subtree is a BST
        if (left.isBST && right.isBST && root.data > left.max && root.data < right.min) {
            int size = left.size + right.size + 1;
            return new Info(
                Math.min(root.data, left.min),
                Math.max(root.data, right.max),
                size,
                size,
                true
            );
        }

        // If the current node's subtree is not a BST
        return new Info(
            0,
            0,
            0,
            Math.max(left.maxSize, right.maxSize),
            false
        );
    }
}
