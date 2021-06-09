package tree;

import static tree.BstTraversal.heightOfBst;
import static tree.BstTraversal.printLevelOrder;

public class ConstructBST {

    private static Node addNodeToTree(Node root, Node newNode){
        if(root == null){
            return newNode;
        }

        if(newNode.data < root.data)
            root.left = addNodeToTree(root.left, newNode);
        else
            root.right = addNodeToTree(root.right, newNode);

        return root;
    }

    public static void main(String[] args) {
        int[] nums = {10, 5, 1, 7, 40, 50};

        Node rootNode = null;
        for (int n: nums
             ) {
            rootNode = addNodeToTree(rootNode, new Node(n));
        }
        //BstTraversal.printInOrder(rootNode);
        System.out.println("Height of Bst is:::" + heightOfBst(rootNode, 1));
        printLevelOrder(rootNode,1,1);
        System.out.println("--------------------------");
        printLevelOrder(rootNode,2,1);
        System.out.println("--------------------------");
        printLevelOrder(rootNode,3,1);
    }
}
