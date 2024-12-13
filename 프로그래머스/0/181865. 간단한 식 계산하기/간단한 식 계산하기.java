class Solution {
    public int solution(String binomial) {
        String[] biStr = binomial.split(" ");
        
		int a = Integer.valueOf(biStr[0]);
		String op = biStr[1];
		int b = Integer.valueOf(biStr[2]);
		
		if (op.equals("+")) {
			return a+b;
		} else if (op.equals("-")) {
			return a-b;
		} else {
			return a*b;
		}
    }
}