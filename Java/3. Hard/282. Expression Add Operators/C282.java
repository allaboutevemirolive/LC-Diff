import java.util.ArrayList;
import java.util.List;

class C282 {
    public List<String> addOperators(String num, int target) {
        char[] arr = num.toCharArray();
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        // Start the depth-first search
        dfs(arr, target, res, sb, 0, 0, 0);
        return res;
    }

    private void dfs(char[] arr, int target, List<String> res, StringBuilder sb, int start, long val, long prev) {
        int len = sb.length();
        // Base case: if we've reached the end of the array
        if (start == arr.length) {
            // If the current value equals the target, add the expression to the result list
            if (val == target) {
                res.add(sb.toString());
            }
            return;
        }
        long cur = 0;
        for (int i = start; i < arr.length; i++) {
            // If the current number has a leading zero, break the loop
            // This is to avoid cases like 1 + 05 = 6
            if (i > start && arr[start] == '0') break;
            // Calculate the current number
            // 
            cur = cur * 10 + arr[i] - '0';
            // If this is the first number in the expression
            if (sb.length() == 0) {
                // Recursively call dfs with the current number
                dfs(arr, target, res, sb.append(cur), i + 1, val + cur, cur);
                // Reset the StringBuilder length
                sb.setLength(len);
            } else {
                // Recursively call dfs with the current number and '+' operator
                dfs(arr, target, res, sb.append('+').append(cur), i + 1, val + cur, cur);
                sb.setLength(len);
                // Recursively call dfs with the current number and '-' operator
                dfs(arr, target, res, sb.append('-').append(cur), i + 1, val - cur, -cur);
                sb.setLength(len);
                // Recursively call dfs with the current number and '*' operator
                dfs(arr, target, res, sb.append('*').append(cur), i + 1, val - prev + prev * cur, prev * cur);
                sb.setLength(len);
            }
        }
    }
}