import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] inputStr = br.readLine().split(" ");
		long A = Long.valueOf(inputStr[0]);
		long B = Long.valueOf(inputStr[1]);
		
		long diff = B-A;
		long sum = diff+1;
		
		long divisor = 2;
		
		// ((뺀값 - 큰값의나머지) / 나눌 수)*(나눌 수/2)
		while (true) {
			long remainder = B % divisor;
			if (remainder > diff) break;
			sum += (((diff-remainder) / divisor)+1) * (divisor/2);
			divisor*=2;
		}
		
		System.out.println(sum);
	}
}
