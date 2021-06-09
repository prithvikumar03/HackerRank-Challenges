package tree;

import java.util.ArrayList;
import java.util.Stack;

public class BstTraversal {

    public static void printInOrder(Node node){
        if(node == null)
            return;

        printInOrder(node.left);
        System.out.println(node.data);
        printInOrder(node.right);
    }

    public static ArrayList<Integer> printInOrderArrayList(Node node){
        Stack<Node> stack = new Stack<>();
        ArrayList<Integer> retList = new ArrayList<>();

        Node current = node;

        while(current != null || stack.size() >0) {

            while (stack.peek().left != null) {
                stack.push(node.left);
                current = current.left;
            }

            current = stack.pop();
            retList.add(current.data);

            current = current.right;
        }

        return retList;
    }

    public static void printPreOrder(Node node){
        if(node == null)
            return;

        System.out.println(node.data);
        printPreOrder(node.left);
        printPreOrder(node.right);
    }

    public static void printPostOrder(Node node){
        if(node == null)
            return;

        printPostOrder(node.left);
        printPostOrder(node.right);
        System.out.println(node.data);
    }

    public static void printLevelOrder(Node rootNode, int level, int currentLevel){
        if(rootNode == null)
            return;

        if(level == currentLevel)
            System.out.println(rootNode.data);

        printLevelOrder(rootNode.left, level, ++currentLevel);
        --currentLevel;
        printLevelOrder(rootNode.right, level, ++currentLevel);
        --currentLevel;

    }

    public static int heightOfBst(Node rootNode, int height){
        if(rootNode == null)
            return --height;

        int leftWingHeight = heightOfBst(rootNode.left, height+1);
        int rightWingHeight = heightOfBst(rootNode.right, height+1);

        return Math.max(leftWingHeight, rightWingHeight);
    }

    public static int getCountInRange(Node root, int l, int h){
        int count = 0;
        //Your code here
        if(root==null)
            return count;

        count += getCountInRange(root.left, l, h);
        count += getCountInRange(root.right, l, h);

        if(root.data >= l && root.data <=h)
            count++;

        return count;
    }

    boolean isBST(Node root)
    {
        // code here.
        if(root == null)
            return true;


        if(root.left!=null && root.left.data >= root.data)
            return false;
        if(root.right!=null && root.right.data <= root.data)
            return false;


        if(!isBST(root.left) || !isBST(root.right))
            return false;


        return true;


    }


}
