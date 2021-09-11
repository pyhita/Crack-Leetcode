思路解析：同样是用一个堆来维护可能产生最大元素的集合， 然后进行弹出就可以得到nth  largest 元素

```java
class Node {
        int val;
        int from_id;
        int index;

        public Node(int val, int from_id, int index) {
            this.val = val;
            this.from_id = from_id;
            this.index = index;
        }
    }


    public int KthInArrays(int[][] arrays, int k) {
        // write your code here
        int row =arrays.length;
        PriorityQueue<Node> max = new PriorityQueue<>((a, b)->(b.val-a.val));

        // inital PriorityQueue
        for (int i = 0;i < row;i++) { 
            Arrays.sort(arrays[i]);
            if (arrays[i].length > 0) {
               int index = arrays[i].length - 1;
               int from_id = i;
               int val = arrays[i][index];
               max.offer(new Node(val, from_id, index)); 
            }
        }

        // pop k-1 elements
        for (int i = 0;i < k-1;i++) {
            Node node = max.poll();
            int from_id = node.from_id;
            int index = node.index - 1;
            if (index >= 0) {
                int val = arrays[from_id][index];
                Node next = new Node(val, from_id, index);
                max.offer(next);
            }
            
        }
        return max.peek().val;
    }
```

