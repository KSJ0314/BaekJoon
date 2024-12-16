import java.util.stream.IntStream;

class Solution {
    public int[] solution(int[] num_list) {
        return IntStream.of(num_list).sorted().skip(5).toArray();
    }
}