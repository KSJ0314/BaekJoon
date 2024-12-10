import java.util.*;

class Solution {
    public int solution(int[] arr) {
		int count = 0;
		while (cal(arr)) {
			count++;
		}
		return count;
    }
	
	public boolean cal(int[] arr) {
		boolean boo = false;
		for (int i = 0; i < arr.length; i++) {
			boolean isBig = (arr[i] >= 50);
			boolean isEven = (arr[i] % 2 == 0);
			
			if (isBig && isEven) {
				arr[i] /= 2;
				boo = true;
			} else if (!isBig && !isEven) {
				arr[i] = arr[i]*2 +1;
				boo = true;
			}
		}
		return boo;
	}
}