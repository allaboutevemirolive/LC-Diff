class C23 {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        return divide(lists, 0, lists.length - 1);
    }
    
    public ListNode divide(ListNode[] lists, int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;
            ListNode left = divide(lists, start, mid);
            ListNode right = divide(lists, mid + 1, end);
            if (left == null) {
                return right;
            } else if (right == null) {
                return left;
            } else {
                return merge(left, right);
            }
        } else {
            return lists[start];
        }
    }
    
    public ListNode merge(ListNode left, ListNode right) {
        ListNode result = null;
        if (left.val < right.val) {
            result = left;
            left = left.next;
        } else {
            result = right;
            right = right.next;
        }
        ListNode finalResult = result;

        while(left != null || right != null) {
            if (left == null) {
                result.next = right;
                result = result.next;
                right = right.next;
                continue;
            }

            if (right == null) {
                result.next = left;
                result = result.next;
                left = left.next;
                continue;
            }

            if (left.val < right.val) {
                result.next = left;
                left = left.next;
            } else {
                result.next = right;
                right = right.next;
            }
            result = result.next;
        }
        
        return finalResult;
    }
}