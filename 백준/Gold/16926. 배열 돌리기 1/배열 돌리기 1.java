import java.io.*;

public class Main {
	static int N,M,R,l;
	static int[][] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		init(br);
		for (int layer = 0; layer < l; layer++) {
			int r = R % ((N+M - (4*layer))*2 - 4);
			while(r-- >0) {
				rotate(layer);
			}
		}
		print();
	}

	static void rotate(int layer) {
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

	static void print() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				sb.append(arr[i][j]+" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
	
	static void init(BufferedReader br) throws IOException {
		String[] strs = br.readLine().split(" ");
		N = Integer.parseInt(strs[0]);
		M = Integer.parseInt(strs[1]);
		R = Integer.parseInt(strs[2]);
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
