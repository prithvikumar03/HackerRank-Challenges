package tree;

import static tree.BstTraversal.heightOfBst;
import static tree.BstTraversal.printLevelOrder;

public class ConstructBST {

    private static BstNode addNodeToTree(BstNode root, BstNode newNode){
        if(root == null){
            return newNode;
        }

        if(newNode.i < root.i)
            root.leftNode = addNodeToTree(root.leftNode, newNode);
        else
            root.rightNode = addNodeToTree(root.rightNode, newNode);

        return root;
    }

    public static void main(String[] args) {
        int[] nums = {10, 5, 1, 7, 40, 50};

        BstNode rootNode = null;
        for (int n: nums
             ) {
            rootNode = addNodeToTree(rootNode, new BstNode(n));
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
