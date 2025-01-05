import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public static int[][] arr;
	public static int minDiff;
	
	public static void diffCounter(int y, int x) {
		int diffCountB = 0;
		int diffCountW = 0;
		for (int i = y; i < y+8; i++) {	
			for (int j = x; j < x+8; j++) {
				if (((i-y)+(j-x))%2 == arr[i][j]) {	// 첫 칸 B
					diffCountB++;
				}
				if (((i-y)+(j-x))%2 != arr[i][j]) {	// 첫 칸 W
					diffCountW++;
				}
				if (diffCountB > minDiff && diffCountW > minDiff) {
					return;
				}
			}
		}
		minDiff = Math.min(diffCountB, diffCountW);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int M = Integer.parseInt(input[1]);
		
		// 입력 데이터를 ("B" -> 1 | "W" -> 0)로 저장
		arr = new int[N][M];
		for (int i = 0; i < N; i++) {
			int j = 0;
			for (char temp : br.readLine().toCharArray()) {
				arr[i][j] = temp=='B' ? 1 : 0;
				j++;
			}
		}
		
		minDiff = 64;
		O: for (int i = 0; i <= N-8; i++) {
			for (int j = 0; j <= M-8; j++) {
				diffCounter(i, j);
				if (minDiff == 0) {
					break O;
				}
			}
		}
		
		System.out.println(minDiff);
	}

}