package linkedlist;

public class InsertLinkedList {


    public Node solution(Node headNode, int element){

        //No elements are present
        if(headNode == null){
            Node node = new Node();
            node.data = element;
            node.next = null;
            headNode = node;
        }
        //Only head node is present

        //More than one elements are present
        else{
            Node nextNode;
            Node currentNode = headNode;
            while(currentNode != null){
                nextNode = currentNode.next;
                if((currentNode==headNode && nextNode == null)){
                    Node node = new Node();
                    node.data = element;
                    if(currentNode.data > element){
                        node.next = currentNode;
                        headNode = node;
                    }
                    else{
                        currentNode.next = node;
                    }
                    break;
                }
                else if((currentNode==headNode && element < currentNode.data)){
                    Node node = new Node();
                    node.data = element;
                    node.next = currentNode;
                    headNode = node;
                    break;
                }
                else if(nextNode == null){
                    Node node = new Node();
                    node.data = element;
                    currentNode.next = node;
                    break;
                }
                else if(element>=currentNode.data && element<=nextNode.data){
                    Node node = new Node();
                    node.data = element;
                    node.next = nextNode;
                    currentNode.next = node;
                    break;
                }
                //Have to check in advance as the element insertion has to happen before traversing to
                //the node whose 'i' is greater than the given element
                /*if(currentNode==headNode){

                }
                else if(currentNode.nextNode!=null && currentNode.nextNode.i > element){
                    Node node = new Node();
                    node.i = element;
                    node.nextNode = currentNode.nextNode;
                    currentNode.nextNode = node;
                    break;
                }
                else if(currentNode.nextNode == null){
                    Node node = new Node();
                    node.i = element;

                    if(currentNode.i>element){
                        node.nextNode = headNode;
                        headNode = node;
                    }
                    else{
                        currentNode.nextNode = node;
                        node.nextNode = null;
                    }
                }*/
                currentNode = currentNode.next;
            }
        }
        return headNode;
    }


    public static void main(String[] args) {
        InsertLinkedList insertLinkedList = new InsertLinkedList();
        Node headNode = insertLinkedList.solution(null, 10);
        headNode = insertLinkedList.solution(headNode,7);
        headNode = insertLinkedList.solution(headNode,2);
        headNode = insertLinkedList.solution(headNode,3);
        headNode = insertLinkedList.solution(headNode,1);
        System.out.println("Done");
    }
}
