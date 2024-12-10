class Solution {
    public String solution(String myString) {
        StringBuilder sb = new StringBuilder();
        for (char ch : myString.toUpperCase().toCharArray()){
            sb.append(ch == 'A' ? ch : Character.toLowerCase(ch));
        }
        return sb.toString();
    }
}