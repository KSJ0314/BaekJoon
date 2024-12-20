import java.util.function.BiFunction;

class Solution {
    public int[] solution(int[] arr, int k) {
        BiFunction<Integer, Integer, Integer> cal;
		if (k % 2 == 1) {
			cal = (a, b) -> a*b;
		} else {
			cal = (a, b) -> a+b;
		}
        
        for (int i = 0; i < arr.length; i++) {
            arr[i] = cal.apply(arr[i], k);
        }
        
        return arr;
    }
}