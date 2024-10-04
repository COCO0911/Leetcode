class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        HashMap<Integer, Integer> brickAndFreq = new HashMap<>();
        int res = 0;
        for(List<Integer> brick : wall){
            int prefix = 0;
            for(int i = 0; i < brick.size()-1; i++){
                int cur = brick.get(i);
                prefix += cur;
                brickAndFreq.put(prefix, brickAndFreq.getOrDefault(prefix, 0)+1);
                res = Math.max(res, brickAndFreq.get(prefix));
            }
        }
        return wall.size() - res;
    }
}