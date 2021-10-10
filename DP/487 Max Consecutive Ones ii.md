思路：当前可以有两种选择，是否行使了翻转的权利



0：已经使用了翻转的权利

1：没有使用翻转的权利

dp[i] [0]:以nums[i-1]结尾并且已经使用了翻转的权力

dp[i] [1]:以nums[i-1]结尾但是没有使用翻转的权力

转移方程如下：

if nums[i-1] == 1

dp[i] [0] = dp[i-1] [0] + 1//当前元素是1，可以将连续序列延长

dp[i] [1] = dp[i-1] [1] + 1//当前元素是1，可以将连续序列延长

else if nums[i-1] == 0

dp[i] [0] = 0//当前元素是0，并且反转权利已经被使用了，因此连续序列断开

dp[i] [1] = dp[i-1] [0] + 1 // 对当前元素行使反转权利，确保之前没用过

```java
public int findMaxConsecutiveOnes(int[] nums) {
        int n = nums.length;
        // 0:use the right 1:no
        int[][] dp = new int[n+1][2];
        for (int i = 1;i <= n;i++) {
            if (nums[i-1] == 1) {
                dp[i][1] = dp[i-1][1] + 1;
                dp[i][0] = dp[i-1][0] + 1;
            } else {
               dp[i][1] = 0;
               dp[i][0] = dp[i-1][1] + 1;
            }
        }

        int res = Integer.MIN_VALUE;
        for (int i = 1;i <= n;i++) {
            res = Math.max(res, Math.max(dp[i][0], dp[i][1]));
        }
        return res;
    }
```

