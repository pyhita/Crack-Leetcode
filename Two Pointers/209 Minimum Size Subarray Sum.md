解题思路：题目需要求得是一个连续区间，条件是这个连续区间的和必须大于等于给定的target。分析如下：

首先我们可以想到的一个最朴素的思路就是暴力破解法，即枚举处所有可能的区间，依次进行判断，找到长度最小的就好了，时间复杂度是O（n^2）。接下来我们考虑怎么对这种方法进行优化，假设当前遍历的的区间是（i ，j）并且发现此时这个区间的和已经满足题目条件了，那么此时意味着我们可以尝试更新min len了。更新完长度之后，我们可以考虑，i的位置应该是要向前移动的，那么j应该怎么动呢？有没有必要将j移动回到i的位置在进行扫描？考虑i，j第一次符合条件，说明i，j-1之间的数字都不符合条件，此时移除了i，我们保持j的位置不动，然后进行验证即可了。没有必要让j后移。

```java
public int minSubArrayLen(int target, int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int sum = 0;
        int j = 0, min = Integer.MAX_VALUE;
        for (int i = 0;i < nums.length;i++) {
            while (j < nums.length && sum < target) {
                sum += nums[j];
                j++;
            }
            if (sum >= target) {
                min = Math.min(min, j - i);
            }
            sum -= nums[i];
        }
        
        return min == Integer.MAX_VALUE ? 0 : min;
    }
```







