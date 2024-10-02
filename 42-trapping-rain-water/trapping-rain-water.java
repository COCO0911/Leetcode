class Solution {
    public int trap(int[] height) {
        int l = 0, r = height.length - 1;

        int res = 0;
        int maxLeft = 0, maxRight = 0;

        while (l < r){
            if (height[l] < height[r]){
                
                maxLeft = Math.max(height[l], maxLeft);
                res += maxLeft - height[l];
                l++;
            }else {
                
                maxRight = Math.max(height[r], maxRight);
                res += maxRight - height[r];
                r--;
            }
        }
        return res;
    }
}