import java.util.*;

class Solution {
    public int solution(int[] arr) {
		int count = 0;
		while (true) {
			int[] copyArr = Arrays.copyOf(arr, arr.length);
			if (Arrays.equals(copyArr, cal(arr))) break;
			count++;
		}
		return count;
    }
	
	public int[] cal(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			boolean isBig = (arr[i] >= 50);
			boolean isEven = (arr[i] % 2 == 0);
			
			if (isBig && isEven) {
				arr[i] /= 2;
			} else if (!isBig && !isEven) {
				arr[i] = arr[i]*2 +1;
			}
		}
		return arr;
	}
}