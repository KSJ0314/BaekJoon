import java.io.*;

public class Main {
	public static int isPalindrome(String str) {
		return isPalindrome(str, str.length(), 0, str.length()-1, true);
	}
	public static int isPalindrome(String str, int l, int iIdx, int jIdx, boolean isContinue) {
		int count = 0;
		for (int i = iIdx, j = jIdx; i <= l / 2; i++, j--) {
			if (str.charAt(i) != str.charAt(j)) {
				count++;
				if (isContinue) {
					int front_del = isPalindrome(str, l-1, i+1, j, false);
					int back_del = isPalindrome(str, l-1, i, j-1, false);
					count += Math.min(front_del, back_del);
				}
				break;
			}
		}
		return count;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for (int tast_case = 1; tast_case <= T; tast_case++) {
			String str = br.readLine();
			int count = isPalindrome(str);
			sb.append(count+"\n");
		}
		
		System.out.println(sb.toString());
	}
}
