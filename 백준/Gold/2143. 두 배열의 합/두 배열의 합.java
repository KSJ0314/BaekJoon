import java.io.*;
import java.util.*;

public class Main {
	static int T,N,M;
	static int[] A, B;
	static Map<Integer, Integer> mapA, mapB;
    
    public static void main(String[] args) throws IOException {
        init();
        mapInit(mapA, N, A);
        mapInit(mapB, M, B);
        
        long cnt = 0;
		for (int key : mapA.keySet()) {
			if (!mapB.containsKey(T-key)) continue;
			cnt += (long)mapA.get(key) * mapB.get(T-key);
		}
		
        System.out.println(cnt);
    }
	
	static void mapInit(Map<Integer, Integer> map, int size, int[] arr) {
        for (int i = 0; i < size; i++) {
        	int sum = 0;
        	for (int j = i; j < size; j++) {
				sum += arr[j];
				map.merge(sum, 1, Integer::sum);
			}
        }
	}

	static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        T = Integer.parseInt(br.readLine());
        
        N = Integer.parseInt(br.readLine());
        A = new int[N];
        String[] strs = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
        	int num = Integer.parseInt(strs[i]);
        	A[i] = num;
        }
        
        M = Integer.parseInt(br.readLine());
        B = new int[M];
        strs = br.readLine().split(" ");
        for (int i = 0; i < M; i++) {
        	int num = Integer.parseInt(strs[i]);
        	B[i] = num;
        }
		mapA = new HashMap<>();
		mapB = new HashMap<>();
	}
}