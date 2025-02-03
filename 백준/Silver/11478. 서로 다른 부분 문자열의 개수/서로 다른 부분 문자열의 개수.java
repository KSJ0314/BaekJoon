import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		List<String> list = new ArrayList<>();
		
		for (int i = 1; i <= str.length(); i++) {
			for (int j = 0; j < str.length()-i+1; j++) {
				list.add(str.substring(j, j+i));
			}
		}
		
		System.out.println(list.stream().distinct().count());
	}
}