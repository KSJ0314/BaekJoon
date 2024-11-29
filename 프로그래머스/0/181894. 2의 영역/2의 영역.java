import java.util.*;
import java.util.stream.IntStream;

class Solution {
    public int[] solution(int[] arr) {
        int[] answer = IntStream.range(0, arr.length).filter(i -> arr[i] == 2).toArray();
		
        switch (answer.length) {
			case 0:
				return new int[] {-1};
			case 1:
				return new int[] {2};
			default:
				return Arrays.copyOfRange(arr, answer[0], answer[answer.length-1] + 1);
		}
    }
}