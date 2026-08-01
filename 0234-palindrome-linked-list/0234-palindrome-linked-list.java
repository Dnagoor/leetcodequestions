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
        public boolean isPalindrome(ListNode head) {
            ListNode fast = head;
            ListNode slow = head;

            while(fast!=null && fast.next!=null){
                fast=fast.next.next;
                slow = slow.next;


            }
            ListNode sec = reverse(slow);

            ListNode fir = head;

            while(sec!= null){
                if(fir.val!= sec.val) return false;

                fir= fir.next;
                sec = sec.next;

            }
            return true;

            
        }
        public ListNode reverse(ListNode head){
            ListNode prev= null;
            ListNode temp =head;

            while(temp!=null){
                ListNode front = temp.next;
                temp.next = prev;
                prev= temp;
                temp= front;
            }
            return prev;
        }
    }
