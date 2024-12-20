class Solution {
    public String[] solution(String[] picture, int k) {
        String[] answer = new String[picture.length * k];
        
        for (int i = 0; i < answer.length; i++) {
        	StringBuilder newPicture = new StringBuilder();
        	for (char ch : picture[i/k].toCharArray()) {
        		for (int j = 0; j < k; j++) {
        			newPicture.append(ch);
				}
        	}
			answer[i] = newPicture.toString();
		}
        
        return answer;
    }
}