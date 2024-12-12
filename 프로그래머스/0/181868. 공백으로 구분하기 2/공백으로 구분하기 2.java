class Solution {
    public String[] solution(String my_string) {
        while (my_string.startsWith(" ")) {
			my_string = my_string.substring(1);
		}
		while (my_string.contains("  ")) {
			my_string = my_string.replace("  ", " ");
		}
        return my_string.split(" ");
    }
}