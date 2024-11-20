class Solution {
    public int solution(int a, int d, boolean[] included) {
        int answer = 0;
        for (boolean in : included){
            if(in) answer += a;
            a += d;
        }
        return answer;
    }
}