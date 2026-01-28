class Solution {
    public int[] minBitwiseArray(List<Integer> nums) {
        int[] ans = new int[nums.size()];
        for (int i = 0; i < nums.size(); i++){
            int num = nums.get(i);
            if (num % 2 == 0){
                ans[i] = -1;
                continue;
            }
            int k = 0;
            while (((num >> k) & 1) == 1) {
                k++;
            }
            ans[i] = num - (1 << k-1);
        }
        return ans;
    }
}