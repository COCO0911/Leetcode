class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] frequencies = new int[26];
        for(char i : tasks){
            frequencies[i - 'A']++; 
        }
        
        Arrays.sort(frequencies);
        int maxCount = frequencies[25]-1;
        int idleTime = n * (maxCount);
        for(int i = 24; i >= 0; i--){
            idleTime -= Math.min(maxCount, frequencies[i]);
        }

        if(idleTime > 0){
            return idleTime + tasks.length;
        }else{
            return tasks.length;
        }
    }
}