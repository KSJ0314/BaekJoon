class Solution {
    public String solution(String my_string, String overwrite_string, int s) {
        String answer = "";
        StringBuilder sb = new StringBuilder(my_string);
        answer += sb.replace(s, overwrite_string.length()+s, overwrite_string);
        return answer;
    }
}