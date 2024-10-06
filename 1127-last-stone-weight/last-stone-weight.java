class Solution {
    public int lastStoneWeight(int[] stones) {
        //maxHeap
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> (b-a));
        for (int i: stones){
            pq.offer(i);
            
        }
        while (pq.size() > 1){
            //poll the largest 2;
            int stone1 = pq.poll();
            int stone2 = pq.poll();
            if (stone1 != stone2){
                pq.offer(stone1 - stone2);
            }
        }
       
        if (pq.isEmpty()){
            return 0;
        }else {
            return pq.remove();
        }
    }
}