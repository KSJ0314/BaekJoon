import java.util.*;

class Solution {
    public int[] solution(int[] arr, int[] delete_list) {
        ArrayList<Integer> list = new ArrayList<>();
        
        O : for (int i : arr) {
        	for (int j : delete_list) {
        		if (i == j) {
        			continue O;
        		}
        	}
        	list.add(i);
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}