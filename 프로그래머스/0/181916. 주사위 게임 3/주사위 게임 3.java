import java.util.*;

class Solution {
    ArrayList<Integer> list = new ArrayList<Integer>();
    int dupl = 0;
    int temp = 0;
    
    public int solution(int a, int b, int c, int d) {
        addList(a);
        addList(b);
        addList(c);
        addList(d);
        Collections.sort(list);
        list.remove(Integer.valueOf(temp));
        
        int score;
        switch (list.size()) {
		case 0:
			score = 1111 * temp;
			break;
		case 1:
            if (dupl == 1){
                score = (int) (Math.pow((10*temp + list.get(0)), 2));
            } else {
                score = (temp + list.get(0)) * Math.abs(temp - list.get(0));
            }
			break;
		case 2:
			score = list.get(0) * list.get(1);
			break;
        default:
			score = list.get(0);
		}
        
        return score;
    }
    
    public void addList (int num) {
		if (list.contains(num)) {
            if (temp != num){
                dupl++;
                temp = num;
            }
			return;
		}
        list.add(num);
	}
}