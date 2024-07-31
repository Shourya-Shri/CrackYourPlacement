//User function Template for Java

/* class Node
class Node
{
	Node left, right;
	int data;
	
	Node(int d)
	{
		data = d;
		left = right = null;
	}
	
}*/

//This function should return head to the DLL

class Solution {  
    void dll(Node root, Node[] arr) {
        if (root == null) {
            return;
        }
        dll(root.left, arr);
        if (arr[1] == null) {
            arr[1] = root;
            arr[0] = root;
        } else {
            root.left = arr[0];
            arr[0].right = root;
            arr[0] = root;
        }
        dll(root.right, arr);
    } 
    
    Node bToDLL(Node root) {
        Node[] arr = {null, null};
        dll(root, arr);
        return arr[1];
    }
}
