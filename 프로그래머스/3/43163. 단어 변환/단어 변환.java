import java.util.*;

class Solution {
	public boolean canTransformWord(String str1, String str2) {
		boolean chance = true;
		for (int i = 0; i < str1.length(); i++) {
			if (str1.charAt(i) != str2.charAt(i)) {
				if (chance) {
					chance = false;
					continue;
				}
				return false;
			}
		}
		return true;
	}
    public int solution(String begin, String target, String[] words) {
    	Deque<Integer> deque = new ArrayDeque<>();
    	int targetIdx = -1;
    	ArrayList<Integer>[] list = new ArrayList[words.length];
    	for (int i = 0; i < words.length; i++) {
    		if (canTransformWord(begin, words[i])) deque.addLast(i);
    		if (target.equals(words[i])) targetIdx = i;
			list[i] = new ArrayList<>();
			for (int j = 0; j < words.length; j++) {
				if (i == j) continue;
				if (canTransformWord(words[i], words[j])) list[i].add(j);
			}
		}

    	boolean[] isVisited = new boolean[words.length];
    	for (int level = 1; !deque.isEmpty(); level++) {
    		for (int size = deque.size(); size > 0; size--) {
    			int idx = deque.pollFirst();
    			if (idx == targetIdx) return level;
        		for (int nextIdx : list[idx]) {
        			if (isVisited[nextIdx]) continue;
        			isVisited[nextIdx] = true;
        			deque.addLast(nextIdx);
        		}
    		}
    	}
    	
        return 0;
    }
}