import java.util.*;
import java.util.stream.IntStream;

class Solution {
    public int[] solution(int[] num_list, int n) {
        return IntStream.range(n, num_list.length+n).map(i-> num_list[i%num_list.length]).toArray();
    }
}