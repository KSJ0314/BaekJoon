class Solution {
    public int[] minBitwiseArray(List<Integer> nums) {
        int max = 0;
        for (int num : nums){
            max = Math.max(max, num);
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < max; i++){
            if (!map.containsKey(i|i+1)) map.put(i|i+1, i);
        }
        int[] answer = new int[nums.size()];
        int i = 0;
        for (int num : nums){
            answer[i++] = map.containsKey(num) ? map.get(num) : -1;
        }
        return answer;
    }
}