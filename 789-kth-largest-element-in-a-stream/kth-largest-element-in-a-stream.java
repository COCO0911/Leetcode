class KthLargest {
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    int k;
    public KthLargest(int k, int[] nums) {
        pq = new PriorityQueue<>();
        this.k = k;
        for (int i: nums){
            pq.offer(i);
            if (pq.size() > k){
                pq.poll();
            }
        }
    }
    
    public int add(int val) {
        if (pq.size() < k || pq.peek() < val){
             pq.offer(val);
            if (pq.size() > k){
                pq.poll();    
            }
        }
       
        return pq.peek();
       
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */