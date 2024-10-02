class Solution {
    public int maxArea(int[] height) {
        int l = 0, r = height.length - 1;

        int maxArea = 0;
        
        while (l < r){
            int width = r - l;
            int minHeight = Math.min(height[l], height[r]);
            int curArea = minHeight * width;
            maxArea = Math.max(curArea, maxArea);

            if(height[l] < height[r]){
                l++;
            }else{
                r--;
            }
        }
        
        return maxArea;
    }
}