class Solution {
    public int solution(String number) {
        int answer = 0;
        for (char num : number.toCharArray()){
            answer += num - '0';
        }
        return answer % 9;
    }
}