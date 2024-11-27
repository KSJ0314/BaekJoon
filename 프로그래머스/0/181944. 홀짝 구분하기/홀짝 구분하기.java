import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        String str;
        if (n%2 == 0){
            str = " is even";
        } else {
            str = " is odd";
        }
        System.out.print(n + str);
    }
}