import java.util.stream.IntStream;

class Solution {
    public int[] solution(int[] num_list, int n) {
        return IntStream.iterate(0, i -> i < num_list.length, i -> i + n)
                .map(i -> num_list[i])
                .toArray();
    }
}