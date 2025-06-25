// 1,2,3,0,0,0
// 3,4,5

// 3,4,5
// k = -1
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1, k = n - 1, l = nums1.length - 1;
    
        while (k >= 0) {
            if (i >= 0 && nums1[i] > nums2[k]) {
                nums1[l] = nums1[i];
                i--;
            } else {
                nums1[l] = nums2[k];
                k--;
            }
            l--;
        }
    }
}