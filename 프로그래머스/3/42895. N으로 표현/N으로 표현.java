import java.util.*;

class Solution {
    public int solution(int N, int number) {
        List<Integer>[] dp = new ArrayList[9];
        
        for(int i = 0; i <= 8; i++) {
            dp[i] = new ArrayList<>();
        }
        
        for(int i = 1; i <= 8; i++) {
            int repeatN = Integer.parseInt(String.valueOf(N).repeat(i));
            dp[i].add(repeatN);
            
            for (int j = 1; j < i; j++) {
                for (int a: dp[j]) {
                    for (int b : dp[i - j]) {
                        dp[i].add(a + b);
                        dp[i].add(a - b);
                        dp[i].add(b - a);
                        dp[i].add(a * b);
                        if (b != 0) dp[i].add(a / b);
                        if (a != 0) dp[i].add(b / a);
                    }
                }
            }
            
            if (dp[i].contains(number)) {
                return i;
            }
        }
        
        return -1;
    }
}