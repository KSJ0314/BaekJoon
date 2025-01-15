import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		String[] strArr = new String[51];
		
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			int leng = str.length();
			if (strArr[leng] == null) {
				strArr[leng] = "";
			}
			strArr[leng] += str+",";
		}
		for (String strs : strArr) {
			if (strs != null) {
				for (String str : Arrays.stream(strs.split(",")).sorted().distinct().toArray(String[]::new)) {
					System.out.println(str);
				}
			}
		}
		
	}
}
