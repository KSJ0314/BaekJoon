class Solution {
    public String solution(String code) {
        String answer = "";
        int mode = 0;
        for (int idx = 0; idx < code.length(); idx++) {
        	char c = code.charAt(idx);
            if (c == '1') {
                mode = (mode == 0) ? 1 : 0;
                continue;
            }
            if(idx%2==mode) answer += c;
		}
        return answer.isEmpty() ? "EMPTY" : answer;
    }
}