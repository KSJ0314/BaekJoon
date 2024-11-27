import java.util.ArrayList;

class Solution {
    public int[] solution(int[] arr) {
        ArrayList<Integer> list = new ArrayList<>();
		
		for (int i = 0; i < arr.length; i++) {
            if (list.isEmpty()) {
				list.add(arr[i]);
				continue;
			}
            
			int lastIndex = list.size()-1;
			if (list.get(lastIndex) < arr[i]) {
				list.add(arr[i]);
			} else {
				list.remove(lastIndex);
                i--;
			}
		}
        return list.stream().mapToInt(i->i).toArray();
    }
}