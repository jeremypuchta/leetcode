class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // sort array to make solution easier
        Arrays.sort(nums); 
        
        // use a linked list for O(1) insertions since we're not retrieving anyway
        List<List<Integer>> result = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            // skip duplicates
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            
            // two-pointer strategy
            int head = i + 1;
            int tail = nums.length - 1;
            while (head < tail) {
                int threeSum = nums[i] + nums[head] + nums[tail];
                if (threeSum > 0) {
                    tail--;
                } else if (threeSum < 0) {
                    head++;
                } else {
                    result.add(List.of(nums[i], nums[head], nums[tail]));
                    // update pointers - only head pointer needs to be shifted, right pointer is taking care of in the other part of the loop.
                    head++; 
                    while (nums[head] == nums[head - 1] && head < tail) {
                        head++;
                    }
                }
            }
        }
        
        return result;
    }
}
