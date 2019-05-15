package com.company;
/**
 *  date: 5/13/2019
 *  计算时间空间复杂度
 *  递归调用
 *  优化 使用hashmap,存储中间值

 */

public class Fibonacci {

    static int count = 0;

    public static int fibonacci(int num) {
        if (num == 1 || num == 2) {
            return 1;
        }   else {
            count++;
            for (int i = 0; i < count; i++) {
                System.out.print("-");
            }
            System.out.println(num);
            return fibonacci(num - 1) + fibonacci(num - 2);
        }
    }

    static int max = 100;
    static int[] memorization = new int[max];

    static void DP(int num){
        memorization[1] = 1;
        memorization[2] = 1;
        for(int i =3; i <= num; ++i){
            memorization[i] = memorization[i-1]+memorization[i-2];
        }
    }


    public static int fibonacci2(int num) {
        if (num == 1 || num == 2) {
            memorization[num] = 1;
        }   else{
            if (memorization[num] == 0) {
                memorization[num] = fibonacci2(num - 1) + fibonacci2(num - 2);
                //memorization[num] = memorization[num-1]+memorization[num-2];
            }

        }
        return memorization[num];
    }

    public static void main(String[] args) {
        int num = 10;
        DP(num);
//        System.out.println("No"+num + " "+fibonacci(num));
//        System.out.println("No"+num + " "+fibonacci2(num));
        for(int i = 1; i <= num;++i){
            System.out.println(memorization[i]);
        }
    }
}
