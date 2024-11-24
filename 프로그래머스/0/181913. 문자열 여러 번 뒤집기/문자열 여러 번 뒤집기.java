class Solution {
    public String solution(String my_string, int[][] queries) {
        for (int[] querie : queries){
			my_string = my_string.substring(0, querie[0])
                + new StringBuilder(my_string.substring(querie[0], querie[1]+1)).reverse().toString()
                + my_string.substring(querie[1]+1);
        }
        return my_string;
    }
}