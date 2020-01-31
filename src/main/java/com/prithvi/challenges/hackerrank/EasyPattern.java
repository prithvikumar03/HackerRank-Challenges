package hackerrank;

import java.util.ArrayList;
import java.util.List;

public class EasyPattern {

    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        int n=9;
        int middle = n%2==1?((n*2)/2):((n*2)/2)-1;

        List<String> patternList = new ArrayList<>();

        for(int j=0;j<n*2-1;j++){

            if(j%2==1)
                patternList.add(" ");
            else {
                if(j%4==0)
                    patternList.add("x");
                else
                    patternList.add("o");
            }
        }

        String temp1="";
        for(String temp: patternList) {

            temp1 = temp1 + temp;
        }

        System.out.println(middle);


        List<String> repeatList = patternList.subList(middle-1, patternList.size());

        temp1="";
        for(String temp: repeatList) {
            //System.out.println(temp.equals(" ")?"space":temp);
            temp1 = temp1 + temp;
        }





        for(int i=0;i<n-1;i++){
            List<String> strings = repeatList.subList(n - (i+1), repeatList.size());
            String temp2="";
            for(String xx: strings){
                temp2=temp2+xx;
            }
            System.out.println(temp2);

        }

        System.out.println(temp1);
    }

}
