import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String[] strs;
		
		strs = br.readLine().split(" ");
		int T = Integer.parseInt(strs[0]);
		
		for (int test_case = 1; test_case <= T; test_case++) {
			strs = br.readLine().split(" ");

			int N = Integer.parseInt(strs[0]);
			int M = Integer.parseInt(strs[1]);
			
			int[][] dists = new int[N+1][N+1];
			
			// 거리 배열 초기화
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					dists[i][j] = i == j ? 0 : 1_000_000;
				}
			}
			
			// 거리 배열 입력값 설정
			for (int i = 0; i < M; i++) {
				strs = br.readLine().split(" ");
				int to = Integer.parseInt(strs[0]);
				int from = Integer.parseInt(strs[1]);
				int dist = Integer.parseInt(strs[2]);
				dists[to][from] = dist;
				dists[from][to] = dist;
			}
			
			// 플로이드 워셜
			for (int k = 1; k <= N; k++) {
				for (int i = 1; i <= N; i++) {
					for (int j = 1; j <= N; j++) {
						dists[i][j] = Math.min(dists[i][j], dists[i][k] + dists[k][j]);
					}
				}
			}

			strs = br.readLine().split(" ");
			int K = Integer.parseInt(strs[0]);
			
			// 모임 참여자 입력
			Deque<Integer> deque = new ArrayDeque<>();
			strs = br.readLine().split(" ");
			for (int i = 0; i < K; i++) {
				deque.addLast(Integer.parseInt(strs[i]));
			}
			
			// 모임 참여자들만 i번 까지의 거리 구해서 합산값 최소 구하기
			int minSum = Integer.MAX_VALUE;
			int minIdx = -1;
			for (int i = 1; i <= N; i++) {
				int sum = 0;
				for (int j : deque) {
					sum += dists[i][j];
				}
				if (minSum > sum) {
					minSum = sum;
					minIdx = i;
				}
			}
			sb.append(minIdx).append("\n");
		}
		System.out.println(sb);
	}
}