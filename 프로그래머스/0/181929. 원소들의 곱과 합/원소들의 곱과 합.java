import java.util.Arrays;

class Solution {
    public int solution(int[] num_list) {
        int mul = Arrays.stream(num_list).reduce(1, (a,b) -> a*b);
        double sumPow = Math.pow(Arrays.stream(num_list).sum(), 2);
        return mul <= sumPow ? 1 : 0;
    }
}