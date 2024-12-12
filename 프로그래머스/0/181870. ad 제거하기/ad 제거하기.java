import java.util.stream.IntStream;

class Solution {
    public String[] solution(String[] strArr) {
        return IntStream.range(0, strArr.length)
        			.filter(i -> !strArr[i].contains("ad"))
        			.mapToObj(i -> strArr[i])
        			.toArray(String[]::new);
    }
}