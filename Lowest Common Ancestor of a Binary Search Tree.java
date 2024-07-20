/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        ArrayList<TreeNode> path1=new ArrayList<>();
        ArrayList<TreeNode> path2=new ArrayList<>();

        int n1=p.val;
        int n2=q.val;

        getpath(root,n1,path1);
        getpath(root,n2,path2);

        int i=0;
        for(; i<path1.size() && i<path2.size();i++){
            if(path1.get(i)!=path2.get(i)){
                break;
            }
        }
        TreeNode lca=path1.get(i-1);
        return lca;
    }
    public boolean getpath(TreeNode root, int n1, ArrayList<TreeNode> path){
        if(root==null){
            return false;
        }
        path.add(root);

        if(root.val==n1){
            return true;
        }
        boolean foundleft=getpath(root.left,n1,path);
        boolean foundright=getpath(root.right,n1,path);

        if(foundleft || foundright){
            return true;
        }
        path.remove(path.size()-1);
        return false;
    }
}
