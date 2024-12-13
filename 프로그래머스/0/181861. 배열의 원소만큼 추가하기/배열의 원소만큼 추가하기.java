import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        ArrayList<Integer> list = new ArrayList<>();
		
		for (int i : arr) {
			for (int j = 0; j < i; j++) {
				list.add(i);
			}
		}
        
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}