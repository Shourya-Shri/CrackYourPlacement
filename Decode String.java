class Solution {
    public String decodeString(String s) {
        Stack<Character> stack = new Stack<>();
        
        for(char ch : s.toCharArray()) {
            if(ch != ']') {
                stack.push(ch);
                continue;
            }
            
            StringBuilder innerString = new StringBuilder();
            while(!stack.isEmpty() && stack.peek() != '[') {
                innerString.insert(0, stack.pop());
            }
            stack.pop(); // Pop '['
            
            StringBuilder multiplierStr = new StringBuilder();
            while(!stack.isEmpty() && Character.isDigit(stack.peek())) {
                multiplierStr.insert(0, stack.pop());
            }
            
            int multiplier = Integer.parseInt(multiplierStr.toString());
            String repeatedString = innerString.toString().repeat(multiplier);
            
            for(char c : repeatedString.toCharArray()) {
                stack.push(c);
            }
        }
        
        StringBuilder result = new StringBuilder();
        while(!stack.isEmpty()) {
            result.insert(0, stack.pop());
        }
        
        return result.toString();
    }
}
