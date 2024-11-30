import java.util.*;

class Solution {
    public String[] solution(String[] str_list) {
        int s = 0;
		int e = str_list.length;
		boolean isEmpty = true;
		
        for (int i = 0; i < e && isEmpty; i++) {
			if (str_list[i].equals("l")) {
				e = i;
				isEmpty = false;
			} else if (str_list[i].equals("r")) {
				s = i+1;
				isEmpty = false;
			}
		}
        
        return isEmpty ? new String[]{} : Arrays.copyOfRange(str_list, s, e);
    }
}