import java.util.Stack;

class MyQueue {
    private Stack<Integer> readStack = new Stack<Integer>();
    private Stack<Integer> writeStack = new Stack<Integer>();


    /** Initialize your data structure here. */
    public MyQueue() {

    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        writeStack.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if(readStack.empty()&&writeStack.empty()) return -1;
        if(readStack.empty()){
            while(!writeStack.empty()){
                readStack.push(writeStack.pop());
            }
        }
        return readStack.pop();
    }

    /** Get the front element. */
    public int peek() {
        if(readStack.empty()&&writeStack.empty()) return -1;
        if(readStack.empty()){
            while(!writeStack.empty()){
                readStack.push(writeStack.pop());
            }
        }
        return readStack.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return readStack.empty()&&writeStack.empty();
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