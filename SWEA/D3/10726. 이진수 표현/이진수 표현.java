import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{

		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
			System.out.print("#"+test_case+" ");
            int N = sc.nextInt();
            int M = sc.nextInt();
			
            int bit = (1<<N )-1;
			System.out.println((M & bit ) == bit ? "ON" : "OFF");

		}
	}
}