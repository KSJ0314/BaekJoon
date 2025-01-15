import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		TreeMap<Integer, TreeSet<Integer>> tm = new TreeMap<>();
		
		for (int i = 0; i < N; i++) {
			String[] inputStr = br.readLine().split(" ");
			int x = Integer.parseInt(inputStr[0]);
			int y = Integer.parseInt(inputStr[1]);
			tm.putIfAbsent(x, new TreeSet<>());
			tm.get(x).add(y);
		}
		
		for (Integer key : tm.keySet()) {
			TreeSet<Integer> values = tm.get(key);
			for (Integer value : values) {
				System.out.println(key + " " + value);
			}
		}
		
	}
}
