import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int B = sc.nextInt();
		String c = "";
		String d = "";
		
		while(N>0) {
			int a = N%B;
			char b = (char)(a+48);
			if (a>=10) {
				b = (char)(a+55);
			}
			c+=b;
			N /= B;
		}
		for(int i = c.length()-1; i >= 0; i--) {
			d += c.charAt(i);
		}
		System.out.println(d);
		
	}

}