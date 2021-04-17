package linkedlist;

public class DoublyLinkedList {
    public DoublyLinkedNode insertAtEnd(DoublyLinkedNode head, DoublyLinkedNode node) {
        if (head == null) {
            head = node;
        } else {
            DoublyLinkedNode current = head;
            while (current.next != null)
                current = current.next;

            current.next = node;
            node.prev = current;

        }
        return head;
    }

    public DoublyLinkedNode insertAtBeginning(DoublyLinkedNode head, DoublyLinkedNode node) {
        if (head != null) {
            head.prev = node;
            node.next = head;
        }
        head = node;
        return head;
    }

    public DoublyLinkedNode insertionSortInsert(DoublyLinkedNode head, DoublyLinkedNode node){
        DoublyLinkedNode current = head;
        if(node==head){
            return head;
        }

        while((node.value >= current.value) && current!=node){
            current = current.next;
        }

        if(current!=node){
            DoublyLinkedNode prevNodeOfCurrentPointer = current.prev;

            node.prev.next = node.next;
            if(node.next!=null){
                node.next.prev = node.prev;
            }

            node.prev = current.prev;
            //node.next = node.next.prev;
            node.next = current;
            node.next.prev = node;

            if(node.prev != null){
                node.prev.next = node;
            }

            if(prevNodeOfCurrentPointer==null){
                head = node;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();
        DoublyLinkedNode node = new DoublyLinkedNode(10,null,null);
        DoublyLinkedNode head = doublyLinkedList.insertAtEnd(null,node);
        head = doublyLinkedList.insertAtEnd(head,new DoublyLinkedNode(2,null,null));
        head = doublyLinkedList.insertAtEnd(head,new DoublyLinkedNode(300,null,null));
        head = doublyLinkedList.insertAtEnd(head,new DoublyLinkedNode(15,null,null));
        head = doublyLinkedList.insertAtEnd(head,new DoublyLinkedNode(115,null,null));
        head = doublyLinkedList.insertAtEnd(head,new DoublyLinkedNode(5,null,null));
        head = doublyLinkedList.insertAtEnd(head,new DoublyLinkedNode(51,null,null));

        DoublyLinkedNode currentNode = head;
        DoublyLinkedNode nextNode = currentNode.next;
        while(currentNode != null){
            head = doublyLinkedList.insertionSortInsert(head, currentNode);
            currentNode = nextNode;
            if(nextNode!=null) {
                nextNode = nextNode.next;
            }
        }
        System.out.println(head);
    }
}
