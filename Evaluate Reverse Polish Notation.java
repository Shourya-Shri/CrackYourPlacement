class Solution {
    public int evalRPN(String[] tokens) {

        int n = tokens.length;
        Stack<String> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            if (tokens[i].equals("+")) {
                int b = Integer.parseInt(stack.pop());
                int a = Integer.parseInt(stack.pop());
                stack.push(String.valueOf(a + b));
            } else if (tokens[i].equals("-")) {
                int b = Integer.parseInt(stack.pop());
                int a = Integer.parseInt(stack.pop());
                stack.push(String.valueOf(a - b));
            } else if (tokens[i].equals("*")) {
                int b = Integer.parseInt(stack.pop());
                int a = Integer.parseInt(stack.pop());
                stack.push(String.valueOf(a * b));
            } else if (tokens[i].equals("/")) {
                int b = Integer.parseInt(stack.pop());
                int a = Integer.parseInt(stack.pop());
                stack.push(String.valueOf(a / b));
            } else {
                stack.push(tokens[i]);
            }
        }

        return Integer.parseInt(stack.pop());
    }
}
