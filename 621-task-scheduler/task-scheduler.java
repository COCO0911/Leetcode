class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] frequencies = new int[26];
        for(char i : tasks){
            frequencies[i - 'A']++; 
        }
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());        //start with most frequent letters

       
        for(int i = 0; i < 26; i++){
            if (frequencies[i] > 0) {
                pq.offer(frequencies[i]);
            }        
        }

        int time = 0;
        while (!pq.isEmpty()) {
            int cycle = n + 1;
            List<Integer> store = new ArrayList<>();
            int taskCount = 0;
            while( cycle-- > 0 && !pq.isEmpty()){
                int curFreq = pq.poll();
                if (curFreq > 1){
                    store.add(curFreq - 1);
                }
                taskCount++;
            }
            store.forEach(pq::offer);
            // Add time for the completed cycle
            time += (pq.isEmpty() ? taskCount : n + 1);
        }

        return time;
    }
}