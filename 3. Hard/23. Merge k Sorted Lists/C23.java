class C23 {
    public L23 mergeKLists(L23[] lists) {
        if (lists.length == 0) {
            return null;
        }
        return divide(lists, 0, lists.length - 1);
    }
    
    public L23 divide(L23[] lists, int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;
            L23 left = divide(lists, start, mid);
            L23 right = divide(lists, mid + 1, end);
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
    
    public L23 merge(L23 left, L23 right) {
        L23 result = null;
        if (left.val < right.val) {
            result = left;
            left = left.next;
        } else {
            result = right;
            right = right.next;
        }
        L23 finalResult = result;

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