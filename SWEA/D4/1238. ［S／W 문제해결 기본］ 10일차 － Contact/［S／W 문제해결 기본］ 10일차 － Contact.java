

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {

	static int length, start;
	static int maxVal;
	static List<Integer>[] lst;
	static boolean[] visited;
	static int ans = Integer.MIN_VALUE;
	static List<Integer> bucket;

	static void bfs(int start) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.offer(start);
		visited[start] = true;

		while (!q.isEmpty()) {
			bucket = new ArrayList<>();
			int size = q.size();

			for (int k = 0; k < size; k++) {
				int cur = q.poll();
				bucket.add(cur);

				// 인접된 노드수 만큼
				// 방문하지 않았거나 연결되어있다면 offer
				for (int i = 0; i < lst[cur].size(); i++) {
					int val = lst[cur].get(i);

					if (!visited[val]) {
						visited[val] = true;
						q.offer(val);

					}
				}
			}
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int tc = 1; tc <= 10; tc++) {
			String[] s = br.readLine().split(" ");

			ans = Integer.MIN_VALUE;
			length = Integer.parseInt(s[0]);
			start = Integer.parseInt(s[1]);

			s = br.readLine().split(" ");
			for (int i = 0; i < s.length; i++) {
				maxVal = Math.max(maxVal, Integer.parseInt(s[i]));
			}
			lst = new ArrayList[maxVal + 1];
			for (int i = 0; i < maxVal + 1; i++) {
				lst[i] = new ArrayList<>();
			}

			visited = new boolean[maxVal + 1];
			int idx = 0;
			for (int i = 0; i < s.length / 2; i++) {
				int a = Integer.parseInt(s[idx]);
				int b = Integer.parseInt(s[idx + 1]);
				// System.out.println(a + " " + b);
				lst[a].add(b);

				idx += 2;
			}

			bfs(start);
			for (int i = 0; i < bucket.size(); i++) {
				ans = Math.max(ans, bucket.get(i));
			}
			System.out.println("#" + tc + " " + ans);

		}
		}
		

}
