import java.io.*;
import java.util.LinkedList;

public class Main {
	
	static LinkedList<Integer>[] lists;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		init(br);
		fn(br);
		System.out.println(calSum());
	}

	static void fn(BufferedReader br) throws IOException {
		int K = Integer.parseInt(br.readLine());
		String[] strs;
		while (K-- > 0) {
			strs = br.readLine().split(" ");
			int idx = Integer.parseInt(strs[0])-1;
			int oper = Integer.parseInt(strs[1]);
			rotate(idx, oper, 1<<idx);
		}
	}

	static void rotate(int idx, int oper, int flag) {
		int pre = idx-1;
		int next = idx+1;
		if (pre >= 0
				&& (flag&1<<pre)==0
				&& lists[idx].get(6) != lists[pre].get(2)) {
			rotate(pre, oper*-1, flag|1<<pre);
		}
		if (next < 4
				&& (flag&1<<next)==0
				&& lists[idx].get(2) != lists[next].get(6)) {
			rotate(next, oper*-1, flag|1<<next);
		}
		
		LinkedList<Integer> list = lists[idx];
		if (oper == 1) {
			list.offerFirst(list.pollLast());
		} else {
			list.offerLast(list.pollFirst());
		}
	}

	static int calSum() {
		int sum = 0;
		for (int i = 0; i < 4; i++) {
			if(lists[i].peekFirst() == 1) sum += 1 << i;
		}
		return sum;
	}

	static void init(BufferedReader br) throws IOException {
		String[] strs;
		lists = new LinkedList[4];
		
		for (int i = 0; i < 4; i++) {
			lists[i] = new LinkedList<>();
			strs = br.readLine().split("");
			for (String str : strs) {
				lists[i].offerLast(Integer.parseInt(str));
			}
		}
	}
}