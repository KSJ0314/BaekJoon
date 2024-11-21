class Solution {
    public String solution(int[] numLog) {
        String answer = "";
        int n = numLog[0];
        for (int i = 1; i < numLog.length; i++){
            switch(numLog[i] - n){
                case 1: answer += "w"; break;
                case -1: answer += "s"; break;
                case 10: answer += "d"; break;
                case -10: answer += "a"; break;
            }
            n = numLog[i];
        }
        return answer;
    }
}