import java.util.*;

class Solution {
    public int[] solution(int[] arr, int[] delete_list) {
        ArrayList<Integer> list = new ArrayList<>();
        
        for (int i : arr) {
        	list.add(i);
        }
        for (int i : delete_list) {
        	list.remove(Integer.valueOf(i));
        }
        
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}