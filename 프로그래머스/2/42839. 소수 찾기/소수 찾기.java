import java.util.HashSet;

class Solution {
	int n;
	int[] nums;
	HashSet<Integer> primeSet;
	
    public int solution(String numbers) {
    	n = numbers.length();
    	nums = new int[n];
    	for (int i = 0; i < n; i++) {
			nums[i] = numbers.charAt(i) - '0';
		}
    	primeSet = new HashSet<>();
    	
    	perm(0, 0, 0);
    	
        return primeSet.size();
    }
    
    public void perm(int depth, int num, int flag) {
    	if (depth == n) {
    		if (isPrime(num)) primeSet.add(num);
    		return;
    	}
    	
    	for (int i = 0; i < n; i++) {
			if ((flag&1<<i) != 0) continue;
			perm(depth+1, num*10+nums[i], flag|1<<i);
			perm(depth+1, num, flag|1<<i);
		}
    }
    
    public boolean isPrime(int num) {
    	if (num == 0 || num == 1) return false;
    	for (int i = 2; i <= Math.sqrt(num); i++) {
			if (num%i == 0) return false;
		}
    	return true;
    }
}