import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	
	public static int diffCounter(int[][]arr, int minDiff) {
		int diffCountB = 0;
		int diffCountW = 0;
		O: for (int i = 0; i < 8; i++) {	
			for (int j = 0; j < 8; j++) {
				if ((i+j)%2 == arr[i][j]) {	// 첫 칸 B
					diffCountB++;
				}
				if ((i+j)%2 != arr[i][j]) {	// 첫 칸 W
					diffCountW++;
				}
				if (diffCountB > minDiff && diffCountW > minDiff) {
					return minDiff;
				}
			}
		}
		return Math.min(diffCountB, diffCountW);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int M = Integer.parseInt(input[1]);
		
		// 입력 데이터를 ("B" -> true | "W" -> false)로 저장
		int[][] arr = new int[N][M];
		for (int i = 0; i < N; i++) {
			int j = 0;
			for (String temp : br.readLine().split("")) {
				arr[i][j] = temp.equals("B") ? 1 : 0;
				j++;
			}
		}
		
		int[][] tempArr = new int[8][8];
		int minDiff = 64;
		O: for (int i = 0; i <= N-8; i++) {
			for (int j = 0; j <= M-8; j++) {
				for (int k = i; k < i+8; k++) {
					tempArr[k-i] = Arrays.copyOfRange(arr[k], j, j+8);
				}
				minDiff = diffCounter(tempArr, minDiff);
				if (minDiff == 0) {
					break O;
				}
			}
		}
		
		System.out.println(minDiff);
	}

}