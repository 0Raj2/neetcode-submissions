class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Integer> stringMapS = new HashMap<>();
        Map<Character, Integer> stringMapT = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            if (stringMapS.containsKey(s.charAt(i))) {
                stringMapS.put(s.charAt(i), stringMapS.get(s.charAt(i)) + 1);
            } else {
                stringMapS.put(s.charAt(i), 1);
            }

            if (stringMapT.containsKey(t.charAt(i))) {
                stringMapT.put(t.charAt(i), stringMapT.get(t.charAt(i)) + 1);
            } else {
                stringMapT.put(t.charAt(i), 1);
            }
        }

        for (Map.Entry<Character, Integer> mapElement : stringMapS.entrySet()) {
            char key = mapElement.getKey();
            int value = mapElement.getValue();

            if (!(stringMapT.containsKey(key) && stringMapT.get(key).equals(value))) {
                return false;
            }
        }

        return true;
    }
}