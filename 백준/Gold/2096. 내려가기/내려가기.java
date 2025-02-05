import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int[] dels = {-1,0,1};
    int[][] nums;
    Map<Integer, int[]> map = new HashMap<>();
    
    public boolean isIn(int x) {
        return x >= 0 && x < 3;
    }
    
    public int[] counting(int y, int x) {
    	if (map.containsKey(y*10+x)) {
    		return map.get(y*10+x);
    	}

    	int num = y >= 0 ? nums[y][x] : 0;
    	int max = 0;
    	int min = Integer.MAX_VALUE;
        for (int del : dels) {
            int nx = x + del;
            if (!isIn(nx)) {
            	continue;
            }

            int[] nextNum = counting(y+1, nx);
            
            max = Math.max(max, nextNum[0]);
            min = Math.min(min, nextNum[1]);
        }
        map.put(y*10+x, new int[] {max+num,min+num});
        
        return new int[] {max+num,min+num};
    }

    public int[] init() throws IOException {
        int n = Integer.parseInt(br.readLine());
        nums = new int[n][3];

        for (int i = 0; i < n; i++) {
            String[] strs = br.readLine().split(" ");
            nums[i][0] = Integer.parseInt(strs[0]);
            nums[i][1] = Integer.parseInt(strs[1]);
            nums[i][2] = Integer.parseInt(strs[2]);
        }
        map.put((n-1)*10+0, new int[]{nums[n-1][0],nums[n-1][0]});
        map.put((n-1)*10+1, new int[]{nums[n-1][1],nums[n-1][1]});
        map.put((n-1)*10+2, new int[]{nums[n-1][2],nums[n-1][2]});
        
        return counting(-1, 1);
    }

    public static void main(String[] args) throws IOException {
        Main m = new Main();
        int[] result = m.init();
        
        System.out.println(result[0] + " " + result[1]);
    }
}