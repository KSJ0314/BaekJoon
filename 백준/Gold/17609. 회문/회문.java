import java.io.*;

public class Main {
	
	public int isPalindrome(String str) {
		int count = 0;
		int strL = str.length();
		for (int i = 0, j = strL-1; i <= strL / 2; i++, j--) {
			if (str.charAt(i) != str.charAt(j)) {
				count++;
				count += Math.min(isPseudo(str, i+1, j), isPseudo(str, i, j-1));
				break;
			}
		}
		return count;
	}
	
	public int isPseudo(String str, int iIdx, int jIdx) {
		int count = 0;
		int strL = str.length()-1;
		for (int i = iIdx, j = jIdx; i <= strL / 2; i++, j--) {
			if (str.charAt(i) != str.charAt(j)) {
				count++;
				break;
			}
		}
		return count;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		Main m = new Main();
		
		StringBuilder sb = new StringBuilder();
		for (int tast_case = 1; tast_case <= T; tast_case++) {
			String str = br.readLine();
			int count = m.isPalindrome(str);
			sb.append(count+"\n");
		}
		System.out.println(sb.toString());
	}
}
