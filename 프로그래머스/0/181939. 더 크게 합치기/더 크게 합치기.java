class Solution {
    public int solution(int a, int b) {
        int r1 = Integer.parseInt(""+a+b);
        int r2 = Integer.parseInt(""+b+a);
        return Math.max(r1, r2);
    }
}