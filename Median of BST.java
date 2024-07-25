class Tree
{
    public static float findMedian(Node root)
    {
        Queue<Node> q=new LinkedList<>();
        ArrayList<Integer> al=new ArrayList<>();
        q.add(root);
        q.add(null);
        
        while(!q.isEmpty()){
            Node currNode=q.remove();
            if(currNode==null){
                if(q.isEmpty()){
                    break;
                }else{
                    q.add(null);
                }
            }else{
                al.add(currNode.data);
                if(currNode.left!=null){
                    q.add(currNode.left);
                }
                if(currNode.right!=null){
                    q.add(currNode.right);
                }
            }
        }
        Collections.sort(al);
        int a=al.size();
        
        if(a%2==0){
            return ((al.get(a/2)+al.get(a/2 - 1))/2.0f);
        }else{
            return al.get(a/2);
        }
    }
}
