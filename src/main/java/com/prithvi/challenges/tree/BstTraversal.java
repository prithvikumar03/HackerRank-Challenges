package tree;

public class BstTraversal {

    public static void printInOrder(BstNode bstNode){
        if(bstNode == null)
            return;

        printInOrder(bstNode.leftNode);
        System.out.println(bstNode.i);
        printInOrder(bstNode.rightNode);
    }

    public static void printPreOrder(BstNode bstNode){
        if(bstNode == null)
            return;

        System.out.println(bstNode.i);
        printPreOrder(bstNode.leftNode);
        printPreOrder(bstNode.rightNode);
    }

    public static void printPostOrder(BstNode bstNode){
        if(bstNode == null)
            return;

        printPostOrder(bstNode.leftNode);
        printPostOrder(bstNode.rightNode);
        System.out.println(bstNode.i);
    }

    public static void printLevelOrder(BstNode rootNode, int level, int currentLevel){
        if(rootNode == null)
            return;

        if(level == currentLevel)
            System.out.println(rootNode.i);

        printLevelOrder(rootNode.leftNode, level, ++currentLevel);
        --currentLevel;
        printLevelOrder(rootNode.rightNode, level, ++currentLevel);
        --currentLevel;

    }

    public static int heightOfBst(BstNode rootNode, int height){
        if(rootNode == null)
            return --height;

        int leftWingHeight = heightOfBst(rootNode.leftNode, height+1);
        int rightWingHeight = heightOfBst(rootNode.rightNode, height+1);

        return Math.max(leftWingHeight, rightWingHeight);
    }
}
