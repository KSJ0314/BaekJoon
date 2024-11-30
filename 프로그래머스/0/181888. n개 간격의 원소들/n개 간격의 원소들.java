import java.util.stream.IntStream;

class Solution {
    public int[] solution(int[] num_list, int n) {
        int size = (int)Math.ceil((double)num_list.length / n);
		int[] answer = new int[size];
		for (int i = 0; i < size; i++) {
			answer[i] = num_list[i*n];
		}
        return answer;
    }
}