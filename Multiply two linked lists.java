class Solution {
    public long multiplyTwoLists(Node l1,Node l2){
          //add code here.
        final long MOD = 1000000007;
        long num1 = 0;
        long num2 = 0;

        // Calculate num1 with modulo operation
        Node temp = l1;
        while (temp != null) {
            num1 = (num1 * 10 + temp.data) % MOD;
            temp = temp.next;
        }

        // Calculate num2 with modulo operation
        Node temp2 = l2;
        while (temp2 != null) {
            num2 = (num2 * 10 + temp2.data) % MOD;
            temp2 = temp2.next;
        }

        // Multiply num1 and num2 and take modulo again
        return (num1 * num2) % MOD;
   
   }


}
