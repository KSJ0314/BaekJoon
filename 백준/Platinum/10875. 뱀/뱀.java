import java.io.*;

// 메모리초과
// HashSet, TreeSet, BitSet, 
// 시간초과
// PriorityQueue, ArrayDeque, ArrayList

public class Main {
	
	int t;
	int x_or_y;	// 0: x | 1: y
	int[] coor;
	int[] oper;
	int[][] arr;

	// 충돌 체크 + 범위 아웃 체크
	public boolean crashCheck(int l, int idx) {
		arr[idx][0] = x_or_y;
		arr[idx][1] = coor[x_or_y^1];
		arr[idx][2] = coor[x_or_y] + oper[x_or_y];
		arr[idx][3] = coor[x_or_y] + oper[x_or_y] * t;
		
		boolean isDie = false;
		int timeAdd = t;
		for (int j = 0; j < idx; j++) {
			int iB = Math.max(arr[idx][2], arr[idx][3]);
			int iS = Math.min(arr[idx][2], arr[idx][3]);
			int jB = Math.max(arr[j][2], arr[j][3]);
			int jS = Math.min(arr[j][2], arr[j][3]);
			if (arr[idx][0] == arr[j][0]) {	// 같은 축
				if (arr[idx][1] == arr[j][1] && iB >= jS && iS <= jB) {
					int newTimeAdd = oper[0]+oper[1] == 1 ? jS-iS : iB-jB;
					timeAdd = Math.min(newTimeAdd, timeAdd);
					isDie = true;
				}
			} else {	// 다른 축
				if (iS <= arr[j][1] && iB >= arr[j][1] && jS <= arr[idx][1] && jB >= arr[idx][1]) {
					int newTimeAdd = Math.abs(arr[idx][2] - arr[j][1]);
					timeAdd = Math.min(newTimeAdd, timeAdd);
					isDie = true;
				}
			}
		}
		if (isDie) {
			t = timeAdd;
		} else if (arr[idx][3]*oper[x_or_y] > l) {
			t = Math.abs(l*oper[x_or_y]-coor[x_or_y]);
			isDie = true;
		}
		return isDie;
	}
	
	// 방향 전환
	public void turn(int idx, boolean eqR) {
		int isR = eqR ? 1 : -1;
		int isY = x_or_y == 1 ? 1 : -1;
		oper[x_or_y^1] = oper[x_or_y] * isR * isY;
		oper[x_or_y] = 0;
		coor[x_or_y] = arr[idx][3];
		x_or_y ^= 1;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] inputStrArr;
		Main m = new Main();
		
		int L = Integer.parseInt(br.readLine());
		int N = Integer.parseInt(br.readLine());
		
		long time = 1;
		boolean isDie = false;
		m.x_or_y = 0;
		m.coor = new int[]{0,0};
		m.oper = new int[]{1,0};
		m.arr = new int[N+2][4];
		
		for (int i = 1; i <= N; i++) {
			inputStrArr = br.readLine().split(" ");
			if (isDie) continue;
			
			m.t = Integer.parseInt(inputStrArr[0]);
			isDie = m.crashCheck(L,i);
			m.turn(i, inputStrArr[1].equals("R"));
			time += m.t;
		}
		
		// 끝까지 생존 시
		if (!isDie) {
			m.t = 2*L+1;
			m.crashCheck(L,N+1);
			time += m.t;
		}
		
		System.out.println(time);
	}
}
