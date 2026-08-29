/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        // firstly copy the same list between the elements
        if(head==null){
            return null;
        }

        Node curr = head;
        while(curr!=null){
            Node copy = new Node(curr.val);
            copy.next=curr.next;
            curr.next= copy;
            curr=copy.next;
        }

        // now we need to copy the random pointer
        // if curr's pointer is pointing to random elem then 
        // curr.next which is copied elem is pointing to that curr's randoms next
        // which is also a copy

        curr =head;
        while(curr!=null){
            if(curr.random!=null){
                curr.next.random = curr.random.next;
            }
            curr=curr.next.next;
        }
        // now we copied the random pointer too we need to seprate the copy from og

        // if curr is placed at head then curr's next is copied element which will be 
        // pointed by dummy node to remove the pointers 
        // curr.next = copy.next and if copy .next is not null then we assing copy.next =copy.next.next

        //implement the code 
        curr= head;
        Node dummy = curr.next;

        while(curr!=null){
            Node copy = curr.next;
            curr.next= copy.next;
            if(copy.next!=null){
                copy.next = copy.next.next;
            }
            curr=curr.next;

        }
        return dummy;
    }
}