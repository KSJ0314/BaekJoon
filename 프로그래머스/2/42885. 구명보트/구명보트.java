import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        Arrays.sort(people);
        int cnt = 0;
        for (int i = 0, j = people.length-1; i <= j; j--, cnt++){
            if (people[i] + people[j] <= limit){
                i++;
            }
        }
        return cnt;
    }
}