import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class C297 {

    // Encodes a tree to a single string.
    public String serialize(T297 root) {
        StringBuilder sb = new StringBuilder();
        serializeHelper(root, sb);
        return sb.toString();
    }
    
    private void serializeHelper(T297 root, StringBuilder sb) {
        if (root == null) {
            sb.append("#,");
        } else {
            sb.append(root.val + ",");
            serializeHelper(root.left, sb);
            serializeHelper(root.right, sb);
        }
    }

    // Decodes your encoded data to tree.
    public T297 deserialize(String data) {
        Queue<String> queue = new LinkedList<>(Arrays.asList(data.split(",")));
        return deserializeHelper(queue);
    }
    
    private T297 deserializeHelper(Queue<String> queue) {
        String value = queue.poll();
        if (value.equals("#")) {
            return null;
        } else {
            T297 node = new T297(Integer.parseInt(value));
            node.left = deserializeHelper(queue);
            node.right = deserializeHelper(queue);
            return node;
        }
    }
}