import java.util.HashMap;
import java.util.Map;

public class HackerRankTest {

    public static void main(final String[] args) {
        final String s1 = "absdjkvuahdakejfnfauhdsaavasdlkj";
        final String s2 = "djfladfhiawasdkjvalskufhafablsdkashlahdfa";

        String temp1 = s1.replaceAll("(.)\\1{1,}", "$1");
        String temp2 = s2.replaceAll("(.)\\1{1,}", "$1");

        HackerRankTest.commonCharacterCount(s1,s2);
        /*int x= (int) temp1.chars()
                .distinct()
                .mapToObj(ch -> 0)
                .filter(temp2::contains).count();

        System.out.println(temp1.length());
        System.out.println(temp2.length());
        System.out.println(x);*/
    }

    public static Map<Character,Integer> getCharacterCount(String s){
        Map<Character,Integer> characterCount = new HashMap<>();
        for(char c:  s.toCharArray()){
            characterCount.put(c,characterCount.computeIfAbsent(c,count -> 0)+1);
        }

        return characterCount;
    }

    public static int commonCharacterCount(String s1, String s2){

        Map<Character, Integer> characterCountS1 = getCharacterCount(s1);
        Map<Character, Integer> characterCountS2 = getCharacterCount(s2);

        int sum = characterCountS1.keySet().stream().filter(characterCountS2.keySet()::contains).mapToInt(c -> Math.min(
                characterCountS1.get(c), characterCountS2.get(c)
        )).sum();

        System.out.println(s1.length()+s2.length()-(2*sum));

        return s1.length()+s2.length()-(2*sum);

    }

    public static boolean isPalindrome(String s){
        char[] chars = s.toCharArray();

        for(int i=0,j=chars.length-1;i<(chars.length+1)/2;i++,j--){
            if(chars[i]!=chars[j]){
                return false;
            }
        }
        return true;
    }

    public static int palindromeIndex(String s) {
        if(HackerRankTest.isPalindrome(s)){
            return -1;
        }
        else{
            for(int i=0;i<s.length();i++){
                String s1 = s.substring(0, i) + s.substring(i + 1);
                if(HackerRankTest.isPalindrome(s1)){
                    return i;
                }
            }
        }

        return -1;
    }

    public static int getPalindromeIndex(String s){
        char[] chars = s.toCharArray();
        StringBuilder sb = new StringBuilder(s);

        for(int i=0,j=chars.length-1;i<(chars.length+1)/2;i++,j--){
            if(chars[i]!=chars[j]){
                if(chars[i+1]==chars[j]){
                    if(isPalindrome(sb.deleteCharAt(i).toString())){
                        return i;
                    }
                    return j;
                }
                else{
                    return j;
                }
            }
        }
        return -1;
    }

}
