class Solution
{
    //Function to evaluate a postfix expression.
    public static int evaluatePostFix(String S)
    {
        Stack<Integer> stack = new Stack<>();
        
        for(char s : S.toCharArray()){
            int ans = 0;
            if(s>='0' && s<='9'){
                int num = s - '0';
                stack.push(num);
            }   
            else{
                int num1 = stack.peek();
                stack.pop();
                int num2 = stack.peek();
                stack.pop();
                
                switch(s){
                    case '+':
                        ans = num2+num1;
                        stack.push(ans);
                        break;
                    case '*':
                        ans = num2*num1;
                        stack.push(ans);
                        break;
                    case '-':
                        ans = num2-num1;
                        stack.push(ans);
                        break;
                    case '/':
                        ans = num2/num1;
                        stack.push(ans);
                        break;
                }
               
            }
             
        }
       return stack.peek(); 
        
    }
}
