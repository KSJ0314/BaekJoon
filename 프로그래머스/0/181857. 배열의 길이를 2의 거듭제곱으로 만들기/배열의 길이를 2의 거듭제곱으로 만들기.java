import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        int a = arr.length;
        int b = Integer.toBinaryString(a).length();
        int c = (int) Math.pow(2, b);
        int d = (int) Math.pow(2, b-1);
        
        return a == d ? arr : Arrays.copyOf(arr, c);
    }
}   