class Solution {
    public String solution(String myString) {
        StringBuilder sb = new StringBuilder();
		
		for (char ch : myString.toCharArray()) {
			char prevL = ch < 'l' ? 'l' : ch;
			sb.append(prevL);
		}
        
        return sb.toString();
    }
}