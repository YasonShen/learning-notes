package com.yang.exam;

/**
 *
 * 一个环上有10个点，编号为0-9，从0点出发，每步可以顺时针到下一个点，也可以逆时针到上一个点，求：
 * 经过n步回到0点有多少种不同的走法？
 */
public class YuanHuan {

    /**
     * 考虑用动态规划的思想，只可能从左边或者右边相邻点回到原点，即先到旁边的点，看看有多少回来的方法。
     *
     * 所以动态转移方程为dp[step][n]=dp[step-1][(n-1+10)%10]+dp[k-1][(n+1)%10]
     * 其中，step为步数，n为到达的位置。取模保证范围在0~n-1，初始n=0,从0号位置开始
     * @param n
     * @param step
     * @return
     */

    //动态规划
    /*
        dp  0   1   2
        0   1   0   2
        1   0   1   0
        2   0   0   1
        3   0   0   0
        ...

     */
    private static int backToZero(int n, int step){
        int[][] dp = new int[step + 1][n];

        dp[0][0] = 1;
        for(int i = 1; i <= step; i++){
            for(int j = 0; j < n; j++){
                dp[i][j] = dp[i - 1][(j + 1) % n] + dp[i - 1][(j - 1 + n) % n];
            }
        }

        return dp[step][0];
    }


    /**
     * 递归法
     * @param n
     * @param step
     * @return
     */
    public int backToZero2(int n, int step){
        return dfs(n, 0, step);
    }

    private int dfs(int n, int i, int step) {
        if(step == 0){
            if(i == 0){
                return 1;
            }else {
                return 0;
            }
        }
        int one = dfs(n, (i + 1) % n, step - 1);
        int two = dfs(n, ((i - 1) + n) % n, step - 1);

        return one + two;
    }

    public static void main(String[] args) {
        System.out.println(backToZero(10, 2));
    }
}
