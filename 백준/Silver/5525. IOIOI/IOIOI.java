import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		String S = br.readLine();
		
		char[] io = {'I', 'O'};
		int ioIdx = 0;
		int sum = 0;
		int count = 1;
		boolean isIOI = false;
		
		for (int i = 0; i < M; i++) {
			if (S.charAt(i) == io[ioIdx]) {
				ioIdx^=1;
				if (isIOI) count++;
				isIOI = true;
			} else {
				int PnCount =(count - (2*N +1)) / 2;
				if (count >= 2*N+1) {
					sum += PnCount+1;
				}
				if (isIOI) i--;
				count = 1;
				ioIdx = 0;
				isIOI = false;
			}
		}
		int PnCount =(count - (2*N +1)) / 2;
		if (count >= 2*N+1) {
			sum += PnCount+1;
		}
		System.out.println(sum);
	}
}
