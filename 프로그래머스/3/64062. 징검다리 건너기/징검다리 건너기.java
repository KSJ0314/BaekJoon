class Solution {
    
    public static int solution(int[] stones, int k) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int stone : stones) {
            min = Math.min(min, stone);
            max = Math.max(max, stone);
        }

        while (min < max) {
            int mid = (min + max + 1) / 2;

            // 조건을 만족하는가
            if (isPossible(mid, k, stones)) {
                // 예
                min = mid;
            } else {
                // 아니요
                max = mid - 1;
            }
        }
        return max;
    }

    public static boolean isPossible(int num, int k, int[] stones) {
        int count = 0;
        for (int stone : stones) {
            if (stone - num < 0) {
                count++;
            } else {
                count = 0;
            }

            if (count == k) {
                return false;
            }
        }
        return true;
    }
}