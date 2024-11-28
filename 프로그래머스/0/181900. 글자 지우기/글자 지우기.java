import java.util.*;

class Solution {
    public String solution(String my_string, int[] indices) {
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < my_string.length(); i++) {
        	int currentIndex = i;
        	boolean isContain = Arrays.stream(indices)
        							.anyMatch(num -> num == currentIndex);
        	if (!isContain) {
        		sb.append(my_string.charAt(i));
        	}
        }
        
        return sb.toString();
    }
}