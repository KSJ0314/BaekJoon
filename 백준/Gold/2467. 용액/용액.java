import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static Deque<Integer> inputDeque;
	static Deque<Integer> cycleDeque;
    
    public static void main(String[] args) throws IOException {
        init();
        
        int[] result = new int[2];
        int minDiff = Integer.MAX_VALUE;
        boolean isFirst = false;
        
        while (!inputDeque.isEmpty()) {
        	int nextNum = isFirst ? inputDeque.pollFirst() : inputDeque.pollLast();
        	cycleDeque.offerLast(nextNum);
        	
        	int num1 = cycleDeque.peekFirst();
        	int num2 = cycleDeque.peekLast();
        	int diff = Math.abs(num1+num2);
        	
        	if (minDiff > diff) {
        		minDiff = diff;
        		result[0] = num1;
        		result[1] = num2;
        	}
        	
        	if (Math.abs(num1) > Math.abs(num2)) {
        		cycleDeque.pollFirst();
        	} else {
        		cycleDeque.pollLast();
        	}
        	isFirst = cycleDeque.peek() > 0;
        	
        	if (minDiff == 0) break;
        }
        
        Arrays.sort(result);
        System.out.println(result[0] + " " + result[1]);
    }

	static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        inputDeque = new ArrayDeque<>(N);
        cycleDeque = new ArrayDeque<>();
        
        String[] strs = br.readLine().split(" ");
        for (int i = 1; i < N; i++) {
        	int num = Integer.parseInt(strs[i]);
        	inputDeque.offerLast(num);
		}
        cycleDeque.offerLast(Integer.parseInt(strs[0]));
		
	}
    
}