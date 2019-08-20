package LeetCode.Array;

/**
 * Leetcode 45 JumpGameII
 * 2019/05/19
 * 用了贪心的策略，reached和times表示跳了times次后，某一段区间内最小的步伐到达数量，而times的计算需要一个上下界
 * times就是跳了多少次
 * reached就是当前跳了times次时能到的最远范围
 * max是路过的位置之处再跳一次能到达的最远的位置
 * 总之就是用了贪心的策略，reached和times表示跳了times次后，某一段区间内最小的步伐到达数量
 * 而max则记录了路过的所有节点的，再跳一次能有多远，这个可以用来更新reached
 *
 */
public class JumpGameII {
    public static int JumpGameII(int nums[]) {
        if (nums.length <= 1 || nums == null) {
            return 0;
        }
        int max = 0;
        int reached = 0;
        int times = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > reached) {
                times++;
                reached = max;
            }
            max = Math.max(max, nums[i] + i);
        }
        return times;

    }
}
