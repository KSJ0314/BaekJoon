import java.util.*;

class Solution {
    public int solution(int[] rank, boolean[] attendance) {
        ArrayList<Integer> list = new ArrayList<>();
		
		for (int i = 0; i < attendance.length; i++) {
			if (attendance[i]) {
				int j = 0;
				for (int num : list) {
					if (rank[num] > rank[i]) {
						break;
					}
					j++;
				}
				list.add(j, i);
			}
		}
        
		return list.get(0)*10000 + list.get(1)*100 + list.get(2);
	}
}