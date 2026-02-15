import java.io.*;
import java.util.Arrays;


public class Main {
	public static class Meat implements Comparable<Meat>{
		int v, w;

		public Meat(int v, int w) {
			this.v = v;
			this.w = w;
		}

		@Override
		public int compareTo(Meat o) {
			if (this.w != o.w) return Integer.compare(this.w, o.w);
			return Integer.compare(o.v, this.v);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] inputs;
		
		inputs = br.readLine().split(" ");
		int N = Integer.parseInt(inputs[0]);
		int M = Integer.parseInt(inputs[1]);
		
		Meat[] meats = new Meat[N];
		for (int i = 0; i < N; i++) {
			inputs = br.readLine().split(" ");
			int v = Integer.parseInt(inputs[0]);
			int w = Integer.parseInt(inputs[1]);
			
			meats[i] = new Meat(v, w);
		}
		
		Arrays.sort(meats);
		
		int buyV = 0;
		int usedW = 0;
		int crtW = 0;
		int crtV = 0;
		boolean isEnd = false;
		for (Meat meat : meats) {
			if (meat.w != usedW) {
				if (isEnd) {
					System.out.println(Math.min(usedW + crtW, meat.w));
					return;
				}
				buyV += meat.v + crtV;
				usedW = meat.w;
				crtW = 0;
				crtV = 0;
				if (buyV >= M) {
					System.out.println(usedW);
					return;
				}
			} else {
				if (isEnd) continue;
				crtW += meat.w;
				crtV += meat.v;
				if (buyV + crtV >= M) {
					isEnd = true;
				}
			}
		}
		if (isEnd) {
			System.out.println(usedW + crtW);
		} else {
			System.out.println(-1);
		}
	}

}