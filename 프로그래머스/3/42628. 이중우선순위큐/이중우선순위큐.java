import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        TreeSet<Integer> ts = new TreeSet<>();
        for (String operation : operations){
            String[] oper = operation.split(" ");
            if (oper[0].equals("I")) {
            	ts.add(Integer.parseInt(oper[1]));
            	continue;
            }
            if (ts.isEmpty()) continue;
            if (oper[1].equals("-1")){
                ts.pollFirst();
            } else {
                ts.pollLast();
            }
        }
        
        int max,min;
        if (ts.isEmpty()) {
        	max = 0;
        	min = 0;
        } else if (ts.size() == 1){
        	max = ts.pollLast();
        	min = max;
        } else {
        	max = ts.pollLast();
        	min = ts.pollFirst();
        }
        return new int[]{max, min};
    }
}