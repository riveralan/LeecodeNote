package LeecodeNote.solution;

import java.util.Stack;
/**
 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。

 实现 MinStack 类:


 MinStack() 初始化堆栈对象。
 void push(int val) 将元素val推入堆栈。
 void pop() 删除堆栈顶部的元素。
 int top() 获取堆栈顶部的元素。
 int getMin() 获取堆栈中的最小元素。




 示例 1:


 输入：
 ["MinStack","push","push","push","getMin","pop","top","getMin"]
 [[],[-2],[0],[-3],[],[],[],[]]

 输出：
 [null,null,null,null,-3,null,0,-2]

 解释：
 MinStack minStack = new MinStack();
 minStack.push(-2);
 minStack.push(0);
 minStack.push(-3);
 minStack.getMin();   --> 返回 -3.
 minStack.pop();
 minStack.top();      --> 返回 0.
 minStack.getMin();   --> 返回 -2.




 提示：


 -2³¹ <= val <= 2³¹ - 1
 pop、top 和 getMin 操作总是在 非空栈 上调用
 push, pop, top, and getMin最多被调用 3 * 10⁴ 次


 Related Topics 栈 设计 👍 1656 👎 0

 */

//leetcode submit region begin(Prohibit modification and deletion)
public class MinStack {
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
//leetcode submit region end(Prohibit modification and deletion)