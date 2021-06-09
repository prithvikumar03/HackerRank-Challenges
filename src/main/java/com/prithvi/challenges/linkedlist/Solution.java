package linkedlist;

public class Solution {
    public Node rotate(Node head, int k) {
        Node oldHead = head;
        Node current = head;
        for(int i=0;i<k-1;i++){
            current = current.next;
        }

        head = current.next;

        if(head == null)
            return oldHead;

        current.next = null;

        current = head;
        while(current.next!=null){
            current = current.next;
        }
        current.next = oldHead;

        return head;
    }

    int getMiddle(Node head)
    {
        Node slowerNode  = head;
        Node fasterNode = head;

        while(fasterNode!=null && fasterNode.next!=null){
            slowerNode = slowerNode.next;
            fasterNode = fasterNode.next;
            if(fasterNode!=null){
                fasterNode = fasterNode.next;
            }
        }

        assert slowerNode != null;
        return slowerNode.data;
        // Your code here.
    }
}
