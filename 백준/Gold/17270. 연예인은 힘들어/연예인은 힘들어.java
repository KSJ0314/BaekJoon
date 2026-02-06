import java.io.*;
import java.util.*;

public class Main {
	static int V, M, S, J;
	static int[][] dists;
	static final int INF = 1_000_000;
	
	public static void main(String[] args) throws IOException {
		init();
		
		for (int k = 1; k <= V; k++) {
			for (int i = 1; i <= V; i++) {
				for (int j = 1; j <= V; j++) {
					dists[i][j] = Math.min(dists[i][j], dists[i][k] + dists[k][j]);
				}
			}
		}
		
		int idx = -1;
		int minDist = Integer.MAX_VALUE;
		int minS = Integer.MAX_VALUE;
		for (int i = 1; i <= V; i++) {
			if (i == S || i == J) continue;
			if (minDist > dists[S][i] + dists[J][i]) {	// 새로운 최소 값
				if (dists[i][S] > dists[i][J]) {	// S가 더 큰 최소값이면 idx -1로 변경
					idx = -1;
				} else {							// 아니면 idx 저장
					idx = i;
				}
				minDist = dists[S][i] + dists[J][i];	// 최소값 갱신
				minS = dists[i][S];
			} else if (minDist == dists[S][i] + dists[J][i]) { 	// 같은 값
				if (minS > dists[i][S]) {	// S값 가장 작은 idx 찾기
					if (dists[i][S] <= dists[i][J]) {
						idx = i;
					}
					minS = dists[i][S];
				}
			}
			
		}
		System.out.println(idx);
	}
	
	private static void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] strs;
		
		strs = br.readLine().split(" ");
		V = Integer.parseInt(strs[0]);
		M = Integer.parseInt(strs[1]);
		
		dists = new int[V+1][V+1];
		for (int i = 1; i <= V; i++) {
			for (int j = 1; j <= V; j++) {
				dists[i][j] = i==j ? 0 : INF;
			}
		}
		
		for (int i = 0; i < M; i++) {
			strs = br.readLine().split(" ");
			int a = Integer.parseInt(strs[0]);
			int b = Integer.parseInt(strs[1]);
			int c = Integer.parseInt(strs[2]);
			
			dists[a][b] = Math.min(dists[a][b], c);
			dists[b][a] = Math.min(dists[b][a], c);
		}
		
		strs = br.readLine().split(" ");
		S = Integer.parseInt(strs[0]);
		J = Integer.parseInt(strs[1]);
	}
}