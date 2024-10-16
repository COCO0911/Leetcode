class RecentCounter {
    ArrayDeque<Integer> q;
    public RecentCounter() {
        // this.q = q;
        q = new ArrayDeque<>();
    }
    
    public int ping(int t) {
        q.offer(t);
        while(!q.isEmpty() && q.peek() < t - 3000){
            q.poll();
        }
        return q.size();
    }
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */