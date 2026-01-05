class Solution {
    int count, n, target;
    int[] numbers;
    
    public int solution(int[] numbers, int target) {
        n = numbers.length;
        count = 0;
        this.target = target;
        this.numbers = numbers;
        
        dfs(0, 0);
        return count;
    }
    
    public void dfs (int depth, int total){
        if (depth == n){
            if (total == target) count++;
            return;
        }
        
        dfs(depth+1, total+numbers[depth]);
        dfs(depth+1, total-numbers[depth]);
    }
}