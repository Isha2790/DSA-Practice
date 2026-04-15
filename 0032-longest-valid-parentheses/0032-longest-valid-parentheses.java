class Solution {
    public int longestValidParentheses(String s) {
        int max = 0, last = -1;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                if (!stack.isEmpty()) {
                    stack.pop();
                    int start = stack.isEmpty() ? last : stack.peek();
                    max = Math.max(max, i - start);
                } else {
                    last = i;
                }
            }
        }
        return max;
    }
}