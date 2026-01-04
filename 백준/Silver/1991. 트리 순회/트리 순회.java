import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int N;
    static int[] lC;	// 왼쪽 자식
    static int[] rC;	// 오른족 자식
    static StringBuilder sb;
	
    public static void main(String[] args) throws IOException {
        init();
        
        playTraversal(0);	// 전위 순회
        playTraversal(1);	// 중위 순회
        playTraversal(2);	// 후위 순회
    }
    
    private static void playTraversal(int flag) {
    	traversal(0, flag);
        System.out.println(sb);
        sb.setLength(0);
    }

	private static void traversal(int idx, int flag) {
		if (idx == -1) return;
		char ch = (char)(idx+'A');
		switch (flag) {
			case 0:
				sb.append(ch);
				traversal(lC[idx], flag);
				traversal(rC[idx], flag);
				break;
			case 1:
				traversal(lC[idx], flag);
				sb.append(ch);
				traversal(rC[idx], flag);
				break;
			case 2:
				traversal(lC[idx], flag);
				traversal(rC[idx], flag);
				sb.append(ch);
				break;
		}
	}

	public static void init() throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	String[] strs = br.readLine().split(" ");
        N = Integer.parseInt(strs[0]);
        lC = new int[N];
        rC = new int[N];
        
        for (int i = 0; i < N; i++) {
        	strs = br.readLine().split(" ");
        	int idx = strs[0].charAt(0)-'A';
        	lC[idx] = strs[1].charAt(0) == '.' ? -1 : strs[1].charAt(0)-'A';
        	rC[idx] = strs[2].charAt(0) == '.' ? -1 : strs[2].charAt(0)-'A';
        }
        
        sb = new StringBuilder();
    }
}