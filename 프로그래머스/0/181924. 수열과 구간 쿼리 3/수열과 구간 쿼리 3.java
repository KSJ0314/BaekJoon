class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        for (int[] querie : queries){
            int temp = arr[querie[0]];
            arr[querie[0]] = arr[querie[1]];
            arr[querie[1]] = temp;
        }
        return arr;
    }
}