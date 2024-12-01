import java.util.stream.IntStream;

class Solution {
	public int solution(int[] num_list) {
        int evenSum = 0;
		int oddSum = 0;
		boolean isEven = true;
		
		for (int i = 0; i < num_list.length; i++, isEven = !isEven) {
			if (isEven) {
				evenSum += num_list[i];
			} else {
				oddSum += num_list[i];
			}
		}
		return Math.max(evenSum, oddSum);
    }
}