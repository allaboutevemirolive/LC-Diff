public class B297 {
    // Encodes a tree to a single string.
    public String serialize(T297 root) {
        StringBuilder sb = new StringBuilder();
        traverse(root, sb);
        return sb.toString();
    }

    private void traverse(T297 cur, StringBuilder sb) {
        if (cur == null) {
            sb.append('N');
            return;
        }
        sb.append('k');
        sb.append((char) (cur.val >>> 16));
        sb.append((char) (cur.val));
        traverse(cur.left, sb);
        traverse(cur.right, sb);
    }

    // Decodes your encoded data to tree.
    public T297 deserialize(String data) {
        return build(data);
    }

    int from = 0;

    private T297 build(String data) {
        if (data.charAt(from) == 'N') {
            from++;
            return null;
        }
        int val = ((data.charAt(from + 1)) << 16) | data.charAt(from + 2);
        from += 3;
        T297 node = new T297(val);
        node.left = build(data);
        node.right = build(data);
        return node;
    }
}