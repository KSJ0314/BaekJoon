import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int i = 1;
		while (n>i) {
			n-=i;
			i++;
		}
		
		int a = n;
		int b = i-n+1;
		if (i%2 == 1) {
			int temp = a;
			a = b;
			b = temp;
		}
		
		System.out.println(a+"/"+b);

	}

}
