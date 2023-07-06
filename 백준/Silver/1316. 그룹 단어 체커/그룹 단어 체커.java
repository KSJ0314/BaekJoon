import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int result = N;
		
		for (int i = 0; i < N; i++) {
			String S = br.readLine();				//
			char[] arrC = new char[S.length()];		//
			for (int j = 0; j < S.length(); j++) {	//
				arrC[j] = S.charAt(j);				//
			}										// 입력을 char[]로 변환
			
			int[] alpha = new int [26];
			alpha[arrC[0]-97] = 1;
			O : for (int j = 0; j < S.length() - 1; j++) {
				if (arrC[j] != arrC[j + 1]) {
					switch (alpha[arrC[j+1]-97]) {
					case 0:
						alpha[arrC[j+1]-97] = 1;
						break;
					case 1:
						result--;
						break O;
					}
				}
			}
		}
		System.out.println(result);
	}

}
