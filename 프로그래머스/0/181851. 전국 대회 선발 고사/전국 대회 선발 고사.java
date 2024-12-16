class Solution {
    public int solution(int[] rank, boolean[] attendance) {
        int answer = 0;
		int multiplier = 10000;
		while (multiplier > 0) {
			answer += highestIdx(rank, attendance, multiplier);
			multiplier /= 100;
		}
		return answer;
    }
	
	public int highestIdx (int[] rank, boolean[] attendance, int multiplier) {
		int hIdx = 0;
		for (int i = 0; i < attendance.length; i++) {
			if (attendance[i]) {
				hIdx = i;
				break;
			}
		}
		
		for (int i = hIdx+1; i < rank.length; i++) {
			if (rank[hIdx] > rank[i] && attendance[i]) {
				hIdx = i;
			}
		}
		attendance[hIdx] = false;
		
		return hIdx * multiplier;
	}
}