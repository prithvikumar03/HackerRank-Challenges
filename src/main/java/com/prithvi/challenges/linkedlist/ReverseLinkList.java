package linkedlist;

public class ReverseLinkList {

    public Node reverseLinkList(Node head){
        if(head==null || head.nextNode==null){
            return head;
        }
        else{
            Node currentNode = head;
            Node nextNode = head.nextNode;
            currentNode.nextNode = null;
            while(nextNode!=null){
                Node temp = nextNode.nextNode;
                nextNode.nextNode = currentNode;
                currentNode = nextNode;
                nextNode = temp;
            }
            return currentNode;
        }
    }

    public static void main(String[] args) {
        InsertLinkedList insertLinkedList = new InsertLinkedList();
        Node headNode = insertLinkedList.solution(null, 10);
        headNode = insertLinkedList.solution(headNode,7);
        headNode = insertLinkedList.solution(headNode,2);
        headNode = insertLinkedList.solution(headNode,3);
        headNode = insertLinkedList.solution(headNode,1);

        ReverseLinkList reverseLinkList = new ReverseLinkList();
        Node nodeAfterReversing = reverseLinkList.reverseLinkList(headNode);
        System.out.println(nodeAfterReversing);
    }
}
