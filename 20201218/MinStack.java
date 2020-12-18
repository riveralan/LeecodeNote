/**
解题思路：
题中要求时间复杂度为O(1),依据栈的性质（先入后出），每次弹出时应该不要再计算最小值了，而是每压入一个元素就计算一次上一个栈顶的最小值，保持每个元素都携带着最小值信息，这样每次弹出即可从栈顶获取最小值。
**/
class MinStack {
    //数组栈，[当前值，当前最小值]
    private Stack<int[]> stack;
    /** initialize your data structure here. */
    public MinStack() {
        stack=new Stack<>();
    }
    
    public void push(int x) {
        if(stack.isEmpty()){
            stack.push(new int[]{x,x});
        }else{
            //获取上一个最小值
            int lastSmallVal=stack.peek()[1];
            stack.push(new int[]{ x, Math.min(x,lastSmallVal)});
        }
    }
    
    public void pop() {
        stack.pop();
    }
    
    public int top() {
        return stack.peek()[0];
    }
    
    public int getMin() {
        return stack.peek()[1];
    }
}