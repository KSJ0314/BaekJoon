import java.io.*;

public class Main {
	static int N, left, right;
	static int[] arr;
    
    public static void main(String[] args) throws IOException {
        init();
        movePointer();
        System.out.println(arr[left] + " " + arr[right]);
    }

	private static void movePointer() {
		int minDiff = Integer.MAX_VALUE;
        int pL = 0, pR = N-1;
        
        while (pL < pR) {
        	int diff = arr[pL]+arr[pR];
        	
        	if (minDiff > Math.abs(diff)) {
        		minDiff = Math.abs(diff);
        		left = pL;
        		right = pR;
        	}
        	
        	if (diff < 0) {
        		pL++;
        	} else {
        		pR--;
        	}
        	
        	if (minDiff == 0) break;
        }
		
	}

	static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        
        String[] strs = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
        	arr[i] = Integer.parseInt(strs[i]);
		}
		
	}
    
}