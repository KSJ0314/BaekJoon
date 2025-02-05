import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    Map<Integer, Long> map = new HashMap<>();
    int[] dels = {-1,0,1};
    int[][] nums;
    final long MAX_N = 1_000_000;
    
    public boolean isIn(int x) {
        return x >= 0 && x < 3;
    }
    
    public long counting(int y, int x) {
    	if (map.containsKey(y*10+x)) {
    		return map.get(y*10+x);
    	}

    	int num = y >= 0 ? nums[y][x] : 0;
    	long max = 0;
    	long min = Integer.MAX_VALUE;
        for (int del : dels) {
            int nx = x + del;
            if (!isIn(nx)) {
            	continue;
            }

            long nextNum = counting(y+1, nx);
            
            max = Math.max(max, nextNum / MAX_N);
            min = Math.min(min, nextNum % MAX_N);
        }
        map.put(y*10+x, (max+num)*MAX_N + (min+num));
        
        return (max+num)*MAX_N + (min+num);
    }

    public long init() throws IOException {
        int n = Integer.parseInt(br.readLine());
        nums = new int[n][3];

        for (int i = 0; i < n; i++) {
            String[] strs = br.readLine().split(" ");
            nums[i][0] = Integer.parseInt(strs[0]);
            nums[i][1] = Integer.parseInt(strs[1]);
            nums[i][2] = Integer.parseInt(strs[2]);
        }
        map.put((n-1)*10+0, nums[n-1][0]*MAX_N + nums[n-1][0]);
        map.put((n-1)*10+1, nums[n-1][1]*MAX_N + nums[n-1][1]);
        map.put((n-1)*10+2, nums[n-1][2]*MAX_N + nums[n-1][2]);
        
        return counting(-1, 1);
    }

    public static void main(String[] args) throws IOException {
        Main m = new Main();
        long result = m.init();
        
        System.out.println((result / m.MAX_N) + " " + (result % m.MAX_N));
    }
}