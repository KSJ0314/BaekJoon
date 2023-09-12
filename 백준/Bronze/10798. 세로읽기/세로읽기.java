import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		String[] strs = new String[5];
		
		for (int i = 0; i < 5; i++) {
			strs[i] = sc.next();
		}
		
		int max = strs[0].length();
		for (int i = 1; i < 5; i++) {
			if (max < strs[i].length()) {
				max = strs[i].length();
			}
		}
		
		ArrayList<String> chars = new ArrayList<>();
		for (int i = 0; i < max; i++) {
			for (int j = 0; j < 5; j++) {
				try {
					chars.add(strs[j].substring(i,i+1));
				} catch (StringIndexOutOfBoundsException e) {
				}
			}
		}
		
		for(String str : chars) {
			System.out.print(str);
		}
		
		
	}

}