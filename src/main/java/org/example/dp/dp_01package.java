package org.example.dp;
//1. 状态定义
//dp[i][j]：前 i 件物品，背包容量为 j 时的最大价值。
//2. 状态转移
//对第 i 件物品：
//不选：dp[i][j] = dp[i-1][j]
//选：dp[i][j] = dp[i-1][j - w[i]] + v[i]（前提：j >= w[i]）
//取最大值：
//dp[i][j]=max(dp[i−1][j], dp[i−1][j−w[i]]+v[i])
//3. 初始条件
//dp[0][j] = 0：0 件物品价值为 0
//dp[i][0] = 0：容量为 0 价值为 0
public class dp_01package {
    //每件物品只能选 1 次或不选（0-1 选择）
    public static void main(String[] args) {
        // 物品重量
        int[] w = {2, 3, 4, 5};
        // 物品价值
        int[] v = {3, 4, 5, 6};
        // 背包容量
        int C = 8;

        int n = w.length;
        // dp[i][j]：前i个物品，容量j的最大价值
        int[][] dp = new int[n + 1][C + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= C; j++) {
                // 不选第i个物品
                dp[i][j] = dp[i - 1][j];
                // 能选则选
                if (j >= w[i - 1]) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - w[i - 1]] + v[i - 1]);
                }
            }
        }

        System.out.println("最大价值：" + dp[n][C]);

        // ========== 空间优化版本 ==========
        // 使用一维dp数组，从后向前遍历避免物品被重复使用
        int[] dpOptimized = new int[C + 1];
        for (int i = 0; i < n; i++) {
            // 从后向前遍历，确保每个物品只被使用一次
            for (int j = C; j >= w[i]; j--) {
                dpOptimized[j] = Math.max(dpOptimized[j], dpOptimized[j - w[i]] + v[i]);
            }
        }
        System.out.println("空间优化版本最大价值：" + dpOptimized[C]);
    }
}

