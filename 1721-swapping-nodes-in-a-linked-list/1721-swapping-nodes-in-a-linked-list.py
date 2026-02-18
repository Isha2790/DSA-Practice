class Solution:
    def swapNodes(self, head: Optional[ListNode], k: int) -> Optional[ListNode]:
        first = last = head
        for _ in range(k - 1):
            first = first.next
        
        temp = first
        while temp.next:
            temp = temp.next
            last = last.next
        
        first.val, last.val = last.val, first.val
        return head