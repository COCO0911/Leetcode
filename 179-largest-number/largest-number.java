class Solution {
    public String largestNumber(int[] nums) {
        String[] str = new String[nums.length];

        for (int i = 0; i < nums.length; i++){
            str[i] = Integer.toString(nums[i]);
        }

        Arrays.sort(str, (a, b) -> (b + a).compareTo(a + b));
        if (str[0].equals("0")){
            return "0";
        }

        StringBuilder maxNum = new StringBuilder();
        for (String n : str){
            maxNum.append(n);
        }

        return maxNum.toString();

    }
}

//[10,2]
// [3,30,34,5,9] 

// 9 5 34 3 30
