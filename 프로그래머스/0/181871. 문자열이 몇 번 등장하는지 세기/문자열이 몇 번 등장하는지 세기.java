import java.util.stream.IntStream;

class Solution {
    public int solution(String myString, String pat) {
        return (int) IntStream.range(0, myString.length())
	        			.filter(i -> myString.substring(i).startsWith(pat))
	        			.count();
    }
}