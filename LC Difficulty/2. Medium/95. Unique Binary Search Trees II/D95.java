import java.util.LinkedList;
import java.util.List;

class D95 {
    public List<T95> generateTrees(int n) {
        return generateSubtrees(1, n);
    }

    private List<T95> generateSubtrees(int start, int end) {
        List<T95> result = new LinkedList<>();
        if (start > end) {
            result.add(null);
            return result;
        }

        for (int i = start; i <= end; i++) {
            List<T95> leftSubtrees = generateSubtrees(start, i - 1);
            List<T95> rightSubtrees = generateSubtrees(i + 1, end);

            for (T95 left : leftSubtrees) {
                for (T95 right : rightSubtrees) {
                    T95 root = new T95(i);
                    root.left = left;
                    root.right = right;
                    result.add(root);
                }
            }
        }
        return result;
    }
}
