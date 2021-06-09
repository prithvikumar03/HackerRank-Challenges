package linkedlist;


public class NthFromLast {

    static int getNthFromLast(Node head, int n)
    {


        Node lookAhead = head;
        Node follow = head;

        int i = 0;
        while(i<n && lookAhead!=null){

            lookAhead = lookAhead.next;
            i++;
        }

        if(lookAhead == null && i<n){
            //System.out.println(n);
            return -1;
        }



        while(lookAhead!=null){
            follow = follow.next;
            lookAhead = lookAhead.next;
        }

        return follow.data;
        // Your code here
    }

    public static void main(String[] args) {
        LinkedList llist = new LinkedList();
        Node new_node;
        new_node = llist.newNode(334);
        llist.sortedInsert(new_node);
        new_node = llist.newNode(500);
        System.out.println(getNthFromLast(llist.head, 2));
    }
}
