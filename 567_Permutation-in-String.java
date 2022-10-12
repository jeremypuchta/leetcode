class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }
        
        // setup two arrays of the size of the alphabet
        int[] s1Count = new int[26];
        int[] s2Count = new int[26];
        
        // keep track of each characters occurence 
        for (int i = 0; i < s1.length(); i++) {
            s1Count[s1.charAt(i) - 'a']++;
            s2Count[s2.charAt(i) - 'a']++;
        }
        
        // count the number of matches in both arrays - if 26 there's a permutation
        int matches = 0;
        for (int i = 0; i < 26; i++) {
            if (s1Count[i] == s2Count[i]) {
                matches++;
            }
        }
        
        for (int i = 0; i < s2.length() - s1.length(); i++) {
            int l = s2.charAt(i) - 'a';
            int r = s2.charAt(i + s1.length())  - 'a';
            
            // if number of matches is 26 there's a valid permutation 
            if (matches == 26) return true;
            
            // increase the count of right pointers character by 1
            s2Count[r]++;
            
            // if number of occurences are now the same increment the number of matches
            if (s1Count[r] == s2Count[r]) {
                matches++;
            } else if (s1Count[r] + 1 == s2Count[r]) {
                matches--;
            }
            s2Count[l]--;
            if (s1Count[l] == s2Count[l]) {
                matches++;
            } else if (s1Count[l] - 1 == s2Count[l]) {
                matches--;
            }
        }
        
        return matches == 26;
    }
}
