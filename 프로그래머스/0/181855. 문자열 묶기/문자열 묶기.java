import java.util.*;

class Solution {
    public int solution(String[] strArr) {
        int[] arrLength = new int[31];
        for (String str : strArr) {
        	arrLength[str.length()]++;
        }
        return Arrays.stream(arrLength).max().getAsInt();
    }
}