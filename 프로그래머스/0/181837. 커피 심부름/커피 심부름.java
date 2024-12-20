import java.util.stream.IntStream;

class Solution {
    public int solution(String[] order) {
        return IntStream.range(0, order.length)
					.reduce(0, (a,b) -> order[b].contains("cafelatte") ? a + 5000 : a + 4500);
    }
}