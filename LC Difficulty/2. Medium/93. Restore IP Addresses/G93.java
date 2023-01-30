import java.util.ArrayList;
import java.util.List;

class G93 {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        backtrack(s, 0, 0, new StringBuilder(), res);
        return res;
    }
    
    private void backtrack(String s, int index, int segment, StringBuilder sb, List<String> res) {
        if (index == s.length() && segment == 4) {
            res.add(sb.toString());
            return;
        }
        
        if (index == s.length() || segment == 4) return;
        
        int len = sb.length();
        for (int i = 1; i <= 3 && index + i <= s.length(); i++) {
            String sub = s.substring(index, index + i);
            if (sub.length() > 1 && sub.charAt(0) == '0') break;
            int num = Integer.parseInt(sub);
            if (num >= 0 && num <= 255) {
                sb.append(sub);
                if (segment < 3) sb.append(".");
                backtrack(s, index + i, segment + 1, sb, res);
                sb.setLength(len);
            }
        }
    }
}