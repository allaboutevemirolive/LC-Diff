Here's a simple Java code to demonstrate the `compare` method:

```java
public class Main {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3};
        int[] nums2 = {1, 2, 4};

        int result = compare(nums1, 2, nums2, 2);

        System.out.println(result);
    }

    private static int compare(int[] nums1, int i, int[] nums2, int j) {
        int n = nums1.length;
        int m = nums2.length;

        while (i < n && j < m && nums1[i] == nums2[j]) {
            i++;
            j++;
        }

        if (i == n) {
            return -1;
        }

        if (j == m) {
            return 1;
        }

        return nums1[i] - nums2[j];
    }
}
```

In this code, we have defined an integer array `nums1` containing elements `1`, `2`, and `3`, and another integer array `nums2` containing elements `1`, `2`, and `4`. We then call the `compare()` method, passing it the arrays `nums1` and `nums2`, and the indices `2` and `2`.

The `compare()` method compares the elements at index `i` in `nums1` and index `j` in `nums2`. It continues comparing subsequent elements until either 

> it reaches the end of one of the arrays or 

> it finds two elements that are not equal. 

If it reaches the end of `nums1`, it returns `-1` to indicate that `nums1` is smaller than `nums2`. 

Similarly, if it reaches the end of `nums2`, it returns `1` to indicate that `nums2` is smaller than `nums1`. 

Otherwise, it subtracts the element at index `j` from the element at index `i` and returns the result. 

In this particular case, `compare()` will compare the elements `3` and `4` in `nums1` and `nums2`, respectively, and return `-1` since `3` is smaller than `4`. Thus, the output of the code will be `-1`.