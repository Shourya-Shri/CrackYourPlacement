/*class Node {
        int data;
        Node left, right;
 
        Node(int item) {
            data = item;
            left = right = null;
        }
    }*/

//Function should return true if a deadEnd is found in the bst otherwise return false.
class GFG
{
    public static boolean isDeadEnd(Node root)
    {
        return end(root,1,Integer.MAX_VALUE);
    }
    static boolean end(Node root,int min,int max){
        if(root==null){
            return false;
        }
        if(root.left==null && root.right==null){
            if(min==max){
                return true;
            }
        }
        return end(root.left,min,root.data-1) || end(root.right,root.data+1,max);
    }
}
