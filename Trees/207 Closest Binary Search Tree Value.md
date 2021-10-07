解题思路：从root开始寻找，如果当前target > root.val向右寻找，否则向左寻找，在寻找的过程中不断记录当前的之前的绝对值与当前遍历节点的绝对值，看看是否需要更新。

```java
int res = 0;
double min = Double.MAX_VALUE;
public int closestValue(TreeNode root, double target) {
    dfs(root, target);
    return res;
}

private void dfs(TreeNode root, double target) {
    if (root == null) return;
    if (Math.abs(target - root.val) < min) {
        min = Math.abs(target - root.val);
        res = root.val;
    }

    if (root.val > target) return dfs(root.left, target);
    else return dfs(root.right, target);
}
```

