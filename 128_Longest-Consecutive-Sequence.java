class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        
        int longestSequence = 0;
        for (int num : nums) {
            if (!set.contains(num - 1)) {
                int length = 0;
                while (set.contains(num + length)) {
                    length++;
                }
                longestSequence = Math.max(longestSequence, length);
            }
        }
        
        return longestSequence;
    }
}
