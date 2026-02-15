import java.io.*;
import java.util.*;

public class Main {
	static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] inputs;
		
		inputs = br.readLine().split(" ");
		int N = Integer.parseInt(inputs[0]);
		
		int maxNum = 0;
		arr = new int[N];
		inputs = br.readLine().split(" ");
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(inputs[i]);
			
			maxNum = Math.max(maxNum, arr[i]);
		}

		long left = 0;
		long right = (long)maxNum * N;
		while (left < right) {
			long mid = (right+left) / 2;
			
			int leftMax = 0;
			int rightMin = N-1;
			for (int i = 0; i < N; i++) {
				long maxDist = mid / arr[i];
			    long leftMinIdx = Math.max(0, i - maxDist);
			    long rightMaxIdx = Math.min(N - 1, i + maxDist);
				leftMax = (int) Math.max(leftMax, leftMinIdx);
				rightMin = (int) Math.min(rightMin, rightMaxIdx);
			}
			
			if (leftMax <= rightMin) {
				right = mid;
			} else {
				left = mid + 1;
			}
		}
		System.out.println(right);
	}
}