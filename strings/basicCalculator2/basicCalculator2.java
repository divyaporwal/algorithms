class Solution {
    public int calculate(String s) {
            //if length of s is null, return 0
            if(s == null ) {
                return 0;
            }
            //initialise a stack to store the number 
            Stack<Integer> stack = new Stack<Integer>();
            //initialise num = 0, op is the sign, 
            int num = 0;
            char op = '+';
            //declare a variable to iterate through the string
            int i = 0;
        
            while(i < s.length()) {
                //if value is a digit, then we simply mark it as num and also take care of the consecutive numbers if any
                if(Character.isDigit(s.charAt(i))) {
                    num = num * 10 + s.charAt(i) - '0';
                }
                //if the character is not a digit and a blank space, or we are at the last position of the string,
                if(!Character.isDigit(s.charAt(i))  && s.charAt(i) != ' ' || i == s.length()-1) {
                    //if sign is -, push -num
                    if(op == '-') {
                        stack.push(-num);
                    }
                    //if sign is +, push num
                    if(op == '+') {
                        stack.push(num);
                    }
                    //if sign is *, multiply the two
                    if(op == '*') {
                        stack.push(num * stack.pop());
                    }
                    //if sign is /, divide the two
                    if(op == '/') {
                        stack.push(stack.pop()/num);
                    }
                    //update the sign to be used in next iteration
                     op = s.charAt(i);
                    //update the number to 0 since the previous and the next number would be separate and not part of the same digit
                     num = 0;
                    
                }
                i++;
            }
            int result = 0;
        //add the values present in stack 
        for(int j : stack) {
            result = result + j;
        }
        return result;
            
        }
    };
