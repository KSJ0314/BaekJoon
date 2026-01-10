import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Deque<Integer> progressesQue = new ArrayDeque<>();
        Deque<Integer> speedsQue = new ArrayDeque<>();
        Deque<Integer> countQue = new ArrayDeque<>();
        
        for (int i = 0; i < progresses.length; i++){
            progressesQue.addLast(progresses[i]);
            speedsQue.addLast(speeds[i]);
        }
        
        while (!progressesQue.isEmpty()){
            boolean canDeploy = true;
            int count = 0;
            for (int size = progressesQue.size(); size > 0; size--){
                int progres = progressesQue.pollFirst();
                int speed = speedsQue.pollFirst();
                int nextProgres = progres+speed;
                if (canDeploy && nextProgres >= 100){
                    count++;
                } else {
                    canDeploy = false;
                    progressesQue.addLast(nextProgres);
                    speedsQue.addLast(speed);
                }
            }
            if (count > 0){
                countQue.addLast(count);
            }
        }
        
        int[] answer = new int[countQue.size()];
        for (int i = 0; !countQue.isEmpty(); i++){
            answer[i] = countQue.pollFirst();
        }
        return answer;
    }
}