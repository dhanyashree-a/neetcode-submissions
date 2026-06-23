

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {

        PriorityQueue<ListNode> pq =
            new PriorityQueue<>((a, b) -> a.val - b.val);

        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null) {
                pq.offer(lists[i]);
            }
        }

        ListNode dummyNode = new ListNode(-1);
        ListNode temp = dummyNode;

        while (!pq.isEmpty()) {
            ListNode node = pq.poll();

            temp.next = node;
            temp = temp.next;

            if (node.next != null) {
                pq.offer(node.next);
            }
        }

        return dummyNode.next;
    }
}