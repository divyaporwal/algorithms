class MyQueue {
        Stack<Integer> stack1  = new Stack<Integer>();
        Stack<Integer> stack2  = new Stack<Integer>();
    /** Initialize your data structure here. */
    public MyQueue() {
        
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        //put all the elements from stack1 to stack 2 
        while(!stack1.empty()) {
            stack2.push(stack1.pop());
        }
        //add element to stack 2
        stack2.push(x);
        //transfer all the elemtns from stack 2 to stack1 so that the last element is at top
        while(!stack2.empty()) {
            stack1.push(stack2.pop());
        }
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        int x = stack1.pop();
        return x;
    }
    
    /** Get the front element. */
    public int peek() {
        return stack1.peek();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack1.empty();
        
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
