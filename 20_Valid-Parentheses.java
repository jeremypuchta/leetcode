class Solution {
    public boolean isValid(String s) {
        if (s.startsWith("]") || s.startsWith(")") || s.startsWith("}")) return false;
        
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');
        
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char bracket = s.charAt(i);
            if (bracket == '(' || bracket == '[' || bracket == '{') {
                stack.push(bracket);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                if (map.get(bracket) != stack.pop()) {
                    return false;
                }
            }
        }
        
        if (!stack.isEmpty()) {
            return false;
        }
        
        return true;
    }
}
