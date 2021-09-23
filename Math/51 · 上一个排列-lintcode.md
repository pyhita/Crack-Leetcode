解题思路：和上一个排列正好相反，所有的步骤取反就好了。

```java
public List<Integer> previousPermuation(List<Integer> nums) {
        // write your code here
        // step1 : find index
        int index = nums.size() - 2;
        while (index >= 0 && nums.get(index) <= nums.get(index + 1)) 
            index--;
        if (index == -1) {
          Collections.sort(nums, Collections.reverseOrder());
          return nums;
        }

        // step2: find first smaller
        int firstSmaller = nums.size() - 1;
        while (firstSmaller >= index - 1) {
            if (nums.get(firstSmaller) < nums.get(index)) 
                break;
            firstSmaller--;
        }

        // swap
        int temp = nums.get(firstSmaller);
        nums.set(firstSmaller, nums.get(index));
        nums.set(index, temp);

        // reverse
        int start = index + 1, end = nums.size() - 1;
        while (start < end) {
            temp = nums.get(start);
            nums.set(start, nums.get(end));
            nums.set(end, temp);
            start++;
            end--;
        }
        return nums;
    }
```

