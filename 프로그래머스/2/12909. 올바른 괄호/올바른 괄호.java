import java.util.*;

class Solution {
    boolean solution(String s) {
        Deque<Character> deque = new ArrayDeque<>();
        for (char c : s.toCharArray()){
            if (deque.size() > 0 && deque.peekLast() == '(' && c == ')'){
                deque.pollLast();
            } else {
                deque.addLast(c);
            }
        }

        return deque.size() == 0;
    }
}