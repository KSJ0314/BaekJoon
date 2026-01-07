class Solution {
    public int solution(int[][] sizes) {
        int maxLong = 1;
        int maxShort = 1;
        
        for (int[] size : sizes){
            int longSize = Math.max(size[0], size[1]);
            int shortSize = Math.min(size[0], size[1]);
            
            maxLong = Math.max(maxLong, longSize);
            maxShort = Math.max(maxShort, shortSize);
        }
        return maxLong * maxShort;
    }
}