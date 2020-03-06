//Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one
// sorted array. 
//
// Note: 
//
// 
// The number of elements initialized in nums1 and nums2 are m and n respectivel
//y. 
// You may assume that nums1 has enough space (size that is greater or equal to 
//m + n) to hold additional elements from nums2. 
// 
//
// Example: 
//
// 
//Input:
//nums1 = [1,2,3,0,0,0], m = 3
//nums2 = [2,5,6],       n = 3
//
//Output: [1,2,2,3,5,6]
// Related Topics Array Two Pointers


import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
//        思路1、先把第二个数组的数据拷贝到第一个数组，然后对第一个数组排序
//        for (int i = 0; i < n; i++) {
//            nums1[m + i] = nums2[i];
//        }
//        Arrays.sort(nums1);
//        for (int i = 0; i < n + m - 1; i++) {
//            for (int j = 0; j < n + m - 1 - i; j++) {
//                if (nums1[j] > nums1[j + 1]) {
//                    nums1[j] = nums1[j] + nums1[j + 1];
//                    nums1[j + 1] = nums1[j] - nums1[j + 1];
//                    nums1[j] = nums1[j] - nums1[j + 1];
//                }
//            }
//        }

//        思路2：开辟额外的空间，存放第一个数组的元素，然后进行双指针合并，时间复杂度为O(n+m)
//        int[] nums = new int[m];
//        for (int i = 0; i < m; i++) {
//            nums[i] = nums1[i];
//        }
//
//        int i = 0;
//        int j = 0;
//        int k = 0;
//        while (i < m && j < n) {
//            if (nums[i] < nums2[j]) {
//                nums1[k++] = nums[i++];
//            } else {
//                nums1[k++] = nums2[j++];
//            }
//        }
//        if (i < m) {
//            while (i < m) nums1[k++] = nums[i++];
//        } else if (j < n) {
//            while (j < n) nums1[k++] = nums2[j++];
//        }

//        思路3：不需要开辟额外的存储空间，直接在原来第一个数组的基础上进行操作
        int i = m-1;
        int j = n-1;
        int k = n + m - 1;
        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums2[j--];
            }
        }

        while (j >= 0) {
            nums1[k--] = nums2[j--];
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
