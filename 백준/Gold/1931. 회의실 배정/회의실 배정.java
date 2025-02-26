import java.util.*;

public class Main {
	static class Meeting implements Comparable<Meeting>{
		int start, end;	// 회의 시작, 종료 시간

		public Meeting(int start, int end) {
			this.start = start;
			this.end = end;
		}

		@Override
		public int compareTo(Meeting o) {
			return this.end != o.end ? this.end-o.end : this.start-o.start;
		}
		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		Meeting[] meetings = new Meeting[N];
		
		for (int i = 0; i < N; i++) {
			meetings[i] = new Meeting(sc.nextInt(), sc.nextInt());
		}
		
		Arrays.sort(meetings);
		Deque<Meeting> result = new ArrayDeque<>();
		result.offerLast(meetings[0]);
		
		for (int i = 1; i < N; i++) {
			if (result.peekLast().end <= meetings[i].start) {
				result.offerLast(meetings[i]);
			}
		}
		
		System.out.println(result.size());
	}

}
