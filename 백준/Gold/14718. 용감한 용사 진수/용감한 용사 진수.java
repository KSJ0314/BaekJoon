import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] input = br.readLine().split(" ");
		int n = Integer.parseInt(input[0]);
		int k = Integer.parseInt(input[1]);
		
		int[][] statArr = new int[n][3];
		int[] strArr = new int[n];
		int[] dexArr = new int[n];
		int[] intArr = new int[n];
		for (int i = 0; i < n; i++) {
			input = br.readLine().split(" ");
			int str = Integer.parseInt(input[0]);
			int dex = Integer.parseInt(input[1]);
			int inte = Integer.parseInt(input[2]);
			statArr[i][0] = str;
			statArr[i][1] = dex;
			statArr[i][2] = inte;
			strArr[i] = str;
			dexArr[i] = dex;
			intArr[i] = inte;
		}
		
		int minStat = 3000000;
		for (int str : strArr) {
			for (int dex : dexArr) {
				for (int inte : intArr) {
					int sum = 0;
					for (int[] stat : statArr) {
						if (stat[0] <= str && stat[1] <= dex && stat[2] <= inte) {
							sum++;
						}
					}
					if (sum >= k) {
						minStat = Math.min(minStat, str+dex+inte);
					}
				}
			}
		}
		
		System.out.println(minStat);
		
	}
}