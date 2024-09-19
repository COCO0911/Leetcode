class Solution {
    public boolean wordPattern(String pattern, String s) {
        HashMap<String, Character> wordMap = new HashMap<>();
        HashMap<Character, String> charMap = new HashMap<>();
        String[] words = s.split(" ");
        
        if (words.length != pattern.length()) return false;

        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            String curWord = words[i];

            if (!charMap.containsKey(c)){
                if (!wordMap.containsKey(curWord)){
                    wordMap.put(curWord, c);
                    charMap.put(c, curWord);
                }else {
                    return false;
                }
            }else {
                String mappedWord = charMap.get(c);
                if (!mappedWord.equals(curWord)){
                    return false;
                }
            }
        }
        return true;
    }
}