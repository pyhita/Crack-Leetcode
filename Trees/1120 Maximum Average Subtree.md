思路简单确定我们应该返回的信息有两种，一个是当前的sum另一个是subtree中节点的数量。因此考虑返回一个数组，用数组保存这两个值。

```java
double avg = 0.0;
public double maximumAverageSubtree(TreeNode root) {
    sumTree(root);
    return avg;
}

private int[] sumTree(TreeNode root) {
    if (root == null) return new int[2];
    
    int[] res = new int[2];
    int[] left = sumTree(root.left);
    int[] right = sumTree(root.right);
    res[0] = left[0] + right[0] + root.val;
    res[1] = left[1] + right[1] + 1;
    avg = Math.max(avg, (double)res[0] / res[1]);
    return res;
}
```





