class Solution {
    public int minimumPairRemoval(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int num : nums){
            list.add(num);
        }
        int cnt = 0;
        boolean isEnd = false;
        while (!isEnd) {
            isEnd = true;
            int temp = Integer.MIN_VALUE;
            for (int num : list){
                if (temp > num){
                    isEnd = false;
                    break;
                }
                temp = num;
            }
            if (isEnd) break;

            cnt++;
            int idx = -1;
            int minSum = Integer.MAX_VALUE;
            for (int i = 0; i < list.size()-1; i++){
                if (minSum > list.get(i)+list.get(i+1)) {
                    minSum = list.get(i)+list.get(i+1);
                    idx = i;
                }
            }
            list.set(idx, minSum);
            list.remove(idx+1);
        }
        return cnt;
    }
}