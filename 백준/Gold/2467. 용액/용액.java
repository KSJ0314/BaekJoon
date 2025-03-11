import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static Deque<Integer> inputDeque;
	static Deque<Integer> cycleDeque;
    
    public static void main(String[] args) throws IOException {
        init();
        
        int num1 = inputDeque.pollFirst();
        int num2 = inputDeque.pollLast();
        int r1 = num1, r2 = num2;
        int minDiff = Math.abs(num1+num2);
        boolean isFirst = true;
        
        if (Math.abs(num1) > Math.abs(num2)) {
        	cycleDeque.offerLast(num2);
    	} else {
    		cycleDeque.offerLast(num1);
    		isFirst = false;
    	}
        
        while (!inputDeque.isEmpty()) {
        	if (isFirst) {
        		cycleDeque.offerLast(inputDeque.pollFirst());
        	} else {
        		cycleDeque.offerLast(inputDeque.pollLast());
        	}
        	num1 = cycleDeque.peekFirst();
        	num2 = cycleDeque.peekLast();
        	if (minDiff > Math.abs(num1+num2)) {
        		minDiff = Math.abs(num1+num2);
        		if (num1 < num2) {
        			r1 = num1;
        			r2 = num2;
        		} else {
        			r1 = num2;
        			r2 = num1;
        		}
        	}
        	
//        	System.out.println(minDiff);
//        	System.out.println(num1+" "+num2);
        	
        	if (Math.abs(num1) > Math.abs(num2)) {
        		cycleDeque.pollFirst();
        	} else {
        		cycleDeque.pollLast();
        	}
        	isFirst = cycleDeque.peek() > 0;
        	
        	if (minDiff == 0) break;
        }
        
        System.out.println(r1 + " " + r2);
    }

	static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        inputDeque = new ArrayDeque<>(N);
        cycleDeque = new ArrayDeque<>();
        
        String[] strs = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
        	int num = Integer.parseInt(strs[i]);
        	inputDeque.offerLast(num);
		}
		
	}
    
}