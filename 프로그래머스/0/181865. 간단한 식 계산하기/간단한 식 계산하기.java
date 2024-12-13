class Solution {
    public int solution(String binomial) {
        String[] biStr = binomial.split(" ");
        
		int a = Integer.valueOf(biStr[0]);
		String op = biStr[1];
		int b = Integer.valueOf(biStr[2]);
		
		switch (op) {
			case "+":
				return a+b;
			case "-":
				return a-b;
			default:
				return a*b;
		}
    }
}