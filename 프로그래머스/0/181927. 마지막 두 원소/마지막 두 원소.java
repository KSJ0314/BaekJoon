import java.util.ArrayList;

class Solution {
    public int[] solution(int[] num_list) {
        int l = num_list.length;
        int[] answer = new int[l+1];
        for (int i = 0; i < l; i++){
            answer[i] = num_list[i];
        }
        int last = num_list[l-1];
        int before = num_list[l-2];
        answer[l] = before < last ? last - before : last * 2;
        return answer;
    }
}