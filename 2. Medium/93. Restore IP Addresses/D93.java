import java.util.ArrayList;
import java.util.List;

class D93 {
    int n, m;
    List<String> res;
    char[] chars;

    void bt(String s, int cnt, int sIdx, int cIdx) {
        if (cnt == 4 || sIdx == n || cIdx == m) {
            if (cnt == 4 && sIdx == n && cIdx == m) {
                res.add(new String(chars));
            }
            return;
        }
        char ch = s.charAt(sIdx);
        if (cnt > 0) chars[cIdx++] = '.';
        chars[cIdx] = ch;
        if (ch == '0') {
            bt(s, cnt + 1, sIdx + 1, cIdx + 1);
        } else {
            int num = ch - '0';
            bt(s, cnt + 1, sIdx + 1, cIdx + 1);
            for (int i = 1; i < 3; i++) {
                if (cIdx + i >= m || sIdx + i >= n) break;
                ch = s.charAt(sIdx + i);
                num = num * 10 + (ch - '0');
                if (num <= 255) {
                    chars[cIdx + i] = ch;
                    bt(s, cnt + 1, sIdx + i + 1, cIdx + i + 1);
                }
            }
        }
    }

    public List<String> restoreIpAddresses(String s) {
        this.n = s.length(); this.m = n + 3;
        res = new ArrayList<>();
        chars = new char[m];
        bt(s, 0, 0, 0);
        return res;
    }
}
