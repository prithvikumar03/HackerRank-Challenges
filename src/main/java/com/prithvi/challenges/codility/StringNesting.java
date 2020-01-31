package codility;

public class StringNesting {

    public int solution(String S) {
        // write your code in Java SE 8
        if(S==null || S.length()==0)
            return 1;
        else{
            int leftBracketCount=0;

            for(int i=0;i<S.length();i++){
                char c = S.charAt(i);
                if(c=='(')
                    leftBracketCount++;
                else if(c==')'){
                    if(leftBracketCount==0)
                        return 0;
                    else
                        leftBracketCount--;
                }
            }
            return leftBracketCount==0?1:0;
        }
    }

    public static void main(String[] args){
        //{-1,5,3,4,7} {-5,-5,-5,-42,6,12}
        String input =  "((((()(())()))";
        int solution = new StringNesting().solution(input);
        System.out.println(solution);
    }
}