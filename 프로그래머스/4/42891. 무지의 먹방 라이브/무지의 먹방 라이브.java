import java.util.ArrayList;
import java.util.List;

class Solution{
    
    public int solution(int[] food_times, long k) {
		 
		int fs = food_times.length;
		List<int[]> list = new ArrayList<int[]>();
		
		for (int i = 0; i < food_times.length; i++) {
			list.add(i, new int[]{i, food_times[i]});
		}
		
		int[] count = new int[100000001];
		for (int[] value : list) {
			count[value[1]]++;
        }
		
		int i = 1;
		int remove = 0;
		while (true) {
			if (fs==remove) { break; }
			long result = k+1;
			k -= (fs-remove);
			if (k < 0) {
				int j = 1;
				for (int[] value : list) {
					if (value[1] >= i) {
						if (j == result) {
							return value[0]+1;
						}
						j++;
					}
				}
			}
			remove += count[i];
			i++;
		}
		
		return -1;
		
    }

}