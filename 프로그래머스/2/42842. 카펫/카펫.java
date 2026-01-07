class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int [2];
        int mul = brown + yellow;
        
        for (int i = 3; i < mul; i ++){
            if (mul % i != 0) continue;
            if (((mul/i)*2 + i*2 - 4) == brown){
                answer[0] = Math.max((mul/i), i);
                answer[1] = Math.min((mul/i), i);
                break;
            }
        }
        return answer;
    }
}