class Solution {
    public static void findPreSuc(Node root, Node[] pre, Node[] suc, int key) {
        // Initialize predecessor and successor as null
        pre[0] = null;
        suc[0] = null;

        // Start from root and search for the key
        findPreSucHelper(root, pre, suc, key);
    }

    private static void findPreSucHelper(Node root, Node[] pre, Node[] suc, int key) {
        if (root == null) return;

        // If the key is found
        if (root.data == key) {
            // The maximum value in the left subtree is predecessor
            if (root.left != null) {
                Node temp = root.left;
                while (temp.right != null) {
                    temp = temp.right;
                }
                pre[0] = temp;
            }

            // The minimum value in the right subtree is successor
            if (root.right != null) {
                Node temp = root.right;
                while (temp.left != null) {
                    temp = temp.left;
                }
                suc[0] = temp;
            }
            return;
        }

        // If the key is smaller than root's data, go to left subtree
        if (key < root.data) {
            suc[0] = root;
            findPreSucHelper(root.left, pre, suc, key);
        } else { // go to right subtree
            pre[0] = root;
            findPreSucHelper(root.right, pre, suc, key);
        }
    }
}
