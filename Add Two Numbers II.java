/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    ListNode ans=new  ListNode(0,null);
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        l1=rev(l1);
        l2=rev(l2);
        add(l1,l2,0,ans);
        ans=ans.next;
        ans=rev(ans);
        return ans;
    }
    public ListNode rev(ListNode head)
    {
        ListNode prev=null;
        ListNode curr=head;
        ListNode next=head;
        while(curr!=null)
        {
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        return prev;

    }
    public void add(ListNode l1,ListNode l2,int carry,ListNode curr)
    {
        if(l1==null&&l2==null)
        {
            if(carry!=0)
                curr.next= (new ListNode(carry,null));
            return;
        }
        else if(l1==null)
        {
            ListNode temp=new  ListNode((l2.val+carry)%10,null);
            curr.next=temp;
            carry=(l2.val+carry)/10;
            add(l1,l2.next,carry,curr.next);
        }
        else if(l2==null)
        {
            ListNode temp=new  ListNode((l1.val+carry)%10,null);
            curr.next=temp;
            carry=(l1.val+carry)/10;
            add(l1.next,l2,carry,curr.next);
        }
        else
        {
            ListNode temp=new  ListNode((l1.val+l2.val+carry)%10,null);
            curr.next=temp;
            carry=(l1.val+l2.val+carry)/10;
            add(l1.next,l2.next,carry,curr.next);
        }
    }
}
