class Solution {
    public String[] solution(String[] picture, int k) {
        String[] answer = new String[picture.length * k];
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < answer.length; i++) {
        	for (char ch : picture[i/k].toCharArray()) {
        		for (int j = 0; j < k; j++) {
        			sb.append(ch);
				}
        	}
			answer[i] = sb.toString();
            sb.setLength(0);
		}
        
        return answer;
    }
}