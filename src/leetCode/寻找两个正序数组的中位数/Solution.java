package leetCode.寻找两个正序数组的中位数;
//给定两个大小为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。
//
// 请你找出这两个正序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。 
//
// 你可以假设 nums1 和 nums2 不会同时为空。 
//
// 
//
// 示例 1: 
//
// nums1 = [1, 3]
//nums2 = [2]
//
//则中位数是 2.0
// 
//
// 示例 2: 
//
// nums1 = [1, 2]
//nums2 = [3, 4]
//
//则中位数是 (2 + 3)/2 = 2.5
// 
// Related Topics 数组 二分查找 分治算法 
// 👍 2957 👎 0


import java.util.Arrays;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int length1 = nums1.length;
        int length2 = nums2.length;
        int sumLength = length1 + length2;



        int middleNum = sumLength/2;
        int flag = sumLength % 2;

        if (length1 == 0){
            if (flag == 1){
                return nums2[middleNum + 1];
            }else {
                return ((double) nums2[middleNum]+nums2[middleNum+1])/2;
            }
        }
        if (length2 == 0){
            if (flag == 1){
                return nums1[middleNum + 1];
            }else {
                return ((double) nums1[middleNum]+nums1[middleNum+1])/2;
            }
        }

        int temp = middleNum/2;
        if (temp == 0){
            temp = 1;
        }


        int t1 = 0;
        int t2 = 0;


        while (true){
            if (nums1.length - t1 - 1 < temp){
                t2 += temp;
            }else if (nums2.length - t2 < temp){
                t1 += temp;
            }else if (nums1[t1 + temp - 1] < nums2[t2 + temp -1]){
                t1 += temp;
            }else {
                t2 += temp;
            }
            if (temp == 1){
                if (flag == 1){
                    return Math.min(nums1[t1],nums2[t2]);
                }
                return ((double) nums1[t1] + nums2[t2])/2;
            }
            middleNum = middleNum - temp;
            temp = middleNum/2;
            if (temp == 0){
                temp = middleNum;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {1};
        int[] nums2 = {2,3};
        Solution solution = new Solution();
        double v = solution.findMedianSortedArrays(nums1, nums2);
        System.out.println(v);

    }
}
//leetcode submit region end(Prohibit modification and deletion)
