class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq=new int[26];
        for(char task:tasks){
            freq[task-'A']++;
        }
        Arrays.sort(freq);
        int maxf=freq[25];
        int idle=(maxf - 1)*n;
        for(int i=24;i>=0;i--){
            idle-=Math.min(freq[i],maxf-1);
        }
        idle=Math.max(0,idle);
        return tasks.length+idle;
    }
}