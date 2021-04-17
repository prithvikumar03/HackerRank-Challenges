package linkedlist;

public class DoublyLinkedNode {
    int value;
    DoublyLinkedNode next, prev;

    public DoublyLinkedNode(int value, DoublyLinkedNode next, DoublyLinkedNode prev) {
        this.value = value;
        this.next = next;
        this.prev = prev;
    }
}
