/**
解题思路：
1、一个为存储栈writeStack，一个为读取队列readStack
2、每次执行appendTail操作，往writeStackpush数据
3、每次执行deleteHead操作，从readStack pop数据；如果readStack为空，则writeStack Pop数据到readStack，直到writeStack为空后，readStack pop数据
4、两个栈为空，返回空
**/
class CQueue {
    private Stack<Integer> readStack = new Stack<Integer>();
    private Stack<Integer> writeStack = new Stack<Integer>();
    public CQueue() {

    }
    
    public void appendTail(int value) {
        writeStack.push(value);
    }
    
    public int deleteHead() {
        if(readStack.empty()&&writeStack.empty()) return -1;
        if(readStack.empty()){
            while(!writeStack.empty()){
                readStack.push(writeStack.pop());
            }
        }
        return readStack.pop();
    }
}

/**
 * Your CQueue object will be instantiated and called as such:
 * CQueue obj = new CQueue();
 * obj.appendTail(value);
 * int param_2 = obj.deleteHead();
 */