package LeetCode.Stack;

import java.util.Stack;

/**
 * 388
 * 7/26/2019
 *
 * 可以借助一个栈来保存当前层的路径, 层数可以利用tab字符的个数来确定,
 * 如果当前行的层数大于栈顶元素并且非文件, 就可以让其进入栈,
 * 否则如果当前行是文件就可以比较大小,
 * 如果当前行是目录但是深度小于等于栈顶元素, 就可以将栈顶元素出栈, 直到为空或者小于当前行的深度.
 *
 * "dir \n\tsubdir1 \n\t\tfile1.ext \n\t\tsubsubdir1 \n\tsubdir2 \n\t\tsubsubdir2 \n\t\t\tfile2.ext"
 * "dir \tsubdir1 \t\tfile1.ext \t\tsubsubdir1 \tsubdir2 \t\tsubsubdir2 \t\t\tfile2.ext"
 *  level     1           2             2            1           2               2
 *
 */
public class LongestAbsoluteFilePath {
    public int lengthLongestPath(String input) {
        int res = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for (String str : input.split("\n")) {
            int level = str.lastIndexOf("\t") + 1;
            //上一个node已经是父节点
            while (level + 1 < stack.size()) {
                stack.pop();
            }
            int len = stack.peek() + str.length() - level + 1;
            stack.push(len);
            if (str.contains(".")) {
                res = Math.max(res, len - 1);
            }
        }
        return res;
    }

}
