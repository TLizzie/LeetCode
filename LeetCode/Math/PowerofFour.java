package LeetCode.Math;

/**
 * 342. Power of Four
 * 7/2/2019
 *
 */

public class PowerofFour {
    public boolean isPowerofFour (int num) {
        if (num > 1) {
            while (num % 4 == 0) {
                num /= 4;
            }
        }
        return num == 1;
    }

    public boolean isPowerofFour2 (int num) {
        return Math.log(num) / Math.log(4) % 1 == 0;
    }
}
