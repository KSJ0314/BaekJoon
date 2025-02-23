import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String a = br.readLine();
		String b = br.readLine();
		int c = Integer.parseInt(br.readLine());
		
		System.out.println(Integer.parseInt(a)+Integer.parseInt(b)-c);
		System.out.println(Integer.parseInt(a+b)-c);
	}
	
}