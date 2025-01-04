import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int result = 0;
		for (int i = 1; i <= N; i++) {
			int temp = i;
			for (String str : String.valueOf(i).split("")) {
				temp += Integer.valueOf(str);
			}
			if (temp == N) {
				result = result == 0 ? i : Math.min(result, i);
			}
		}
		System.out.println(result);
	}

}