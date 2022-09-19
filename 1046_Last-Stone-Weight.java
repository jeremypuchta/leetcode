class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int s : stones) {
            maxHeap.add(s);
        }
        
        while (maxHeap.size() > 1) {
            int one = maxHeap.poll();
            int two = maxHeap.poll();
            if (one != two) {
                maxHeap.add(one - two);
            }
        }
        
        return maxHeap.isEmpty() ? 0 : maxHeap.peek();
    }
}
