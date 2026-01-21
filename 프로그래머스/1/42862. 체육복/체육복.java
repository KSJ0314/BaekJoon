import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        boolean[] isLost = new boolean[n+1];
        boolean[] isReserve = new boolean[n+1];
        for (int l : lost) {
            isLost[l] = true;
        }
        Arrays.sort(lost);
        Arrays.sort(reserve);
        ArrayList<Integer> list = new ArrayList<>();
        for (int r : reserve){
            isReserve[r] = true;
            if (isLost[r]) continue;
            list.add(r);
        }
        int i = 0;
        int cnt = 0;
        for (int l : lost) {
            if (isReserve[l]) continue;
            while (i < list.size()) {
                if (l-1 <= list.get(i) && list.get(i) <= l+1){
                    i++;
                    cnt--;
                    break;
                } else if (l+1 < list.get(i)){
                    break;
                }
                i++;
            }
            cnt++;
        }
        
        return n-cnt;
    }
}