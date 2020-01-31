package others;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;



public class DistinctPath {

    class Tree{
        public int x;
        public Tree l;
        public Tree r;
    }

    public int solution(Tree T) {
        // write your code in Java SE 8
       /* List<Integer> leftDistPath = new ArrayList<>();
        List<Integer> rightDistPath = new ArrayList<>();
        if(T!=null){
            leftDistPath.add(T.x);
            rightDistPath.add(T.x);
            traverse(T.l,leftDistPath);
            traverse(T.r,rightDistPath);
        }
        return Math.max(leftDistPath.size(),rightDistPath.size());*/


        HashMap<Integer,Integer> leftDistPath = new HashMap<>();
        HashMap<Integer,Integer> rightDistPath = new HashMap<>();
        if(T!=null){
            leftDistPath.put(1,T.x);
            rightDistPath.put(1,T.x);
            traverse1(T.l,leftDistPath,1);
            traverse1(T.r,rightDistPath,1);
        }
        return Math.max(leftDistPath.keySet().size(),rightDistPath.keySet().size());
    }

    static void traverse(Tree root,List<Integer> distinctPath){
        if(root!=null ){
            if(!distinctPath.contains(root.x)){
                distinctPath.add(root.x);
                traverse(root.l,distinctPath);
                traverse(root.r,distinctPath);
            }
        }
        return;
    }

    static void traverse1(Tree root,HashMap<Integer,Integer> distinctPath,int level){
        if(root!=null ){
            if(!distinctPath.containsValue(root.x)){
                distinctPath.put(level,root.x);
                level++;
                traverse1(root.l,distinctPath,level);
                traverse1(root.r,distinctPath,level);
            }
            level--;
        }
        return;

    }
}
