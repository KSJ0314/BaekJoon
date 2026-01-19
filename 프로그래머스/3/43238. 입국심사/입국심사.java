class Solution {
    public long solution(int n, int[] times) {
        int T = 0;
        for (int i = 0; i < times.length; i++) {
			T = Math.max(T, times[i]);
		}
        long answer = (long) n * T;
        long left = 1;
        long right = answer;
        while (left <= right) {
        	long mid = (right+left)/2;
        	long sum = 0;
        	for (int i = 0; i < times.length; i++) {
				sum += mid/times[i];
				if (sum >= n) break;
			}
        	
        	if (sum >= n) { // n명 이상 처리 가능함
                answer = mid;
        		right = mid-1;
        	} else { // n명 이상 처리가 불가능함
        		left = mid+1;
        	}
        }
        return answer;
    }
}