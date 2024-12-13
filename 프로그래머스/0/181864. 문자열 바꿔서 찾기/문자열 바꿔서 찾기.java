class Solution {
    public int solution(String myString, String pat) {
        return myString.replace("A", "0")
	        		.replace("B", "A")
	        		.replace("0", "B")
	        		.contains(pat) ? 1 : 0;
    }
}