package hackerrank;

//import org.junit.platform.commons.util.CollectionUtils;

import java.util.*;
import java.io.*;

class Node {
    Node left;
    Node right;
    int data;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class LCA {

	/*
    class Node
    	int data;
    	Node left;
    	Node right;
	*/

    public static Node search(Node root,int n, List<Integer> listNode){
        if(root!=null)
            listNode.add(root.data);

        if(root==null || root.data==n)
            return root;

        if(root.data>n)
            return search(root.left, n, listNode);

        return search(root.right, n,listNode);
    }

    public static Node lca(Node root, int v1, int v2) {
        // Write your code here.
        List<Integer> historyV1 = new ArrayList<>();
        List<Integer> historyV2 = new ArrayList<>();
        Node foundNodeV1 = search(root,v1,historyV1);
        Node foundNodeV2 = search(root,v2,historyV2);



        if (foundNodeV1 == null || foundNodeV2==null) {
            System.out.println("One of the nodes is not found");
        }
        else {
            if(historyV1.size()>0 && historyV2.size()>0){
                historyV1.retainAll(historyV2);
            }


            List<Integer> intersectList = historyV1.size()>0?historyV1:historyV2;
            Integer max;
            /*if(intersectList.size()>1) {
                max = historyV1.stream().min((s1, s2) -> Integer.compare(s1, s2)).get();
            }
            else {
                max = intersectList.get(0);
            }*/
            max = intersectList.get(intersectList.size()-1);
            return search(root,max,new ArrayList<Integer>());
        }
        return null;
    }

    public static Node insert(Node root, int data) {
        if(root == null) {
            return new Node(data);
        } else {
            Node cur;
            if(data <= root.data) {
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        Node root = null;
        while(t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
        int v1 = scan.nextInt();
        int v2 = scan.nextInt();
        scan.close();



        Node ans = lca(root,v1,v2);
        System.out.println(ans.data);
    }
}
