import java.io.*;
import java.util.*;

public class Main {
	static int N,M, sum;
	static int[] arr;
    
    public static void main(String[] args) throws IOException {
        init();
        if (sum <= M) {
        	System.out.println(arr[N-1]);
        	return;
        }
        
        int max = 0;
        for (int i = 0; i < N; i++) {
        	max = M / (N-i);
        	if (max <= arr[i]) break;
        	M -= arr[i];
		}
    
        System.out.println(max);
    }

	static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        
        String[] strs = br.readLine().split(" ");
        sum = 0;
        for (int i = 0; i < N; i++) {
        	int num = Integer.parseInt(strs[i]);
			arr[i] = num;
			sum += num;
		}
        Arrays.sort(arr);
        
        M = Integer.parseInt(br.readLine());
		
	}
    
}