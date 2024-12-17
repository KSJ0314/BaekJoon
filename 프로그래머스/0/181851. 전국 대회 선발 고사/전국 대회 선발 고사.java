import java.util.*;

class Solution {
    public int solution(int[] rank, boolean[] attendance) {
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
		
		for (int i = 0; i < rank.length; i++) {
			if (attendance[i]) {
				treeMap.put(rank[i], i);
			}
		}
		
		int answer = 0;
		int op = 10000;
		for (int value : treeMap.values()) {
			answer += value*op;
			op /= 100;
			if (op == 0) break;
		}
		return answer;
	}
}