import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// int N = Integer.parseInt(br.readLine());
		
		String[] inputStrArr = br.readLine().split(" ");
		
		int R = Integer.parseInt(inputStrArr[0]);
		int C = Integer.parseInt(inputStrArr[1]);
		int T = Integer.parseInt(inputStrArr[2]);
		
		int[][] arr = new int[R][C];
		int[][] diffuCount = new int[R][C];
		
		boolean isFind = false;
		int[] coor = new int[2];
		for (int i = 0; i < R; i++) {
			inputStrArr = br.readLine().split(" ");
			for (int j = 0; j < C; j++) {
				int inputNum = Integer.parseInt(inputStrArr[j]);
				arr[i][j] = inputNum;
				int diffu = 4;
				if (i==0 || i==R-1) {
					diffu--;
				}
				if (j==0 || j==C-1) {
					diffu--;
				}
				if (inputNum == -1 && !isFind) {
					coor[0] = i;
					coor[1] = j;
					isFind = true;
				}
				diffuCount[i][j] = diffu;
			}
		}
		diffuCount[coor[0]-1][0]--;
		diffuCount[coor[0]][1]--;
		diffuCount[coor[0]+1][1]--;
		diffuCount[coor[0]+2][0]--;
		arr[coor[0]][0] = 0;
		arr[coor[0]+1][0] = 0;
		
		for (int tast_case = 0; tast_case < T; tast_case++) {
			int[][] newArr = new int[R][C];
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					if (arr[i][j] <= 0) continue;
					int diffu = arr[i][j] / 5;
					newArr[i][j] += arr[i][j] - diffu*diffuCount[i][j];
					if (i > 0) newArr[i-1][j] += diffu;
					if (i < R-1) newArr[i+1][j] += diffu;
					if (j > 0) newArr[i][j-1] += diffu;
					if (j < C-1) newArr[i][j+1] += diffu;
				}
			}
			newArr[coor[0]][0] = 0;
			newArr[coor[0]+1][0] = 0;
			arr = newArr;
			
			for (int i = coor[0]; i > 0; i--) {
				arr[i][0] = arr[i-1][0];
			}
			arr[coor[0]][0] = 0;
			for (int i = coor[0]+1; i < R-1; i++) {
				arr[i][0] = arr[i+1][0];
			}
			arr[coor[0]+1][0] = 0;
			
			for (int i = 0; i < C-1; i++) {
				arr[0][i] = arr[0][i+1];
				arr[R-1][i] = arr[R-1][i+1];
			}
			for (int i = 0; i < coor[0]; i++) {
				arr[i][C-1] = arr[i+1][C-1];
			}
			for (int i = R-1; i > coor[0]+1; i--) {
				arr[i][C-1] = arr[i-1][C-1];
			}
			for (int i = C-1; i > 0; i--) {
				arr[coor[0]][i] = arr[coor[0]][i-1];
				arr[coor[0]+1][i] = arr[coor[0]+1][i-1];
			}
		}
		int sum = 0;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				sum += arr[i][j];
			}
		}
		System.out.println(sum);
		
	}
}
