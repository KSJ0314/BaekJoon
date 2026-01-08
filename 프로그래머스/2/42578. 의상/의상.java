import java.util.*;

class Solution {
	public int solution(String[][] clothes) { 
        int answer = 1;
        HashMap<String, Integer> map = new HashMap<>();
        for (String[] clothesStr : clothes) {
        	map.merge(clothesStr[1], 1, Integer::sum);
        }
        for (String key : map.keySet()) {
        	int count = map.get(key);
        	answer *= count+1;
        }
        return answer-1;
    }
}