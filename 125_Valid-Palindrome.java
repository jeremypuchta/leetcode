class Solution {
    public boolean isPalindrome(String s) {
        String preprocessed = preprocess(s);
        
        int head = 0;
        int tail = preprocessed.length() - 1;
        while (head <= tail) {
            if (preprocessed.charAt(head) != preprocessed.charAt(tail)) {
                return false;
            }
            head++;
            tail--;
        }
        
        return true;
    }
    
    private String preprocess(String s) {
        String preprocessed = s.replaceAll("[^A-Za-z0-9]", "");
        return preprocessed.toLowerCase();
    }
}
