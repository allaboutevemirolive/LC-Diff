import java.util.ArrayList;
import java.util.List;

class C472 {
    class Node {
        boolean isEnd;
        Node[] nextNode;

        public Node() {
            nextNode = new Node[26];
        }
    }

    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        Node root = new Node();
        for (String s : words) {
            buildTrie(s, root);
        }

        List<String> res = new ArrayList<String>();
        for (String s : words) {
            if (testWord(s, root, 0)) {
                res.add(s);
            }
        }
        return res;
    }

    private void buildTrie(String s, Node root) {
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int index = c - 'a';
            if (root.nextNode[index] == null) {
                root.nextNode[index] = new Node();
            }
            root = root.nextNode[index];
            if (i == s.length() - 1)
                root.isEnd = true;

        }
    }

    private boolean testWord(String s, Node root, int j) {
        // for a word to return true -> it must either be concatenated by 1 or more
        // words, or it must be a subword
        Node curNode = root;
        for (int i = j; i < s.length(); i++) {
            char c = s.charAt(i);
            if (curNode.nextNode[c - 'a'] == null)
                return false;
            curNode = curNode.nextNode[c - 'a'];

            if (i == s.length() - 1) {
                if (curNode.isEnd) {
                    return j > 0;
                } else
                    return false;
            }
            if (curNode.isEnd && testWord(s, root, i + 1)) {
                return true;
            }
        }
        return false;
    }
}
