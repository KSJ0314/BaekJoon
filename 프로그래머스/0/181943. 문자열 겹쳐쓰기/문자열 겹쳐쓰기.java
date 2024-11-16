class Solution {
    public String solution(String my_string, String overwrite_string, int s) {
        String answer = "";
        char[] ch = my_string.toCharArray();
        char[] ch2 = overwrite_string.toCharArray();
        
        for (int i = 0; i < overwrite_string.length(); i++) {
			ch[i+s] = ch2[i];
		}
        answer = new String(ch);
        return answer;
    }
}