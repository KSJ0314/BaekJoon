class Solution {
    public int solution(String myString, String pat) {
        StringBuilder sb = new StringBuilder();
		for (char myChar : myString.toCharArray()) {
			sb.append((char)(myChar^3));
		}
        return sb.toString().contains(pat) ? 1 : 0;
    }
}