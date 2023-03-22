/**
 * Definition for a binary tree node.
 * public class T297 {
 *     int val;
 *     T297 left;
 *     T297 right;
 *     T297(int x) { val = x; }
 * }
 */
public class D297 {

    // Encodes a tree to a single string.
    public String serialize(T297 root) {
        StringBuilder sb = new StringBuilder();
        code(root, sb);
        return sb.toString();
    }

    public void code(T297 root, StringBuilder sb){
        if(root == null){
            sb.append("#;");
            return;
        }
        else{
            sb.append(root.val);
            sb.append(";");
            code(root.left, sb);
            code(root.right, sb);
        }
    }

    // Decodes your encoded data to tree.
    public T297 deserialize(String data) {
        int pos = 0;
        T297 root = constructNode(data);
        decode(data, root);
        return root;
    }

    public void decode(String data, T297 node){
        if(node == null) return;
        T297 left = constructNode(data);
        node.left = left;
        if(left != null){
            decode(data, left);
        }
        T297 right = constructNode(data);
        
        node.right = right;
        
        if(right != null){
            decode(data, right);
        }
    }
    int pos = 0;
    private T297 constructNode(String data){
        if(pos == data.length()) return null;
        boolean negative = false;
        if(data.charAt(pos) == '#'){
            pos += 2;
            return null;
        }
        if(data.charAt(pos) == '-'){
            negative = true;
            pos ++;
        }
        int num = 0;
        while(data.charAt(pos) != ';'){
            num *= 10;
            num += (data.charAt(pos) - '0');
            pos ++;
        }
        pos ++;
        if(negative){
            num *= -1;
        }
        return new T297(num);
    }
}

// Your D297 object will be instantiated and called as such:
// D297 ser = new D297();
// D297 deser = new D297();
// T297 ans = deser.deserialize(ser.serialize(root));