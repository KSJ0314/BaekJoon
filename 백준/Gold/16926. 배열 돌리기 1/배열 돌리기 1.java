import java.io.*;
import java.util.*;

public class Main {
	static int N,M,R,l;
	static int[][] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		init(br);
		while(R-- >0) {
			rotate();
		}
		print();
	}

	static void rotate() {
		for (int layer = 0; layer < l; layer++) {
			int temp = arr[layer][layer];
			for (int i = layer+1; i < M-layer; i++) {
				arr[layer][i-1] = arr[layer][i];
			}
			
			for (int i = layer+1; i < N-layer; i++) {
				arr[i-1][M-1-layer] = arr[i][M-1-layer];
			}
			
			for (int i = M-1-layer-1; i >= layer; i--) {
				arr[N-1-layer][i+1] = arr[N-1-layer][i];
			}
			
			for (int i = N-1-layer-1; i > layer; i--) {
				arr[i+1][layer] = arr[i][layer];
			}
			arr[layer+1][layer] = temp;
		}
	}

	static void print() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	static void init(BufferedReader br) throws IOException {
		String[] strs = br.readLine().split(" ");
		N = Integer.parseInt(strs[0]);
		M = Integer.parseInt(strs[1]);
		R = Integer.parseInt(strs[2]);
		//R %= ((N+M)*2)-4;
		l = Math.min(N/2, M/2);
		
		arr = new int[N][M];
		for (int i = 0; i < N; i++) {
			strs = br.readLine().split(" ");
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(strs[j]);
			}
		}
	}

}
