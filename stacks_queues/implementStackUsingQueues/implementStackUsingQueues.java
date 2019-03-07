class MyStack {

    /** Initialize your data structure here. */
    Queue<Integer> q1 = new LinkedList<>();
    Queue<Integer> q2 = new LinkedList<>();
    public MyStack() {
        
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
        //add element to q1
        q1.add(x);
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        //check for q1 size
        int s = q1.size();
        // one by one remove all the elements from q1 and put in q2 except the last one
        while(s>1) {
            q2.add(q1.remove());
            s--;
        }
        // store the last element in q1 in a variable and remove it
        int x = q1.remove();
        //swap the names of q1 and q2
        Queue<Integer> temp = q2;
        q2 = q1;
        q1 = temp;
        return x;
    }
    
    /** Get the top element. */
    public int top() {
        //check for q1 size
        int s = q1.size();
        // remove elements from q1 and put them in q2 except the last one
        while(s>1) {
            q2.add(q1.remove());
            s--;
        }
        //store the last one and remove it from q1
        int x = q1.remove();
        // add it to q2
        q2.add(x);
        //swap the names of q1 and q2 to avoid one more operation of interchaning the elements
        Queue<Integer> temp = q2;
        q2 = q1;
        q1 = temp;
        return x;
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        return q1.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
