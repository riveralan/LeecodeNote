package LeecodeNote.solution;

import java.util.Stack;

/**
 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，分别完成在队列尾部插入整数和在队列头部删除整数的功能
 。(若队列中没有元素，deleteHead 操作返回 -1 )



 示例 1：


 输入：
 ["CQueue","appendTail","deleteHead","deleteHead","deleteHead"]
 [[],[3],[],[],[]]
 输出：[null,null,3,-1,-1]


 示例 2：


 输入：
 ["CQueue","deleteHead","appendTail","appendTail","deleteHead","deleteHead"]
 [[],[],[5],[2],[],[]]
 输出：[null,-1,null,null,5,2]


 提示：


 1 <= values <= 10000
 最多会对 appendTail、deleteHead 进行 10000 次调用


 Related Topics 栈 设计 队列 👍 779 👎 0

 */

//leetcode submit region begin(Prohibit modification and deletion)
class YongLiangGeZhanShiXianDuiLieLcof {

    public YongLiangGeZhanShiXianDuiLieLcof() {

    }

    private final Stack<Integer> readStack = new Stack<>();
    private final Stack<Integer> writeStack = new Stack<>();

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
//leetcode submit region end(Prohibit modification and deletion)
