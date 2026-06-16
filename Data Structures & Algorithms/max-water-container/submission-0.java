class Solution {
    public int maxArea(int[] heights) {
        int left=0; 
        int right = heights.length-1; 
        int max_water=0;
        while(left<right){
            int w=right-left;
            int h=Math.min(heights[left],heights[right]);
            int curr = w*h;
            max_water = Math.max(max_water,curr);
            if(heights[left]<heights[right]){
                left++;
            }
            else{
                right--;
            }
            
        }
        return max_water;
        
    }
}
