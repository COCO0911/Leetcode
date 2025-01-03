class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> s = new Stack<>();
        int j = 0;
        int n = pushed.length;
        for (int i : pushed){
            s.push(i);
        
            while(!s.isEmpty()&& j < n && s.peek() == popped[j]){
                
                 s.pop();
                j++;
            }
        }
        return j == n;
    }
}