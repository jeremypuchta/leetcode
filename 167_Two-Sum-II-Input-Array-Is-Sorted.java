class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int head = 0;
        int tail = numbers.length - 1;
        
        while (head <= tail) {
            if (numbers[head] + numbers[tail] == target) {
                return new int[] {head + 1, tail + 1};
            }
            if (numbers[head] + numbers[tail] < target) {
                head++;
            } else {
                tail--;
            }
        }
        
        return null;
    }
}
