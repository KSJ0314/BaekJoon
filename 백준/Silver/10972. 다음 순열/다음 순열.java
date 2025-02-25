import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int N;
	static int[] arr;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		
		String[] strs = br.readLine().split(" ");
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(strs[i]);
		}
		
		boolean bo = np();
		
		if (!bo) {
			System.out.println(-1);
			return;
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			sb.append(arr[i]+" ");
		}
		System.out.println(sb);
		
	}
	
	public static boolean np() {
		
		int i;
		for (i = N-1; i>0 && arr[i-1]>=arr[i]; i--);
		
		if (i == 0) return false;
		
		int j;
		for (j = N-1; arr[i-1]>=arr[j]; j--);
		
		swap(i-1, j);
		
		int k = N-1;
		while (i<k) swap(i++, k--);
		
		return true;
	}
	
	public static void swap(int a, int b) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}

}