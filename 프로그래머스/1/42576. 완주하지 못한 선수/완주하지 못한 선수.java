import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> map = new HashMap<>();
        for (String str : participant){
            map.merge(str, 1, Integer::sum);
        }
        for (String str : completion){
            map.merge(str, -1, Integer::sum);
            if (map.get(str) == 0) map.remove(str);
        }
        String res = null;
        for (String key : map.keySet()){
            res = key;
        }
        return res;
    }
}