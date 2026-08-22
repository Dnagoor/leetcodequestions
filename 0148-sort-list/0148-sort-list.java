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
    public ListNode sortList(ListNode head) {
        if(head==null || head.next==null){
            return head;
        }
        ListNode slow= head , fast=head.next;
        while(fast!=null && fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        ListNode sec= slow.next;
        slow.next=null;

        ListNode first=sortList(head);
        ListNode last = sortList(sec);

        return merge(first,last);

        
    }
    private ListNode merge(ListNode l1, ListNode l2){
        ListNode dummy = new ListNode(-1);
        ListNode temp= dummy;

        while(l1!=null && l2!=null){
            if(l1.val <= l2.val){
                temp.next= l1;
                l1=l1.next;
            }
            else {
                temp.next= l2;
                l2=l2.next;
            }
            temp=temp.next;
        }
        if(l1!=null) temp.next=l1;
        else temp.next=l2;

        return dummy.next;

    }
}