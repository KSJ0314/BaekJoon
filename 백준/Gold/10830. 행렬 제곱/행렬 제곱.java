import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static long B;
	static int[][] arr, pows, temps;
	
	public static void main(String[] args) throws IOException {
		init();
		pows = power(arr, B);
		print();
	}
	private static int[][] multiply(int[][] A, int[][] B) {
	    int[][] result = new int[N][N];

	    for (int i = 0; i < N; i++) {
	        for (int j = 0; j < N; j++) {
	            for (int k = 0; k < N; k++) {
	                result[i][j] += A[i][k] * B[k][j];
	                result[i][j] %= 1000;
	            }
	        }
	    }
	    return result;
	}
	private static int[][] power(int[][] A, long exp) {
	    if (exp == 1) return A;

	    int[][] half = power(A, exp / 2);
	    int[][] result = multiply(half, half);

	    if (exp % 2 == 1) {
	        result = multiply(result, A);
	    }

	    return result;
	}
	
	private static void print() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print((pows[i][j]%1000)+" ");
			}
			System.out.println();
		}
	}

	private static void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] strs;
		
		strs = br.readLine().split(" ");
		N = Integer.parseInt(strs[0]);
		B = Long.parseLong(strs[1]);
		
		arr = new int[N][N];
		pows = new int[N][N];
		temps = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			strs = br.readLine().split(" ");
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(strs[j]);
				pows[i][j] = arr[i][j];
			}
		}
	}
}