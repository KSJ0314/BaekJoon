class Solution {
    public String solution(String my_string, int s, int e) {
        String replace_string = new StringBuilder(my_string.substring(s, e+1)).reverse().toString();
		String answer = new StringBuilder(my_string).replace(s, e+1, replace_string).toString();
        return answer;
    }
}