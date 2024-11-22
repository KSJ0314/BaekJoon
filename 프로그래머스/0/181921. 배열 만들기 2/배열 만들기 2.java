import java.util.ArrayList;

class Solution {
    public int[] solution(int l, int r) {
        ArrayList<Integer> answerList = new ArrayList<>();
		int i = 0;
		int binaryToInt = 0;
		while (binaryToInt <= r) {
			i++;
			binaryToInt = Integer.parseInt(Integer.toBinaryString(i)) * 5;
			if (binaryToInt > r) break;
			if (binaryToInt >= l) answerList.add(binaryToInt);
		}
		
		int[] answer;
		if (answerList.isEmpty()) {
			answer = new int[]{-1};
		} else {
			answer = answerList.stream().mapToInt(j -> j).toArray();
		}
        return answerList.isEmpty() ? new int[]{-1} : answerList.stream().mapToInt(j -> j).toArray();
    }
}