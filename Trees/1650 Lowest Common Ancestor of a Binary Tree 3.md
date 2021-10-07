这种给了parent的情况可以直接转换成了两个list找公共节点的问题。

```java
 public TreeNode lowestCommonAncestor(Node p, Node q) {
     Node a = p, b = q;
     while (a != b) {
         a = a == null ? q : a.next;
         b = b == null ? p : b.next;
     }
     return a;
   }
```

