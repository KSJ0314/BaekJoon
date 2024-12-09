class Solution {
    public int[] solution(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
        	boolean isBig = (arr[i] >= 50);
        	boolean isEven = (arr[i] % 2 == 0);
        	
        	arr[i] *= isBig && isEven ? 0.5 
    				: !isBig && !isEven ? 2 
    				: 1;
		}
        return arr;
    }
}