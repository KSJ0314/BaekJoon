
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static int N;
	static String ans;
	static boolean found;

	static void func(int depth, String s) {
		if(found) {
			return;
		}
		if(!isGood(s)) {
			return;
		}
		
		if(depth == N) {
			found = true;
			ans = new String(s);
			return; 
		}

		
		for(int i=0; i<3; i++) {
			func(depth+1, s+String.valueOf(i+1));
		}
	}

	static boolean isGood(String s) {
		int k = 1;
		int i = 0;
		
		while (true) {
			if (i + k >= s.length()) {
				break;
			}
			String back = s.substring(s.length() - k, s.length());
			String front = s.substring(s.length() - k - k, s.length() - k);
			//System.out.println(back + " " + front);
			if(back.equals(front)) {
				return false;
			}
			i++;
			k++;
		}
		return true;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		func(1, "1");
		System.out.println(ans);
	}

}
