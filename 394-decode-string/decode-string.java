class Solution {
    public String decodeString(String s){
        ArrayDeque<Character> stack = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ']'){
                ArrayList<Character> decodeStr = new ArrayList<>();

                while (stack.peek() != '['){
                    decodeStr.add(stack.pop());
                }
                //pop '['
                stack.pop();

                int base = 1;
                int k = 0;
                
                while (!stack.isEmpty() && Character.isDigit(stack.peek())){
                    k = k + (stack.pop() - '0') * base;
                    base *= 10;
                }
                
                while (k != 0) {
                    for (int j = decodeStr.size() - 1; j >= 0; j--){
                        stack.push(decodeStr.get(j));
                    }
                    k--;
                }
                
            }else{
                stack.push(s.charAt(i));
            }
        }
        char[] res = new char[stack.size()];
        for (int i = res.length - 1; i >= 0; i--) {
            res[i] = stack.pop();
        }
        return new String(res);
    }
}