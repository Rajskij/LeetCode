

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int l = nums.length;
        int[] arr = new int[l];
        Arrays.fill(arr, 1);

        int cur = 1;
        for (int i = 0; i < l; i++) {
            arr[i] *= cur;
            cur *= nums[i];
        }

        cur = 1;
        for (int i = l - 1; i >= 0; i--) {
            arr[i] *= cur;
            cur *= nums[i];    
        }

        return arr;
    }
}