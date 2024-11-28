class Solution {
    public String solution(String my_string, int[] indices) {
        String[] strArr = my_string.split("");
        
        for (int indice : indices) {
        	strArr[indice] = "";
        }
        
        return String.join("", strArr);
    }
}