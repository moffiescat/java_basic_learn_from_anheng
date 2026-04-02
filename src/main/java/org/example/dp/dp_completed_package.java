package org.example.dp;
//完全背包：每件物品可以选择无限次
//状态定义：dp[i][j]：前 i 件物品，背包容量为 j 时的最大价值
//状态转移：
//不选：dp[i][j] = dp[i-1][j]
//选（完全背包，可以选多次）：dp[i][j] = dp[i][j - w[i]] + v[i]
//取最大值：dp[i][j] = max(dp[i-1][j], dp[i][j - w[i]] + v[i])
public class dp_completed_package {
    public static void main(String[] args) {
        // 物品重量
        int[] w = {2, 3, 4, 5};
        // 物品价值
        int[] v = {3, 4, 5, 6};
        // 背包容量
        int C = 8;

        int n = w.length;

        // ========== 二维dp版本 ==========
        int[][] dp = new int[n + 1][C + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= C; j++) {
                // 不选第i个物品
                dp[i][j] = dp[i - 1][j];
                // 选第i个物品（完全背包，可以选多次，所以用dp[i]而不是dp[i-1]）
                if (j >= w[i - 1]) {
                    dp[i][j] = Math.max(dp[i][j], dp[i][j - w[i - 1]] + v[i - 1]);
                }
            }
        }

        System.out.println("二维dp最大价值：" + dp[n][C]);

        // ========== 空间优化版本 ==========
        // 完全背包：从前往后遍历，因为每件物品可以使用多次
        int[] dpOptimized = new int[C + 1];
        for (int i = 0; i < n; i++) {
            for (int j = w[i]; j <= C; j++) {
                dpOptimized[j] = Math.max(dpOptimized[j], dpOptimized[j - w[i]] + v[i]);
            }
        }
        System.out.println("空间优化版本最大价值：" + dpOptimized[C]);
    }
}