package LeetCode.Math;

/**
 * 319. Bulb Switcher
 * 7/4/2019
 * 寻找小于n的平方数
 *
 */
public class BulbSwitch {
    public int bulbSwitch(int n) {
        int res = 1;
        while (res * res < n) {
            res++;
        }
        return res;
    }

    public int bulbSwitch2(int n) {
        return (int)Math.sqrt(n);
    }
}
