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
    
    // A recursive helper function to serialize the binary tree in pre-order traversal
    private void serializeHelper(T297 root, StringBuilder sb) {
        // If the node is null, append "#" to the string
        if (root == null) {
            sb.append("#,");
        } else {
            // Append the value of the node to the string followed by a ","
            sb.append(root.val + ",");
            // Recursively serialize the left subtree
            serializeHelper(root.left, sb);
            // Recursively serialize the right subtree
            serializeHelper(root.right, sb);
        }
    }

    // Decodes your encoded data to tree.
    public T297 deserialize(String data) {
        // Split the input string by "," and create a queue of strings
        Queue<String> queue = new LinkedList<>(Arrays.asList(data.split(",")));
        // Call the helper function to deserialize the binary tree
        return deserializeHelper(queue);
    }
    
    // A recursive helper function to deserialize the binary tree
    private T297 deserializeHelper(Queue<String> queue) {
        // Poll the first string from the queue
        String value = queue.poll();
        // If the string is "#", return null
        if (value.equals("#")) {
            return null;
        } else {
            // Otherwise, create a new node with the value of the string
            T297 node = new T297(Integer.parseInt(value));
            // Recursively deserialize the left subtree
            node.left = deserializeHelper(queue);
            // Recursively deserialize the right subtree
            node.right = deserializeHelper(queue);
            // Return the deserialized node
            return node;
        }
    }
}
