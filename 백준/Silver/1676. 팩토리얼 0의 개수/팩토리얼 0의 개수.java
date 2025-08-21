import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(br.readLine());
		long mul = 1;
		int count = 0;
		
		for (int i = 2; i <= N; i++) {
			mul *= i;
			while (mul % 10 == 0) {
				mul /= 10;
				count ++;
			}
			mul %= 1000;
		}
		System.out.println(count);
	}

}
