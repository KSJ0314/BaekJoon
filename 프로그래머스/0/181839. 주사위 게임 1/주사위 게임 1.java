class Solution {
    public int solution(int a, int b) {
        if ((a*b) % 2 == 1){    // 모두 홀수
            return (int) Math.pow(a, 2) + (int) Math.pow(b, 2);
        } else if ((a+b) % 2 == 1){ // 하나만 홀수
            return 2 * (a+b);
        } else{
            return a>b ? a-b : b-a;
        }
    }
}