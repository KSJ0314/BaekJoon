class Solution {
    public int count = 0;
	
	public int solution(int[] num_list) {
        for (int num : num_list) {
        	cal(num);
        }
        return count;
    }
	
	public void cal(int n) {
		if (n == 1){
			return;
		} else if (n % 2 == 0) {
			n /= 2;
		} else {
			n = (n - 1) / 2;
		}
		
		count++;
		cal(n);
	}
}