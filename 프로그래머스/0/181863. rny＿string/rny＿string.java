class Solution {
    public String solution(String rny_string) {
        return String.join("rn", rny_string.split("m", -1));
    }
}