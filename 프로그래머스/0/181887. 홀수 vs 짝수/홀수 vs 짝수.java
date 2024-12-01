import java.util.stream.IntStream;

class Solution {
	public int solution(int[] num_list) {
        int even = IntStream.iterate(0, i -> i < num_list.length, i -> i+2)
		        	.map(i -> num_list[i])
		        	.sum();
        int odd = IntStream.iterate(1, i -> i < num_list.length, i -> i+2)
	        		.map(i -> num_list[i])
	        		.sum();
        return Math.max(even, odd);
    }
}