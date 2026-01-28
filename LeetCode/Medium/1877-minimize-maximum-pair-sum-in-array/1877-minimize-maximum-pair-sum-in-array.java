import java.util.*;

class Solution {
    public int minPairSum(int[] nums) {
    	int maxSum = 0;
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = 0; i < n; i++) {
			maxSum = Math.max(maxSum, nums[i]+nums[n-1-i]);
		}
    	
    	return maxSum;
    }
}