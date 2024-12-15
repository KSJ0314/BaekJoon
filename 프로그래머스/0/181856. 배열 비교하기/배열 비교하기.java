import java.util.*;

class Solution {
    public int solution(int[] arr1, int[] arr2) {
        int l1 = arr1.length;
        int l2 = arr2.length;
        
        if (l1 == l2){
            l1 = Arrays.stream(arr1).sum();
            l2 = Arrays.stream(arr2).sum();
        }
        
        return l1 == l2 ? 0 : l1 > l2 ? 1 : -1;
    }
}