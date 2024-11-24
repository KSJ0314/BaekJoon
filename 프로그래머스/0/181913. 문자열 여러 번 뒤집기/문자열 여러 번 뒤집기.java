class Solution {
    public String solution(String my_string, int[][] queries) {
        StringBuilder sb = new StringBuilder();
        for (int[] querie : queries){
			my_string = my_string.substring(0, querie[0])
                + sb.append(my_string.substring(querie[0], querie[1]+1)).reverse()
                + my_string.substring(querie[1]+1);
            sb.setLength(0);
        }
        return my_string;
    }
}