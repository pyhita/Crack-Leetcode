先判定给定的p，q是否在tree中，如果在的话可以套用LCA模板进行求解即可。如果不在，直接返回null即可。

```java
int count = 0;
public TreeNode lowestCommonAncestor(TreeNode root, 
                                     TreeNode p, TreeNode q) {
    TreeNode lca = LCA(root, p, q);
    return count == 2 ? lca : null;
    }

public TreeNode LCA(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;
        
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        
        if (root == p || root == q) {
            count++;
            return root;
        }
        return left == null ? right : left;
    }
```

