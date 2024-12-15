import java.util.stream.IntStream;

class Solution {
    public int solution(String[] strArr) {
        int[] arrLength = new int[31];
        for (String str : strArr) {
        	arrLength[str.length()]++;
        }
        return IntStream.of(arrLength).max().orElseThrow();
    }
}