import java.util.*;

class Solution {
    	public int[] solution(int[] answers) {
		int[] student1 = new int[] {1,2,3,4,5};
		int[] student2 = new int[] {1,3,4,5};
		int[] student3 = new int[] {3,1,2,4,5};
	    int[] scores = {0,0,0};
	    
        for (int i = 0; i < answers.length; i++) {
        	if (student1[i % 5] == answers[i]) scores[0]++;
        	if ((i%2 == 0 && answers[i] == 2) ||
    				(i%2 == 1 && student2[(i/2) % 4] == answers[i])) scores[1]++;
        	if (student3[i == 0 ? 0 : (i/2) % 5] == answers[i]) scores[2]++;
		}
        
        int maxScore = 0;
        for (int score : scores) {
        	maxScore = Math.max(maxScore, score);
        }
        int maxScoreLength = 0;
        for (int i = 0; i < 3; i++) {
			if (scores[i] == maxScore) maxScoreLength++;
		}
        int[] result = new int[maxScoreLength];
        for (int i = 0, j = 0; i < scores.length; i++) {
        	if (scores[i] == maxScore) result[j++] = i+1;
        }
        return result;
    }
}