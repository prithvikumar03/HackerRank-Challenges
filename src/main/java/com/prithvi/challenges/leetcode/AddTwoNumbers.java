package leetcode;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

class Solution {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode l1Head=l1;
        ListNode l2Head=l2;

        ListNode retListNode=null;
        ListNode retListHeadNode=null;
        int carry=0;
        while(l1Head!=null || l2Head!=null){
            int l1number=0;
            int l2number=0;
            int sum=0;

            if(l1Head!=null){
                l1number=l1Head.val;
            }
            if(l2Head!=null){
                l2number=l2Head.val;
            }

            sum=(l1number+l2number+carry)%10;
            carry=(l1number+l2number+carry)/10;

            ListNode tempNode = new ListNode((int)sum);
            if (retListNode != null) {
                retListNode.next = tempNode;
                retListNode = retListNode.next;
            } else {
                retListNode = tempNode;
                retListHeadNode = retListNode;
            }

            if(l1Head!=null){
                l1Head=l1Head.next;
            }
            if(l2Head!=null){
                l2Head=l2Head.next;
            }
        }

        if(carry!=0){
            ListNode tempNode = new ListNode(carry);
            retListNode.next = tempNode;
        }

        return retListHeadNode;
    }


    /*public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int i=0;
        long l1Number=0;
        ListNode l1Head=l1;
        while(l1Head!=null){
            l1Number = l1Number + (l1Head.val*(int)(Math.pow(10,i)));
            i++;
            l1Head = l1Head.next;
        }

        i=0;
        long l2Number=0;
        ListNode l2Head=l2;
        while(l2Head!=null){
            l2Number = l2Number + (l2Head.val*(int)(Math.pow(10,i)));
            i++;
            l2Head = l2Head.next;
        }

        long sum = l1Number + l2Number;
        ListNode retListNode=null;
        ListNode retListHeadNode=null;

        i=1;
        //int i1 = sum % ((int) Math.pow(10, i));
        if(sum>0) {
            while (sum > 0) {
                long temp = sum % 10;
                ListNode tempNode = new ListNode((int)temp);
                if (retListNode != null) {
                    retListNode.next = tempNode;
                    retListNode = retListNode.next;
                } else {
                    retListNode = tempNode;
                    retListHeadNode = retListNode;
                }
                sum = sum / 10;
            }
        }
        else{
            ListNode tempNode = new ListNode(0);
            retListHeadNode=tempNode;
        }
        return retListHeadNode;
    }*/
}

public class AddTwoNumbers {
    public static int[] stringToIntegerArray(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return new int[0];
        }

        String[] parts = input.split(",");
        int[] output = new int[parts.length];
        for(int index = 0; index < parts.length; index++) {
            String part = parts[index].trim();
            output[index] = Integer.parseInt(part);
        }
        return output;
    }

    public static ListNode stringToListNode(String input) {
        // Generate array from the input
        int[] nodeValues = stringToIntegerArray(input);

        // Now convert that list into linked list
        ListNode dummyRoot = new ListNode(0);
        ListNode ptr = dummyRoot;
        for(int item : nodeValues) {
            ptr.next = new ListNode(item);
            ptr = ptr.next;
        }
        return dummyRoot.next;
    }

    public static String listNodeToString(ListNode node) {
        if (node == null) {
            return "[]";
        }

        String result = "";
        while (node != null) {
            result += Integer.toString(node.val) + ", ";
            node = node.next;
        }
        return "[" + result.substring(0, result.length() - 2) + "]";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            ListNode l1 = stringToListNode(line);
            line = in.readLine();
            ListNode l2 = stringToListNode(line);

            ListNode ret = new Solution().addTwoNumbers(l1, l2);

            String out = listNodeToString(ret);

            System.out.print(out);
        }
    }
}