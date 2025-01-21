import java.io.*;
public class Main {
	public static int streamFilter(String str, char eq) {
		return (int) new String(str)
							.chars()
							.filter(i -> i == eq)
							.count();
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int strL = str.length();
		int e = streamFilter(str, 'a');
		str += str.substring(0, e);
		
		int min = str.length();
		for (int j = 0, s = 0; j < strL; j++, s++, e++) {
			min = Math.min(min, streamFilter(str.substring(s, e), 'b'));
		}
		
		System.out.println(min);
	}
}