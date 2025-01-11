 import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

public class Main {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input;
		
		//  (1 ≤ N, M ≤ 200,000)
		input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int M = Integer.parseInt(input[1]);
		
		Map<Integer, Queue<Integer>> inputMap = new HashMap<>();
		int[] countArr = new int[N+1];	// 각 변호사(B)가 갖는 신뢰하는 변호사(A)의 수
		boolean[] boolArr = new boolean[N+1];
		for (int i = 0; i < M; i++) {
			input = br.readLine().split(" ");
			int value = Integer.parseInt(input[0]);
			int key = Integer.parseInt(input[1]);
			addValueToMap(inputMap, key, value);
			countArr[key]++;
		}
		
		for (int i = 1; i <= N; i++) {
			if (countArr[i] == 0) {
				System.out.println("NO");
				return;
			}
		}
		
		boolean remain1 = true;
		while (remain1) {
			remain1 = false;
			for (int key = 1; key <= N; key++) {
				if (countArr[key] == 1 && !boolArr[key]) {
					remain1 = true;
					boolArr[key] = true;
					int value = inputMap.get(key).peek();
					if (inputMap.get(value).contains(key)) {
						inputMap.get(value).remove(key);
						countArr[value]--;
						if (countArr[value] == 0) {
							System.out.println("NO");
							return;
						}
					}
				}
			}
		}
		
		System.out.println("YES");
		
	}
	
	public static void addValueToMap(Map<Integer, Queue<Integer>> map, int key, int value) {
        map.putIfAbsent(key, new ArrayDeque<>());
        map.get(key).add(value);
    }
}
