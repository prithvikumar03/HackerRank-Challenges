package hackerrank;

import java.io.*;
import java.util.*;

//import hr.LCA.*;

/*class hr.Node{
    Integer i=-1;
    hr.Node left=null;
    hr.Node right=null;
}*/



public class SwapNodes {

static void traverse(Node root,List<Integer> tree_path){
    if(root!=null && root.left!=null){
        traverse(root.left,tree_path);
    }

    if(root.right!=null) {
        tree_path.add(root.data);
        traverse(root.right, tree_path);
    }
    else{
        tree_path.add(root.data);
    }

    return;

}

 static int[][] swapNodes(int[][] indexes, int[] queries) {
        /*
         * Write your code here.
         */

     int[][] ret_array = new int[queries.length][];

     Map<Integer,List<Node>> levelMap = new HashMap<>();

     List<Node> numList = new ArrayList<>();
     numList.add(new Node(1));
     levelMap.put(1,numList);

     Integer level=1;
     int j=0;
     int[] index = indexes[j];

     while(j<indexes.length){
         int size = (int) levelMap.get(level).stream().filter(s -> s!=null).count();
         level++;
         numList = new ArrayList<>();
         for(int i=j;i<j+size;i++){
             int temp1 = indexes[i][0];
             int temp2 = indexes[i][1];
             numList.add(temp1==-1?null:new Node(temp1));
             numList.add(temp2==-1?null:new Node(temp2));
         }
         levelMap.put(level,numList);
         j=j+size;
     }

     //Node node = new Node(1);
     Integer levels = levelMap.keySet().size();
     for(int x=1;x<levels;x++){
         List<Node> nodes = levelMap.get(x);
         List<Node> nodes_nextlevel = levelMap.get(x+1);

         int i=0;
         for(Node node: nodes){
             if(node!=null){
                 node.left = nodes_nextlevel.get(i);
                 node.right=nodes_nextlevel.get(i+1);
                 i+=2;
             }
         }
     }

     int m=0;
     for(int query: queries){

         int aa=1;

         while(query*aa<levels) {
             List<Node> nodes = levelMap.get(query*aa);
             for (Node node : nodes) {
                 if (node != null) {
                     Node temp = node.left;
                     node.left = node.right;
                     node.right = temp;
                 }
             }
             aa++;
         }

         List<Integer> traverse_path = new ArrayList<>();
         traverse(levelMap.get(1).get(0),traverse_path);
         ret_array[m] = traverse_path.stream().mapToInt(i->i).toArray();
         m++;
     }


     return ret_array;
 }



    /*
     * Complete the swapNodes function below.
     */
    static int[][] swapNodes1(int[][] indexes, int[] queries) {
        /*
         * Write your code here.
         */

        Map<Integer,List<Integer>> levelMap = new HashMap<>();

        List<Integer> numList = new ArrayList<>();
        numList.add(1);
        levelMap.put(1,numList);

        Integer level=1;
        int j=0;
        int[] index = indexes[j];

        while(j<indexes.length){
            int size = (int) levelMap.get(level).stream().filter(s -> s!=-1).count();
            level++;
            numList = new ArrayList<>();
            for(int i=j;i<j+size;i++){
                numList.add(indexes[i][0]);
                numList.add(indexes[i][1]);
            }
            levelMap.put(level,numList);
            j=j+size;
        }


        /*for(int[] a : indexes){
            for(int b: a){
                System.out.println(b);
            }
        }*/

        for(int query: queries){

            List<Integer> integers = levelMap.get(query + 1);
            for(int k=0;k<integers.size();k+=2){
                Collections.swap(integers,k,k+1);
            }
            levelMap.put(query+1,integers);
        }

        Node node = new Node(1);
        Integer levels = levelMap.keySet().size();
        for(int x=levels;x>0;x--){
            List<Integer> integers = levelMap.get(x);

        }



        return null;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(scanner.nextLine().trim());

        int[][] indexes = new int[n][2];

        for (int indexesRowItr = 0; indexesRowItr < n; indexesRowItr++) {
            String[] indexesRowItems = scanner.nextLine().split(" ");

            for (int indexesColumnItr = 0; indexesColumnItr < 2; indexesColumnItr++) {
                int indexesItem = Integer.parseInt(indexesRowItems[indexesColumnItr].trim());
                indexes[indexesRowItr][indexesColumnItr] = indexesItem;
            }
        }

        int queriesCount = Integer.parseInt(scanner.nextLine().trim());

        int[] queries = new int[queriesCount];

        for (int queriesItr = 0; queriesItr < queriesCount; queriesItr++) {
            int queriesItem = Integer.parseInt(scanner.nextLine().trim());
            queries[queriesItr] = queriesItem;
        }

        int[][] result = swapNodes(indexes, queries);

        for (int resultRowItr = 0; resultRowItr < result.length; resultRowItr++) {
            for (int resultColumnItr = 0; resultColumnItr < result[resultRowItr].length; resultColumnItr++) {
                bufferedWriter.write(String.valueOf(result[resultRowItr][resultColumnItr]));

                if (resultColumnItr != result[resultRowItr].length - 1) {
                    bufferedWriter.write(" ");
                }
            }

            if (resultRowItr != result.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();
    }
}

