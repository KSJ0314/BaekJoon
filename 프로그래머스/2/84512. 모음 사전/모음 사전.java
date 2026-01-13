class Solution {
	String[] strs = {"A", "E", "I", "O", "U"};
	int cnt = 0;
	
    public int solution(String word) {
    	dfs(0, word, "");
        return cnt;
    }
    
    public boolean dfs (int depth, String word, String str) {
    	if (depth == 5) return false;
    	for (int i = 0; i < strs.length; i++) {
    		System.out.println(str+strs[i]);
			cnt++;
			if (word.equals(str+strs[i])) return true;
			if (dfs(depth+1, word, str+strs[i])) return true;
		}
    	return false;
    }
}