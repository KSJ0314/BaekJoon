import java.util.*;

class Solution {
    public int[] solution(int n, int[] slicer, int[] num_list) {
        int first = (n == 1) ? 0 : slicer[0];
        int count = (n == 2) ? num_list.length - 1 : slicer[1];
        int increase = (n == 4) ? slicer[2] : 1;
        
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = first; i <= count; i += increase) {
			list.add(num_list[i]);
		}
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}