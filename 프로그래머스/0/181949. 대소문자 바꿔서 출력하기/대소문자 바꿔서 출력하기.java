import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        
        char[] ch = a.toCharArray();
        
        for (int i : ch) {
        	char c = (char) (i^32);
        	System.out.print(c);
        }
    }
}