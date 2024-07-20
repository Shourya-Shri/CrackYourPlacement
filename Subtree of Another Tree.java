public boolean isIdentical(TreeNode node, TreeNode subRoot){
        if(node==null &&subRoot==null){
            return true;
        }else if(node==null ||subRoot==null || node.val!=subRoot.val){
            return false;
        }
        if(!isIdentical(node.left,subRoot.left)){
            return false;
        }
        if(!isIdentical(node.right,subRoot.right)){
            return false;
        }
        return true;
    }
}
