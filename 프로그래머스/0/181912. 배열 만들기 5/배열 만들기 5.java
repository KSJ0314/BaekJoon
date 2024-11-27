import java.util.*;

class Solution {
    public int[] solution(String[] intStrs, int k, int s, int l) {
        ArrayList<Integer> list = new ArrayList<>();
        for (String intStr : intStrs){
			int intToStr = Integer.parseInt(intStr.substring(s,s+l));
            if (intToStr > k){
                list.add(intToStr);
            }
        }
            
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}