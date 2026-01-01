import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int test_case = 0; test_case < T; test_case++){
            int N = Integer.parseInt(br.readLine());
            int[] nums = new int[N];
            int i = 0;
            for (String str : br.readLine().split(" ")){
                int num = Integer.parseInt(str);
                nums[i++] = num;
            }          
            Long sum = 0L;
            int max = nums[--i];
            i--;
            for (; i >= 0; i--) {
            	int num = nums[i];
            	if (max > num){
            		sum += max-num;
            	}
            	max = Math.max(max, num);
            }
            
            System.out.println(sum);
        }
    }
}