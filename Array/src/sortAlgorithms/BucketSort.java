package sortAlgorithms;



import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * 2019/5/17
 * 桶排序算法
 * LeetCode 41，387
 *
 * 思路：
 * 1. 找出nums[]的 max & min
 * 2. 确定边界条件，初始化嵌套的bucket list bucket.add
 * 3. 将元素放到不同的桶里
 * 4. 将桶内元素排序
 * 最开始只是初始化了大的List，内部嵌套的List需要用for循环来初始化
 *
 * n: 待排序的数据 m: 桶的个数
 * time(best) ：O(n), space: O(n + m)
 * Amortized: O(n + c) ~ n * (logn ~ logm)
 * stable
 */

public class BucketSort {

    public static void BucketSort(int[] nums) {
        int max = 0;                                                        // 使用Math.max 报错 不知道为什么
        int min = 0;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(nums[i], max);
            min = Math.min(nums[i], min);
        }
        
        int bucketNum = (max - min) / nums.length + 1;      // 边界条件
        List<List<Integer>> bucket = new ArrayList<>();
        for (int i = 0; i < bucketNum; i++) {
            bucket.add(new ArrayList<>());
        }

        System.out.println("max: " + max);
        System.out.println("min: " + min);
        System.out.println("BucketNum: " + bucketNum);


        for (int i = 0; i < nums.length; i++) {
            int num = (nums[i] - min) / nums.length;
            bucket.get(num).add(nums[i]);
            
        }

        for (int i = 0; i < bucket.size(); i++) {
            Collections.sort(bucket.get(i));
            
        }

        System.out.println(bucket.toString());

    }

    public static void main(String[] args) {

        int[] nums = new int[]{3,5,7,1,3,9,10};
        BucketSort(nums);

    }

}
