/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<TreeNode> generateTrees(int n) {
        return generateBST(1,n);
    }
    private List<TreeNode> generateBST(int start,int end){
        List<TreeNode> ans=new ArrayList<>();

        if(start>end){
            ans.add(null);
            return ans;
        }
        for(int i=start;i<=end;i++){
            List<TreeNode> leftNodes=generateBST(start,i-1);
            List<TreeNode> rightNodes=generateBST(i+1,end);

            for(TreeNode left: leftNodes){
                for(TreeNode right: rightNodes){
                    TreeNode root = new TreeNode(i, left, right);
                    ans.add(root);
                }
            }
        }
        return ans;
    }
}
