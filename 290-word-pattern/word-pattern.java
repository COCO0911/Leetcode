class Solution {
    public boolean wordPattern(String pattern, String s) {
        HashMap <Character, String> map_char = new HashMap();
        HashMap <String, Character> map_word = new HashMap();
        String[] words = s.split(" ");

        if (words.length != pattern.length()) return false;
        
        for (int i = 0; i < words.length; i++) {
            char cha = pattern.charAt(i);
            String word = words[i];
            
            if (!map_char.containsKey(cha)) {
                if (map_word.containsKey(word)) {
                    return false;
                } else {
                    map_char.put(cha, word);
                    map_word.put(word, cha);
                }
            }else {
                String mappedWord = map_char.get(cha);
                if (!mappedWord.equals(word)) {
                    return false;
                }
            }
        }
        return true;
    }
}