
class Solution {
    public String solution(String number, int k) {
        StringBuilder sb = new StringBuilder();
        int idx = 0;
        for (boolean isEnd = false; k > 0 && !isEnd; idx++){
        	boolean isRemove = false;
        	char ch = number.charAt(idx);
            for (int i = 1; i <= k; i++){
            	if (idx+i >= number.length()) {
            		isEnd = true;
            		break;
            	}
                if (ch < number.charAt(idx+i)) {
                	k--;
                	isRemove = true;
                	break;
                }
            }
            if (!isRemove && !isEnd) sb.append(ch);
        }
        if (k == 0) {
        	for (int i = idx; i < number.length(); i++) {
				sb.append(number.charAt(i));
			}
        }
        return sb.toString();
    }
}