class Solution
{
    //Function to count number of nodes in BST that lie in the given range.
    int getCount(Node root,int l, int h)
    {
        ArrayList<Integer> al=new ArrayList<>();
        inorder(root,al);
        int count=0;
        for(int i=0;i<al.size();i++){
            if(al.get(i)>l-1 && al.get(i)<h+1){
                count=count+1;
            }
        }
        return count;
    }
    void inorder(Node root, ArrayList<Integer> al){
        if(root==null){
            return;
        }
        inorder(root.left, al);
        al.add(root.data);
        inorder(root.right,al);
    }
}
