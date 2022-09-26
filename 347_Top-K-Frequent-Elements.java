class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>();
        
        for (int num : nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }
        
        Queue<Map.Entry<Integer, Integer>> maxHeap = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        
        for (Map.Entry entry : count.entrySet()) {
            maxHeap.add(entry);
        }
        
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = maxHeap.poll().getKey();
        }
        
        return result;
    }
}
