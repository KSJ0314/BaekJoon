class Solution {
    public int solution(int a, int b, int c) {
        int answer = (a+b+c);
        int[] nums = {a,b,c};
        if (a==b || a==c || b==c){
            answer *= pow(nums, 2);
        }
        if (a==b && a==c) {
            answer *= pow(nums, 3);
        }
        return answer;
    }
    
    public int pow(int[] nums, int b){
        int sum = 0;
        for (int num : nums){
            sum += Math.pow(num,b);
        }
        return sum;
    }
}