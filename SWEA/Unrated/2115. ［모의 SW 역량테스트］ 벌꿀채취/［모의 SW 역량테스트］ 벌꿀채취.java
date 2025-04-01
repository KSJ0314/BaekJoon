import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
	
	static int N,M,C;
	static int[][] arr, honeyScore;
	static List<Integer> scoreList;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			sb.append("#"+t+" ");
			
			init(br);
			calHoneyScore();
			selectHoney();
			Collections.sort(scoreList, Collections.reverseOrder());
			
			sb.append(scoreList.get(0));
			sb.append("\n");
		}
		System.out.println(sb);
	}

	static void selectHoney() {
		for (int i = 0; i < honeyScore.length; i++) {
			for (int j = 0; j < honeyScore[i].length; j++) {
				int a = honeyScore[i][j];
				
				for (int k = 0; k < honeyScore.length; k++) {
					for (int k2 = j; k2 < honeyScore[k].length; k2++) {
						if (i==k && j-M < k2 && k2 < j+M) continue;
						int b = honeyScore[k][k2];
						scoreList.add(a+b);
					}
				}
			}
		}
	}

	static void calHoneyScore() {
		for (int i = 0; i < honeyScore.length; i++) {
			for (int j = 0; j < honeyScore[i].length; j++) {
				honeyScore[i][j] = calHoneyScoreSubset(i,j,0,0,0);
			}
		}
	}

	static int calHoneyScoreSubset(int y, int x, int depth, int score, int sum) {
		if (depth == M) return score;
		
		int num = arr[y][x+depth];
		if (sum+num > C) return score;
		
		int a = calHoneyScoreSubset(y, x, depth+1, score + (num*num), sum+num);
		int b = calHoneyScoreSubset(y, x, depth+1, score, sum);
		int max = Math.max(a, b);
		
		return max;
	}

	static void init(BufferedReader br) throws IOException {
		String[] strs;
		strs = br.readLine().split(" ");
		N = Integer.parseInt(strs[0]);
		M = Integer.parseInt(strs[1]);
		C = Integer.parseInt(strs[2]);
		arr = new int[N][N];
		honeyScore = new int[N][N-M+1];
		scoreList = new ArrayList<>();
		
		for (int i = 0; i < N; i++) {
			strs = br.readLine().split(" ");
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(strs[j]);
			}
		}
	}
}
