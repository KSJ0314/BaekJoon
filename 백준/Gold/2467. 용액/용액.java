import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int[] arr, result;
    
    public static void main(String[] args) throws IOException {
        init();
        movePointer();
        Arrays.sort(result);
        System.out.println(result[0] + " " + result[1]);
    }

	private static void movePointer() {
		int minDiff = Integer.MAX_VALUE;
        int pL = 0;
        int pR = N-1;
        
        while (pL < pR) {
        	int n1 = arr[pL];
        	int n2 = arr[pR];
        	int diff = Math.abs(n1+n2);
        	
        	if (minDiff > diff) {
        		minDiff = diff;
        		result[0] = n1;
        		result[1] = n2;
        	}
        	
        	if (Math.abs(n1) > Math.abs(n2)) {
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
        result = new int[2];
        
        String[] strs = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
        	arr[i] = Integer.parseInt(strs[i]);
		}
		
	}
    
}